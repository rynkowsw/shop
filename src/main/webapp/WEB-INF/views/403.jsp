<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>

<tiles:insertDefinition name="defaultTemplate">

	<tiles:putAttribute name="Title" value="Dodawanie Kategorii" />
	<tiles:putAttribute name="body">
		<c:if test="${not empty categoryList}">
			<tiles:putAttribute name="categoryList" value="${categoryList}" />
		</c:if>
		<tiles:putAttribute name="loginStatus" value="${loginStatus}" />
		<h1>HTTP Status 403 - Brak dostępu</h1>

		<c:choose>
			<c:otherwise>
				<h2>Użytkownik ${username} nie ma dostępu do tej strony</h2>
			</c:otherwise>
		</c:choose>

	</tiles:putAttribute>
</tiles:insertDefinition>