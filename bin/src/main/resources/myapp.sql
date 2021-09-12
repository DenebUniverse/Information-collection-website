/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.34-log : Database - mydb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mydb` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `mydb`;

/*Table structure for table `collect` */

DROP TABLE IF EXISTS `collect`;

CREATE TABLE `collect` (
  `collectId` bigint(20) NOT NULL AUTO_INCREMENT,
  `collectName` varchar(50) NOT NULL,
  `details` varchar(300) DEFAULT NULL,
  `colLen` int(2) DEFAULT NULL,
  `rowLen` int(2) DEFAULT NULL,
  `colList` varchar(500) DEFAULT NULL,
  `rowLIst` varchar(500) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `ddl` datetime DEFAULT NULL,
  `collecter` varchar(20) NOT NULL,
  `uniqueFlag` tinyint(1) NOT NULL,
  `forbidFlag` tinyint(1) NOT NULL,
  PRIMARY KEY (`collectId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `collect` */

insert  into `collect`(`collectId`,`collectName`,`details`,`colLen`,`rowLen`,`colList`,`rowLIst`,`createdTime`,`ddl`,`collecter`,`uniqueFlag`,`forbidFlag`) values (1,'补课时间安排','下周5天选一节课补课90分钟',5,5,'周一,周二,周三,周四,周五','8:00-9:30,9:50-11:20,13:30-15:00,15:20-16:50,18:30-20:00','2021-06-22 00:00:00','2021-06-24 00:00:00','刘老师',0,1);

/*Table structure for table `forbid` */

DROP TABLE IF EXISTS `forbid`;

