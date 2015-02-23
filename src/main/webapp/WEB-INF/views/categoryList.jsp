<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true"%>

<tiles:insertDefinition name="defaultTemplate">

	<tiles:putAttribute name="Title" value="Dodawanie Kategorii" />
	<tiles:putAttribute name="body">
		<c:if test="${not empty categoryList}">
			<tiles:putAttribute name="categoryList" value="${categoryList}" />
		</c:if>
		<tiles:putAttribute name="loginStatus" value="${loginStatus}" />
		<div class="row">
			<div class="col-md-2"></div>
			<div id="main-content" class="no-cover col-md-8">

				<h1>Kategorie</h1>

				<fieldset>
					<h4>Dodaj nową kategorię</h4>
					<div class="input-group">
						<form:form commandName="newCategory" method="POST">
							<form:input path="name" type="text" class="form-control" required="required"/>
							<span class="input-group-btn">
								<button class="btn btn-default" type="submit">
									<span class="glyphicon glyphicon-plus"></span>
								</button>
							</span>
						</form:form>
					</div>
				</fieldset>

				<div class="table-responsive">
					<table class="table table-hover category-list">
						<thead>
							<tr>
								<th class="col-md-8">Nazwa</th>
								  <th class="col-md-4"><!-- Ilość produktów --></th> 
							</tr>
						</thead>
						<tbody>
							<c:if test="${not empty categoryList}">
								<c:forEach var="listValue" items="${categoryList}">
									<tr>
										<td>${listValue.getName()}</td>
										 <td><!-- 10 --></td> 
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>

			</div>
			<!-- ./.main-content -->
			<div class="col-md-2"></div>
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>