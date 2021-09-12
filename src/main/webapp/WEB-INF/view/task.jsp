<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${project.projectname}任务计划与完成情况</title>
</head>
<body>
<h1>${project.projectname}项目</h1>
<h3>任务计划</h3>
<table border="1">
<tr>
<th>计划编号</th><th>计划名称</th><th>详细介绍</th>
<th>计划开始时间</th><th>计划时长</th>
<th>计划工作量</th><th>计划成本</th><th>提交人</th>
<th>删除</th>
</tr>
<c:forEach var="plan" items="${plans}">
<tr>
<td>${plan.tasknumber}</td><td>${plan.taskname}</td><td>${plan.details}</td>
<td>${plan.startedtime}</td><td>${plan.period}</td>
<td>${plan.quota}</td><td>${plan.cost}</td><td>${plan.submitter}</td>
<td><a href="delete_plan?planid=${plan.planid}&projectid=${project.projectid}">删除</a></td>
</tr>
</c:forEach>
</table>
<p></p>
<h3>增加计划</h3>
<form method="post" action="add_plan">
<p>
<input type="hidden" name="projectid" value="${project.projectid}"/></p>
<p>任务编号: <input type="text" name="tasknumber"/></p>
<p>任务名称: <input type="text" name="taskname"/></p>
<p>详细介绍: <input type="text" name="details"/></p>
<p>开始时间: <input type="text" name="startedtime"/></p>
<p>任务时长: <input type="text" name="period"/></p>
<p>任务工作量: <input type="text" name="quota"/></p>
<p>任务成本: <input type="text" name="cost"/></p>
<p>提交人: <input type="text" name="submitter"/></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="submit" value="提交"/></p>
</form>
<h3>完成情况</h3>
<table border="1">
<tr>
<th>计划编号</th><th>计划名称</th><th>详细介绍</th>
<th>计划开始时间</th><th>计划时长</th>
<th>计划工作量</th><th>计划成本</th><th>提交人</th>
<th>删除</th>
</tr>
<c:forEach var="task" items="${tasks}">
<tr>
<td>${task.tasknumber}</td><td>${task.taskname}</td><td>${task.details}</td>
<td>${task.startedtime}</td><td>${task.period}</td>
<td>${task.quota}</td><td>${task.cost}</td><td>${task.submitter}</td>
<td><a href="delete_task?taskid=${task.taskid}&projectid=${project.projectid}">删除</a></td>
</tr>
</c:forEach>
</table>
<p></p>
<h3>增加进度</h3>
<form method="post" action="add_task">
<p>
<input type="hidden" name="projectid" value="${project.projectid}"/></p>
<p>任务编号: <input type="text" name="tasknumber"/></p>
<p>任务名称: <input type="text" name="taskname"/></p>
<p>详细介绍: <input type="text" name="details"/></p>
<p>开始时间: <input type="text" name="startedtime"/></p>
<p>任务时长: <input type="text" name="period"/></p>
<p>任务工作量: <input type="text" name="quota"/></p>
<p>任务成本: <input type="text" name="cost"/></p>
<p>提交人: <input type="text" name="submitter"/></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="submit" value="提交"/></p>
</form>

<h2>计划实际对比</h2>
<p></p>
<h3>任务计划表</h3>
 
<table border="1">
    <thead>
        <tr>
        <th>${planTable.getTableName()}</th>
        <c:forEach var="i" begin="0" end="${planTable.getColLen()-1}">
            <th>${planTable.getColNames()[i]}</th>
        </c:forEach>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="i" begin="0" end="${planTable.getRowLen()-1}">
		<tr>
			<td>${planTable.getRowNames()[i]}</td>
            <c:forEach var="j" begin="0" end="${planTable.getColLen()-1}">
            <td>
				${planTable.getMatrix()[i][j]}
            </td>
            </c:forEach>
        </tr>
        </c:forEach>
    </tbody>
</table>


<p></p>
<h3>完成进度表</h3>

<table border="1">
    <thead>
        <tr>
        <th>${taskTable.getTableName()}</th>
        <c:forEach var="i" begin="0" end="${taskTable.getColLen()-1}">
            <th>${taskTable.getColNames()[i]}</th>
        </c:forEach>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="i" begin="0" end="${taskTable.getRowLen()-1}">
		<tr>
			<td>${taskTable.getRowNames()[i]}</td>
            <c:forEach var="j" begin="0" end="${taskTable.getColLen()-1}">
            <td>
				${taskTable.getMatrix()[i][j]}
            </td>
            </c:forEach>
        </tr>
        </c:forEach>
    </tbody>
</table>
<p></p>


 
<p></p>
<h3><a href="homepage">返回首页</a></h3>
<h3><a href="project">返回信息收集页面</a></h3>

</body>
</html>