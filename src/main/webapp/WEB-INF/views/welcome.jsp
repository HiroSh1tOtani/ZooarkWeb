<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>

<%-- definir el folder de la plantilla --%>
<c:choose>
	<c:when test="${not empty _template}">
		<c:set var="_folder" value="${_template}" />
	</c:when>
</c:choose>

<html lang="es" class="no-js">
<head>
	<meta charset="UTF-8">
	<title>ZooArk</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="shortcut icon" href="<c:url value='/static/assets/images/zoo/logozoo_s.png' />" sizes="196x196" >
	
	<link rel="stylesheet" href="<c:url value='/static/libs/bower/font-awesome/css/font-awesome.min.css' />">
	<link rel="stylesheet" href="<c:url value='/static/libs/bower/material-design-iconic-font/dist/css/material-design-iconic-font.css' />">
	<!-- build:css ../css/app.min.css -->
	<link rel="stylesheet" href="<c:url value='/static/libs/bower/animate.css/animate.min.css' />">
	<link rel="stylesheet" href="<c:url value='/static/libs/bower/fullcalendar/dist/fullcalendar.min.css' />">
	<link rel="stylesheet" href="<c:url value='/static/libs/bower/perfect-scrollbar/css/perfect-scrollbar.css' />">
	<link rel="stylesheet" href="<c:url value='/static/assets/css/bootstrap.css' />">
	<link rel="stylesheet" href="<c:url value='/static/assets/css/app.css' />">
	<!-- endbuild -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:400,500,600,700,800,900,300">
</head>

<body class="sb-left">
<!--============= start main area -->

<!-- APP ASIDE ==========-->
<aside id="app-aside" class="app-aside left light">
	<header class="aside-header">
		<div class="animated">
			<a id="app-brand" class="app-brand">
				<span id="brand-icon" class="brand-icon"><i class="fa fa-gg"></i></span>
				<span id="brand-name" class="brand-icon foldable">Zooark</span>
			</a>
		</div>
	</header><!-- #sidebar-header -->
	
	<div class="aside-user">
		<!-- aside-user -->
		<div class="media">
			<div class="media-left">
				<div class="avatar avatar-md avatar-circle">
					<a href="javascript:void(0)"><img class="img-responsive" alt="avatar"/></a>
				</div><!-- .avatar -->
			</div>
			<div class="media-body">
				<div class="foldable">
					<h5><a href="javascript:void(0)" class="username">${pageContext.request.userPrincipal.name}</a></h5>
					<ul>
						<li class="dropdown">
							<a href="javascript:void(0)" class="dropdown-toggle usertitle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<small>Opciones</small>
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu animated flipInY">
								<li>
									<a class="text-color" href="profile.html">
										<span class="m-r-xs"><i class="fa fa-user"></i></span>
										<span>Datos</span>
									</a>
								</li>
								<li role="separator" class="divider"></li>
								<li>
									<a class="text-color" href="<c:url value="/logout" />">
										<span class="m-r-xs"><i class="fa fa-power-off"></i></span>
										<span>Cerrar Sesi&oacute;n</span>
									</a>
								</li>
							</ul>
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
						<span class="menu-text foldable">Usuario</span>
						<span class="menu-caret foldable"><i class="zmdi zmdi-hc-sm zmdi-chevron-right"></i></span>
					</a>
					<ul class="submenu">
						<li><a href="<c:url value="/Mantenimiento_Usuario" />">Mantenimiento Usuario</a></li>
					</ul>
				</li><!-- .menu-item -->
			</ul>
		</div><!-- .aside-scroll-inner -->
	</div><!-- #aside-scroll -->
</aside>
<!--========== END app aside -->

<!-- APP NAVBAR ==========-->
<nav id="app-navbar" class="app-navbar p-l-lg p-r-md primary">
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
	<div class="wrap">
	<section class="app-content">
		<%-- en este punto, _template nunca viene vacio --%>
		<c:choose>
			<c:when test="${empty _module}">
				<c:choose>
					<c:when test="${not empty _page}">
						<c:import url="${_folder}/${_page}.jsp" />
					</c:when>
				</c:choose> 
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${not empty _page}">
						<c:import url="${_folder}/${_module}/${_page}.jsp" />
					</c:when>
				</c:choose>
			</c:otherwise>
		</c:choose>
	</section><!-- #dash-content -->
</div><!-- .wrap -->
	
	<!-- APP FOOTER -->
	<div class="wrap p-t-0">
		<footer class="app-footer">
			<div class="clearfix">
				<ul class="footer-menu pull-right">
					<li><a href="javascript:void(0)">Careers</a></li>
					<li><a href="javascript:void(0)">Privacy Policy</a></li>
					<li><a href="javascript:void(0)">Feedback <i class="fa fa-angle-up m-l-md"></i></a></li>
				</ul>
				<div class="copyright pull-left">Copyright Zooark 2017 &copy;</div>
			</div>
		</footer>
	</div>
	<!-- /#app-footer -->
</main>
<!--========== END app main -->
	<!-- build:js ../assets/js/core.min.js -->
	<script src="<c:url value='/static/libs/bower/jquery/dist/jquery.js' />"></script>
	<script src="<c:url value='/static/libs/bower/jquery-ui/jquery-ui.min.js' />"></script>
	<script src="<c:url value='/static/libs/bower/jQuery-Storage-API/jquery.storageapi.min.js' />"></script>
	<script src="<c:url value='/static/libs/bower/bootstrap-sass/assets/javascripts/bootstrap.js' />"></script>
	<script src="<c:url value='/static/libs/bower/superfish/dist/js/hoverIntent.js' />"></script>
	<script src="<c:url value='/static/libs/bower/superfish/dist/js/superfish.js' />"></script>
	<script src="<c:url value='/static/libs/bower/jquery-slimscroll/jquery.slimscroll.js' />"></script>
	<script src="<c:url value='/static/libs/bower/perfect-scrollbar/js/perfect-scrollbar.jquery.js' />"></script>
	<script src="<c:url value='/static/libs/bower/PACE/pace.min.js' />"></script>
	<!-- endbuild -->

	<!-- build:js ../assets/js/app.min.js -->
	<script src="<c:url value='/static/assets/js/library.js' />"></script>
	<script src="<c:url value='/static/assets/js/plugins.js' />"></script>
	<script src="<c:url value='/static/assets/js/app.js' />"></script>
	<!-- endbuild -->
	<script src="<c:url value='/static/libs/bower/moment/moment.js' />"></script>
	<script src="<c:url value='/static/libs/bower/fullcalendar/dist/fullcalendar.min.js' />"></script>
	<script src="<c:url value='/static/assets/js/fullcalendar.js' />"></script>
</body>
</html>