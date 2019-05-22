<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.passer.domain.Comment"%>
<%@ page import="com.passer.utils.crawl.CommentsCrawl"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon"
	href="${pageContext.request.contextPath }/images/favicon.ico">
<link rel="stylesheet" href="assets/css/style.css">

<title>Document Storm</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath }/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link
	href="${pageContext.request.contextPath }/assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="${pageContext.request.contextPath }/asserts/css/offcanvas.css"
	rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script
	src="${pageContext.request.contextPath }/assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<%
	Comment comment = CommentsCrawl.getComment();
	pageContext.setAttribute("comment", comment);
%>
<body>
	<nav class="navbar navbar-fixed-top navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Document Storm</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">About</a></li>
					<li><a href="mailto:ipasser@sina.cn">Contact</a></li>
				</ul>
			</div>
			<!-- /.nav-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<!-- /.navbar -->

	<hr />

	<div class="container">

		<div class="row row-offcanvas row-offcanvas-right">

			<div class="col-xs-12">
				<p class="pull-right visible-xs">
					<button type="button" class="btn btn-primary btn-xs"
						data-toggle="offcanvas">Toggle nav</button>
				</p>
				<div class="jumbotron">
					<h1>Hello, world!</h1>
					<p>This is a site to convert document format</p>
				</div>
				<div class="row">
					<div class="col-sm-9">
						<p class="text-center">
							<img alt="docstorm"
								src="${pageContext.request.contextPath }/images/docstorm.png">
						</p>
						<br />
						<div class="row trans-table">
							<div class="col-xs-6 col-lg-4">
								<div class="item">
									<h2>PDF to Word</h2>
									<p>PDF文档转换成Word文档，还可以选择生成word的字体.</p>
									<p>
										<a class="btn btn-default"
											href="${pageContext.request.contextPath }/dispatcher?opt=pdf2doc"
											role="button">文件上传 &raquo;</a>
									</p>
								</div>
							</div>
							<div class="col-xs-6 col-lg-4">
								<div class="item">
									<h2>MD to PDF</h2>
									<p>将Markdown格式文档完美渲染为PDF.</p>
									<p>
										<a class="btn btn-default"
											href="${pageContext.request.contextPath }/dispatcher?opt=md2pdf"
											role="button">文件上传 &raquo;</a>
									</p>
								</div>
							</div>
							<div class="col-xs-6 col-lg-4">
								<div class="item">
									<h2>MD to HTML</h2>
									<p>将Markdown格式文档完美渲染为HTML.</p>
									<p>
										<a class="btn btn-default"
											href="${pageContext.request.contextPath }/dispatcher?opt=md2html"
											role="button">文件上传 &raquo;</a>
									</p>
								</div>
							</div>
							<div class="col-xs-6 col-lg-4">
								<div class="item">
									<h2>Word Translate</h2>
									<p>将Word翻译为指定的语言，目前只支持Word文档英文转中文.</p>
									<p>
										<a class="btn btn-default"
											href="${pageContext.request.contextPath }/dispatcher?opt=word_translate"
											role="button">文件上传 &raquo;</a>
									</p>
								</div>
							</div>
							<div class="col-xs-6 col-lg-4">
								<div class="item">
									<h2>HTML to PDF</h2>
									<p>将本地的HTML文件或者指定url的网页转成PDF文件.</p>
									<p>
										<a class="btn btn-default"
											href="${pageContext.request.contextPath }/dispatcher?opt=html2pdf"
											role="button">文件上传 &raquo;</a>
									</p>
								</div>
							</div>
							<div class="col-xs-6 col-lg-4">
								<div class="item">
									<h2>Image to PDF</h2>
									<p>将图片格式的文件转为PDF文档.完全免费哦</p>
									<p>
										<a class="btn btn-default"
											href="${pageContext.request.contextPath }/dispatcher?opt=image2pdf"
											role="button">文件上传 &raquo;</a>
									</p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="col-xs-12">
							<div class="commit">
								<div class="content">${comment.content }</div>
								<div class="text-muted text-right">
									<small>— 《${comment.song.name }》 网易云热门</small>
								</div>
								<div class="time">${comment.time }<div></div>
								</div>
							</div>
						</div>
						<div class="col-xs-12 sidebar-offcanvas" id="sidebar">
							<div class="list-group">
								<a href="#" class="list-group-item active">友情链接</a> <a
									href="http://www.bejson.com/" class="list-group-item">JSON在线格式化</a>
								<a href="https://jwc.xidian.edu.cn/" class="list-group-item">西电教务处</a>
								<a href="http://tool.oschina.net/apidocs/apidoc?api=jdk-zh"
									class="list-group-item">在线JDK文档</a> <a
									href="https://www.sohu.com/a/244589784_99949461"
									class="list-group-item">论文网站推荐</a> <a
									href="http://www.tietuku.com/" class="list-group-item">图床推荐</a>
								<a href="https://www.imooc.com/" class="list-group-item">慕课网</a>
								<a href="https://icankeep.github.io" class="list-group-item">我的博客</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/row-->

		<script src="dist/js/bootstrap.min.js"></script>
		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
		<script
			src="${pageContext.request.contextPath }/assets/js/ie10-viewport-bug-workaround.js"></script>
		<script
			src="${pageContext.request.contextPath }/asserts/js/offcanvas.js"></script>
		<div class="footer">
			<footer>
				<p>&copy; 2019 Company, Inc.</p>
			</footer>
		</div>
	</div>
</body>
</html>