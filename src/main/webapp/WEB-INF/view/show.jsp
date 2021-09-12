<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Pezone - Creative Agency HTML Template</title>
<%--
<link rel="icon" href="assets/img/fav.png" type="image/gif" sizes="20x20">
<!-- Font Awesome CSS -->
<link rel="stylesheet" href="static/css/all.css">
<!-- Magnific Popup CSS -->
<link rel="stylesheet" href="static/css/magnific-popup.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<!-- Animate CSS -->
<link rel="stylesheet" href="static/css/animate.css">
<!-- Preloader CSS -->
<link rel="stylesheet" href="static/css/preloader.css">
<!-- Slicknav CSS -->
<link rel="stylesheet" href="static/css/slicknav.min.css">
<!-- Main CSS -->
<link rel="stylesheet" href="static/css/style.css">
<!-- Responsive CSS -->
<link rel="stylesheet" href="static/css/responsive.css">
<!-- My CSS -->
<link rel="stylesheet" href="static/css/mycss.css">
--%>
</head>
<body>
 
<div id="loader-wrapper">
	<div id="loader"></div> 
	<div class="loader-section section-left"></div>
    <div class="loader-section section-right"></div> 
</div>

<!-- Header area -->
<header>

<!-- Hero area -->
<div class="hero-area">
	<div class="hero-bg"></div>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-xl-8 col-lg-8 col-sm-12 col-12">
				<div class="hero-content text-center">
					<h1>新疆棉事件舆情分析及可视化</h1>
					<p></p>
					<p>
2021年3月24日，瑞士良好棉花发展协会与HM、匡威、阿迪达斯等协会会员陆续发表“不采购新疆产品或原材料”的声明引发了中国网民广泛的舆论声讨与商业抵制。
这是继2012年以来全球最大的商业抵制活动。它即包含了普通大众、媒体、企业、外交都等多主体间的激烈互动，也展现了出当前网络空间下，线上舆论对线下行为的巨大影响力。
</p>
<p>
本作品旨在利用各种数据分析方法，以外媒与中国民众为研究对象，
可视化新疆棉事件的舆情，直观展示舆论走势与民众的呼声。
					</p>
				</div>
			</div>
		</div>
	</div>
</div>
</header>

<p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p>
<h1 align="center">舆论源头：Allsides新闻分析</h1>
<!-- Cta box -->
<section>
<div class="cta-box mt-90">
<h1></h1>
<h2 align="center">新闻词频统计</h2>
	<div class="container">
		<div style="display: flex;justify-content: flex-start;">
			
				<div class="single-cta-box">
					<div class="cta-box-content text-center">
					<div class="cta-box-icon">
						<img src="static/images/Adj. frequency from reports.jpg" width=420 alt=""/>
					</div>
						<h3>形容词词频统计</h3>
						<p>
						形容词反映人们关心事件的层面与态度
						</p>
						<p>
						结果显示，美媒在主要道德层面上对中国进行了抨击并持否定态度
						</p>
					</div>
				</div>
			
			
				<div class="single-cta-box">
					<div class="cta-box-content text-center">
						<div class="cta-box-icon">
							<img src="static/images/N. frequency from reports.jpg" width=360 alt="">
						</div>
						<h3>名词词频统计</h3>
						<p>
						名词反映事件相关的主体
						</p>
						<p>
						结果显示，高频出现的词大多与中国和美国相关，可见报道对中国和美国进行了大量荒谬、别有用心的对比。
						</p>
					</div>
				</div>
			
		</div>
	</div>
</div>
</section>

<!-- 语义分析 -->
<section class="about-area about-area-2 ">
<h2 align="center">语义聚类与政治倾向分析</h2>
<div align="center">
<img src="static/images/分析框架.PNG" />
<p>分析框架</p>
<p></p>
<p>
对语料库中的单词编码后进行word2vec处理，将单词向量化，并利用tf-Idf(词频逆向文本频率算法)确定了每条新闻中每个单词的权重。最后以每篇新闻的单词向量与各单词权重为输入数据,使用k-means算法将语义聚类。
</p>
<p>结果如下</p>
</div>
<div class="cta-box mt-90">
	<div class="container">
		<div class="row">
			<div class="col-xl-4 col-lg-4 col-sm-12 col-12">
				<div class="single-cta-box">
					<div class="cta-box-content text-center">
						<div class="cta-box-icon">
						<img class="center-cropped" src="static/picture/cluster 0.jpg" />
						</div>
						<h3>Cluster 0</h3>
						<p>
						这一类中，政治倾向偏向左翼势力，大多数都是体现左翼势力和中立的新闻报道
						</p>
					</div>
				</div>
			</div>
			<div class="col-xl-4 col-lg-4 col-sm-12 col-12">
				<div class="single-cta-box">
					<div class="cta-box-content text-center">
						<div class="cta-box-icon">
							<img class="center-cropped" src="static/picture/cluster 1.jpg" alt="">
						</div>
						<h3>Cluster 1</h3>
						<p>
						这一类中，政治倾向偏向右翼势力，大多数都是体现右翼势力和中立的新闻报道
						</p>
					</div>
				</div>
			</div>
			<div class="col-xl-4 col-lg-4 col-sm-12 col-12">
				<div class="single-cta-box">
					<div class="cta-box-content text-center">
						<div class="cta-box-icon">
							<img class="center-cropped" src="static/picture/cluster 2.jpg" alt="">
						</div>
						<h3>Cluster 2</h3>
						<p>
						这一类中，政治倾向偏向中立，大多数都是中立的新闻报道，剩下有稍微偏向左翼和右翼的报道数量大体相等
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</section>