CREATE TABLE `forbid` (
  `forbidId` bigint(20) NOT NULL AUTO_INCREMENT,
  `collectId` bigint(20) NOT NULL,
  `details` varchar(300) DEFAULT NULL,
  `col` int(2) DEFAULT NULL,
  `row` int(2) DEFAULT NULL,
  PRIMARY KEY (`forbidId`),
  KEY `collectId` (`collectId`),
  CONSTRAINT `forbid_ibfk_1` FOREIGN KEY (`collectId`) REFERENCES `collect` (`collectId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

/*Data for the table `forbid` */

insert  into `forbid`(`forbidId`,`collectId`,`details`,`col`,`row`) values (13,1,'',5,5),(14,1,'',5,4);

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `projectId` bigint(20) NOT NULL AUTO_INCREMENT,
  `projectName` varchar(50) NOT NULL,
  `details` varchar(300) DEFAULT NULL,
  `colLen` int(2) DEFAULT NULL,
  `rowLen` int(2) DEFAULT NULL,
  `colList` varchar(500) DEFAULT NULL,
  `rowList` varchar(500) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `ddl` datetime DEFAULT NULL,
  `manager` varchar(20) NOT NULL,
  PRIMARY KEY (`projectId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `project` */

insert  into `project`(`projectId`,`projectName`,`details`,`colLen`,`rowLen`,`colList`,`rowList`,`createdTime`,`ddl`,`manager`) values (1,'信息系统建设',NULL,12,8,'第1周,第2周,第3周,第4周,第5周,第6周,第7周,第8周,第9周,第10周,第11周,第12周','硬件选择,软件设计,安装硬件活动,编码和测试软件,文件收集,编写用户手册,用户培训,安装和测试系统','2021-06-23 00:00:00','2021-09-23 00:00:00','陈经理');

/*Table structure for table `submit` */

DROP TABLE IF EXISTS `submit`;

CREATE TABLE `submit` (
  `submitId` bigint(20) NOT NULL AUTO_INCREMENT,
  `collectId` bigint(20) NOT NULL,
  `details` varchar(300) DEFAULT NULL,
  `col` int(2) DEFAULT NULL,
  `row` int(2) DEFAULT NULL,
  `finishedTime` datetime DEFAULT NULL,
  `submitter` varchar(20) NOT NULL,
  PRIMARY KEY (`submitId`),
  KEY `collectId` (`collectId`),
  CONSTRAINT `submit_ibfk_1` FOREIGN KEY (`collectId`) REFERENCES `collect` (`collectId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

/*Data for the table `submit` */

insert  into `submit`(`submitId`,`collectId`,`details`,`col`,`row`,`finishedTime`,`submitter`) values (1,1,'',1,1,'2021-06-30 10:18:14','李世杰'),(2,1,'',1,1,'2021-06-30 10:30:35','李世杰'),(3,1,'',3,5,'2021-06-30 10:44:31','李世杰'),(5,1,'',1,1,'2021-06-30 11:41:19','unknown'),(6,1,'',3,2,'2021-06-30 12:03:52','unknown'),(7,1,'',1,1,'2021-06-30 12:04:55','unknown'),(8,1,'',2,1,'2021-06-30 23:14:42',''),(9,1,'',5,5,'2021-07-03 09:47:35','');

/*Table structure for table `taskplan` */

DROP TABLE IF EXISTS `taskplan`;

CREATE TABLE `taskplan` (
  `planId` bigint(20) NOT NULL AUTO_INCREMENT,
  `projectId` bigint(20) NOT NULL,
  `details` varchar(300) DEFAULT NULL,
  `taskName` varchar(50) DEFAULT NULL,
  `taskNumber` int(2) DEFAULT NULL,
  `startedTime` int(2) DEFAULT NULL,
  `period` int(2) DEFAULT NULL,
  `quota` float DEFAULT NULL,
  `cost` float DEFAULT NULL,
  `submitter` varchar(50) NOT NULL,
  PRIMARY KEY (`planId`),
  KEY `projectId` (`projectId`),
  CONSTRAINT `taskplan_ibfk_1` FOREIGN KEY (`projectId`) REFERENCES `project` (`projectId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

/*Data for the table `taskplan` */

insert  into `taskplan`(`planId`,`projectId`,`details`,`taskName`,`taskNumber`,`startedTime`,`period`,`quota`,`cost`,`submitter`) values (1,1,NULL,'硬件选择',1,1,6,160,3,'张三'),(2,1,NULL,'软件设计',2,1,4,240,4,'李四'),(3,1,'前置任务A','安装硬件活动',3,7,3,400,2,'张三'),(4,1,'前置任务B','编码和测试软件',4,5,4,800,1,'王五'),(5,1,'前置任务B','文件收集',5,5,3,320,1,'赵六'),(6,1,NULL,'编写用户手册',6,1,10,320,1,'刘二'),(7,1,'前置任务EF','用户培训',7,11,2,400,2,'王五'),(8,1,'前置任务CD','安装和测试系统',8,10,2,160,1,'赵六');

/*Table structure for table `taskreal` */

DROP TABLE IF EXISTS `taskreal`;

CREATE TABLE `taskreal` (
  `taskId` bigint(20) NOT NULL AUTO_INCREMENT,
  `projectId` bigint(20) NOT NULL,
  `details` varchar(300) DEFAULT NULL,
  `taskName` varchar(50) DEFAULT NULL,
  `taskNumber` int(2) DEFAULT NULL,
  `startedTime` int(2) DEFAULT NULL,
  `period` int(2) DEFAULT NULL,
  `quota` float DEFAULT NULL,
  `cost` float DEFAULT NULL,
  `submitter` varchar(20) NOT NULL,
  PRIMARY KEY (`taskId`),
  KEY `projectId` (`projectId`),
  CONSTRAINT `taskreal_ibfk_1` FOREIGN KEY (`projectId`) REFERENCES `project` (`projectId`),
  CONSTRAINT `taskreal_ibfk_2` FOREIGN KEY (`taskId`) REFERENCES `taskplan` (`planId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `taskreal` */

insert  into `taskreal`(`taskId`,`projectId`,`details`,`taskName`,`taskNumber`,`startedTime`,`period`,`quota`,`cost`,`submitter`) values (1,1,'','硬件选择',1,1,6,120,2,'张三');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
