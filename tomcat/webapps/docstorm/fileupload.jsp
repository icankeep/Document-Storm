<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="/docstorm/images/favicon.ico">
<link rel="stylesheet" href="/docstorm/assets/css/style.css">

<title>File upload</title>

<!-- Bootstrap core CSS -->
<link href="/docstorm/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="/docstorm/assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pag.eContext.request.contextPath }/assets/css/offcanvas.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="/docstorm/assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

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
	<br />
	<br />
	<br />
	<br />
	<br />
	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right">
			<div class="col-xs-9">
				<p class="text-center">
					<img alt="docstorm" src="/docstorm/images/docstorm.png">
				</p>
				<div class="upfile">
					<h3>请上传文件</h3>
					<form method="POST" enctype="multipart/form-data" action="/docstorm/upload" class="form-horizontal">
						<input type="file" name="upfile" class="form-control" style="width:90%"><br />
						<input type="text" name="newFileName" class="form-control" style="width:90%" placeholder="转换后的文件名，为空的话为为默认值"><br />
						<input type="hidden" name="opt" value="${opt}"/>
						<button type="submit" class="btn btn-default">submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>



	<script src="/docstorm/dist/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="/docstorm/assets/js/ie10-viewport-bug-workaround.js"></script>
	<script src="/docstorm/assets/js/offcanvas.js"></script>
	<div class="footer">
		<footer>
			<p>&copy; 2019 Company, Inc.</p>
		</footer>
	</div>
</body>
</html>