<p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p>
<h1 align="center">舆论结果：微博舆情分析</h1>

<!--日统计-->
<section class="about-area about-area-2 ">
<h1></h1>
<h2 align="center">日统计</h2>
<div id="my_div">
<table border="0" align="center">
<tr>
<td id="my_td">
<img src="static/images/时间/微博数日统计图.png"/>
<p>微博数日统计图</p>
</td>
<td id="my_td">
<img src="static/images/时间/评论数日统计图.png" />
<p>评论数日统计图</p>
</td>
</tr>
<tr>
<td id="my_td">
<img src="static/images/时间/点赞数日统计图.png" />
<p>点赞数日统计图</p>
</td>
<td id="my_td">
<img src="static/images/时间/转发数日统计图.png" />
<p>转发数日统计图</p>
</td>
</tr>
</table>
</div>
</section>

<!--gif-->
<section class="about-area about-area-2 ">
<h1></h1>
<h2 align="center">动态条形图</h2>
<div id="my_div">
<table border="0" align="center">
<tr>
<td id="my_td">
<img src="static/images/时间/微博数动态条形图.gif"/>
<p>微博数动态条形图</p>
</td>
<td id="my_td">
<img src="static/images/时间/评论数动态条形图.gif" />
<p>评论数动态条形图</p>
</td>
</tr>
</table>
<table border="0" align="center">
<tr>
<td id="my_td">
<img src="static/images/时间/点赞数动态条形图.gif" />
<p>点赞数动态条形图</p>
</td>
<td id="my_td">
<img src="static/images/时间/转发数动态条形图.gif" />
<p>转发数动态条形图</p>
</td>
</tr>
</table>
</div>
</section>

<!--地理-->
<section class="about-area about-area-2 ">
<h1></h1>
<h2 align="center">地理</h2>
<div id="my_div">
<table border="0" align="center">
<tr>
<td id="my_td">
<img src="static/images/地理/新疆棉微博地图.png"/>
<p>新疆棉微博地图</p>
</td>
<td id="my_td">
<img src="static/images/地理/匡威微博地图.png" />
<p>匡威微博地图</p>
</td>
<td id="my_td">
<img src="static/images/地理/优衣库微博地图.png" />
<p>优衣库微博地图</p>
</td>
</tr>
</table>
</div>
</section>

<!--词云-->
<section class="about-area about-area-2 ">
<p></p><p></p><p></p><p></p><p></p>
<h2 align="center">微博词云</h2>
<div id="my_div">
<table border="0" align="center">
<tr>
<td id="my_td">
<img src="static/images/词云/新疆棉微博词云.png"/>
<p>新疆棉微博词云</p>
</td>
<td id="my_td">
<img src="static/images/词云/HM微博词云.png" />
<p>HM微博词云</p>
</td>
<td id="my_td">
<img src="static/images/词云/阿迪达斯微博词云.png" />
<p>阿迪达斯微博词云</p>
</td>
</tr>
<tr>
<td id="my_td">
<img src="static/images/词云/匡威微博词云.png" />
<p>匡威微博词云</p>
</td>
<td id="my_td">
<img src="static/images/词云/耐克微博词云.png" />
<p>耐克微博词云</p>
</td>
<td id="my_td">
<img src="static/images/词云/优衣库微博词云.png" />
<p>优衣库微博词云</p>
</td>
</tr>
</table>
</div>
</section>

<!--语义网络-->
<section class="about-area about-area-2 ">
<h1></h1>
<h2 align="center">语义网络</h2>
<div id="my_div">
<table border="0" align="center">
<tr>
<td id="my_td">
<img src="static/images/网络/新疆棉语义网络.jpg"/>
<p>新疆棉语义网络</p>
</td>
<td id="my_td">
<img src="static/images/网络/匡威语义网络.jpg" />
<p>匡威语义网络</p>
</td>
<td id="my_td">
<img src="static/images/网络/HM语义网络.jpg" />
<p>HM语义网络</p>
</td>
</tr>
</table>
</div>
</section>



<!-- footer -->
<footer id="foot">
	<div class="footer-area">
		<div class="container">
			<div class="row">
				<div class="col-xl-4 col-lg-4 col-sm-12 col-12">
					<div class="footer-box">
						<div class="copy-right text-left">
							<p>© 2021, All Rights Reserved</p>
						</div>
					</div>
				</div>
				<div class="col-xl-8 col-lg-8 col-sm-12 col-12">
					<div class="footer-box">
						<div class="footer-right text-right">
							<ul>
								<li></li>
								<li></li>
								<li></li>
								<li></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</footer>


<!-- jQuery -->
<script src="static/js/jquery-3.6.0.min.js"></script>
<!-- Popper JS -->
<script src="static/js/popper.min.js"></script>
<!-- Bootstrap JS -->		
<script src="static/js/bootstrap.min.js"></script>
<!-- Magnific Popup JS -->
<script src="static/js/jquery.magnific-popup.min.js"></script>
<!-- Mixitup JS -->
<script src="static/js/jquery.mixitup.min.js"></script>
<!-- Wow JS -->
<script src="static/js/wow.min.js"></script>
<!-- Slicknav JS -->
<script src="static/js/jquery.slicknav.min.js"></script>

<!-- Preloder JS -->
<script src="static/js/preloader.js"></script>
<!-- Typed js -->
<script src="static/js/typed.js"></script>
<!-- Main JS -->
<script src="static/js/main.js"></script>

</body>
</html>
