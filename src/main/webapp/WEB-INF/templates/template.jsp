<%@page import="javax.swing.text.View"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pl">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><tiles:insertAttribute name="Title" flush="true" /> |
	Magazynier 2015</title>

<!-- Bootstrap -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

<!-- Custom css -->
<link href="<c:url value="/resources/css/custom.css" />"
	rel="stylesheet">

</head>
<body>
	<tiles:importAttribute />
	<tiles:useAttribute name="categoryList" />
	<tiles:useAttribute name="Title" />
	<tiles:useAttribute name="loginStatus" />
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="index.html">Magazynier 2014</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Kategorie <span class="caret"></span></a>
								<ul class="dropdown-menu" role="menu">
									<c:if test="${not empty categoryList}">
										<c:forEach var="listValue" items="${categoryList}">
											<li><a href="#">${listValue.getName()}</a></li>
										</c:forEach>
									</c:if>
								</ul></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<form class="navbar-form navbar-left" role="search">
								<div class="input-group input-group-sm">
									<input type="text" class="form-control"> <span
										class="input-group-btn">
										<button class="btn btn-default" type="button">
											<span class="glyphicon glyphicon-search"></span>
										</button>
									</span>
								</div>
							</form>
							<c:choose>
								<c:when test="${loginStatus == 'unlogged'}">
									<c:choose>
										<c:when test="${Title == 'Logowanie'}">
											<li class="active"><a href="login.html">Logowanie</a></li>
											<li><a href="register.html">Rejestracja</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="login.html">Logowanie</a></li>
											<li class="active"><a href="register.html">Rejestracja</a></li>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<li>
										<a href="<c:url value="/j_spring_security_logout" />" >Wyloguj</a>
									</li>
								</c:otherwise>
							</c:choose>

						</ul>
					</div>
					<!-- /.navbar-collapse -->
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
	</nav>
	<tiles:insertAttribute name="body" />

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>