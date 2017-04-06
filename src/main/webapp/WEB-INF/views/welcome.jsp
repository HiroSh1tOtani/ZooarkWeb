<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>ZooArkt</title>
	<meta name="description" content="Admin, Dashboard, Bootstrap" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="shortcut icon" href="<c:url value='/static/assets/images/zoo/logozoo_s.png' />" sizes="196x196" >
	
	<link href="<c:url value='https://fonts.googleapis.com/icon?family=Material+Icons' />" rel="stylesheet">
	<link rel="stylesheet"	href="<c:url value='/static/libs/bower/font-awesome/css/font-awesome.min.css' />">
	<link rel="stylesheet"	href="<c:url value='https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css' />">
	<link rel="stylesheet"	href="<c:url value='/static/libs/bower/animate.css/animate.min.css' />"	>
	<link rel="stylesheet" 	href="<c:url value='/static/libs/bower/fullcalendar/dist/fullcalendar.min.css' />">
	<link rel="stylesheet"	href="<c:url value='/static/libs/bower/perfect-scrollbar/css/perfect-scrollbar.css' />"	>
	
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet">
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet">
	
	<link	href="<c:url value='https://fonts.googleapis.com/css?family=Raleway:400,500,600,700,800,900,300' />"	rel="stylesheet"></link>


  
	  
</head>

<body class="sb-left theme-success pace-done">
<!--============= start main area -->

<!-- APP ASIDE ==========-->
<aside id="app-aside" class="app-aside left in dark">
	<div class="aside-user" style="margin-top: 15%;">
		<!-- aside-user -->
		<div class="media">
			<div class="media-body">
				<div class="foldable">
					<h5><a href="javascript:void(0)" class="username">John Doe</a></h5>
					<ul>
						<li class="dropdown">
							<a href="javascript:void(0)" class="dropdown-toggle usertitle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<small style="color:#fff">Web Developer</small>
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- /aside-user -->
	</div><!-- #aside-user -->

	<div class="aside-scroll">
		<div id="aside-scroll-inner" class="aside-scroll-inner">
			<ul class="aside-menu aside-left-menu">
				<li class="menu-item has-submenu">
					<a href="javascript:void(0)" class="menu-link submenu-toggle">
						<span class="menu-icon"><i class="zmdi zmdi-view-dashboard zmdi-hc-lg"></i></span>
						<span class="menu-text foldable">Security</span>
						<span class="menu-caret foldable"><i class="zmdi zmdi-hc-sm zmdi-chevron-right"></i></span>
					</a>
					<ul class="submenu">
						<li><a href="index.html">Users</a></li>
					</ul>
				</li>
			</ul>
			<hr>
			
		</div><!-- .aside-scroll-inner -->
	</div><!-- #aside-scroll -->
</aside>
<!--========== END app aside -->

<!-- APP NAVBAR ==========-->
<nav id="app-navbar" class="app-navbar p-l-lg p-r-md success in">
	<div id="navbar-header" class="pull-left">
		<button id="aside-fold" class="hamburger visible-lg-inline-block hamburger--arrowalt is-active js-hamburger" type="button">
			<span class="hamburger-box">
				<span class="hamburger-inner"></span>
			</span>
		</button>
		<button id="aside-toggle" class="hamburger hidden-lg hamburger--spin js-hamburger" type="button">
			<span class="hamburger-box">
				<span class="hamburger-inner"></span>
			</span>
		</button>
		<h5 id="page-title" class="visible-md-inline-block visible-lg-inline-block m-l-md">Dashboard</h5>
	</div>

	
</nav>
<!--========== END app navbar -->


<!-- APP MAIN ==========-->
<main id="app-main" class="app-main">
	<div class="profile-header">
	<div class="profile-cover">
		

	</div><!-- .profile-cover -->

	<div class="promo-footer">
	

	</div><!-- .promo-footer -->
</div><!-- .profile-header -->

<div class="wrap">
	<section class="app-content">
		

	</section><!-- #dash-content -->
</div><!-- .row -->

<!-- Likes/comments Modal -->
<div id="likesModal" class="modal fade" tabindex="-1" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">3 people like this</h4>
			</div>
			<div class="modal-body">
				
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
	
	<!-- APP FOOTER -->
	<div class="wrap p-t-0">
		<footer class="app-footer">
			<div class="clearfix">
				<ul class="footer-menu pull-right">
					
					
				</ul>
				<div class="copyright pull-left">Copyright ZooArk 2017 &copy;</div>
			</div>
		</footer>
	</div>
	<!-- /#app-footer -->
</main>
<!--========== END app main -->


  <script src="<c:url value="/static/libs/bower/jquery/dist/jquery.js" />"></script>
    <script src="<c:url value="/static/libs/bower/jquery-ui/jquery-ui.min.js" />"></script>
    <script src="<c:url value="/static/libs/bower/jQuery-Storage-API/jquery.storageapi.min.js" />"></script>
    <script src="<c:url value="/static/libs/bower/bootstrap-sass/assets/javascripts/bootstrap.js" />"></script>
    <script src="<c:url value="/static/libs/bower/superfish/dist/js/hoverIntent.js" />"></script>
    <script src="<c:url value="/static/libs/bower/superfish/dist/js/superfish.js" />"></script>
    <script src="<c:url value="/static/libs/bower/jquery-slimscroll/jquery.slimscroll.js" />"></script>
    <script src="<c:url value="/static/libs/bower/perfect-scrollbar/js/perfect-scrollbar.jquery.js" />"></script>
    <script src="<c:url value="/static/libs/bower/PACE/pace.min.js" />"></script>
  
	<!-- endbuild -->

	<!-- build:js ../assets/js/app.min.js -->
	
	  <script src="<c:url value="/static/assets/js/library.js" />"></script>
	  <script src="<c:url value="/static/assets/js/plugins.js" />"></script>
	  <script src="<c:url value="/static/assets/js/app.js" />"></script>
	  
	<!-- endbuild -->
	
	  <script src="<c:url value="/static/libs/bower/moment/moment.js" />"></script>
	  <script src="<c:url value="/static/libs/bower/fullcalendar/dist/fullcalendar.min.js" />"></script>
	  <script src="<c:url value="/static/assets/js/fullcalendar.js" />"></script>

	
   	
</body>
</html>