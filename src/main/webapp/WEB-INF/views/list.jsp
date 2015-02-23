<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="Title" value="Główna" />
	<tiles:putAttribute name="body">
		<c:if test="${not empty categoryList}">
			<tiles:putAttribute name="categoryList" value="${categoryList}" />
		</c:if>
		<tiles:putAttribute name="loginStatus" value="${loginStatus}" />
		<div class="cover jumbotron">
			<div class="container">
				<h2>Najlepsza elektronika w mieście!</h2>
			</div>
		</div>

		<div class="row">
			<div class="col-md-1"></div>
			<div id="main-content" class="col-md-10">
				<h1>Produkty</h1>
				<div class="row">
					<div class="row">
						<c:forEach var="product" items="${productList}">
							<div class="col-sm-6 col-md-4 col-lg-3">
								<div class="thumbnail">
									<img src="<c:url value="/resources/img/product.png" />"
										alt="...">
									<div class="caption">
										<h3>${product.name}</h3>
										<p>${product.description}</p>
										<p class="pull-left">
											<button type="button" class="btn btn-link">${product.amount}
												zł</button>
										</p>
										<p class="pull-right">
											<a href="/domain/addtocart/${product.productId}" class="btn btn-primary" role="button"><span
												class="glyphicon glyphicon-plus"></span> Dodaj do koszyka</a>
										</p>
										<br class="clear" />
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<!-- ./.main-content -->
				<div class="col-md-1"></div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>