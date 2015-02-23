<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="Title" value="Dodawanie Produktu" />
	<tiles:putAttribute name="body">
		<c:if test="${not empty categoryList}">
			<tiles:putAttribute name="categoryList" value="${categoryList}" />
		</c:if>
		<tiles:putAttribute name="loginStatus" value="${loginStatus}" />
		<div class="row">
			<div class="col-md-2"></div>
			<div id="main-content" class="no-cover col-md-8">
				
				<h1>Zlozono zamowienie!</h1>

			

			</div>
			<!-- ./.main-content -->
			<div class="col-md-2"></div>
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>