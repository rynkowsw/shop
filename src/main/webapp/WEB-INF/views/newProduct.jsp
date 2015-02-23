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
				
				<h1>Nowy produkt</h1>

				<c:choose>
					<c:when test="${userRole == 'admin' || userRole == 'ADMIN'}">
						<form:form commandName="newProduct" method="POST">
							<div class="row">
								<div class="col-md-6">
									<fieldset>

										<div class="form-group">
											<label for="productName">Nazwa</label>
											<form:input type="text" class="form-control" id="productName"
												placeholder="" path="name" required="required"/>
											<form:errors path="name" cssclass="error"></form:errors>
										</div>
										<div class="form-group">
											<label for="productCatalogNumber">Numer katalogowy</label>
											<form:input type="text" class="form-control"
												id="productCatalogNumber" placeholder="" maxlength="11"
												path="catalogNum" required="required"/>
											<form:errors path="catalogNum" cssclass="error"></form:errors>
										</div>
										<div class="form-group">
											<label for="productCategory">Kategoria</label>
											<form:select path="categories" multiple="true"
												class="form-control" id="productCategory">
												<form:options items="${categoryList}" itemLabel="name"></form:options>
											</form:select>
										</div>
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label for="productPrice">Cena</label>
													<div class="input-group">
														<form:input path="amount" maxlength="30" type="number"
															class="form-control" id="productPrice" placeholder="" required="required" 
															pattern="[+]?\\d*\\.?\\d+" title="Cena musi być liczbą większą od 0" />
														<span class="input-group-addon">zł</span>
														<form:errors path="amount" cssclass="error"></form:errors>
													</div>
												</div>
											</div>
										</div>
									</fieldset>
								</div>

								<div class="col-md-6">
									<fieldset>
										<div class="form-group">
											<label for="productDescription">Opis</label>
											<form:textarea path="description" class="form-control"
												id="productDescription" rows="3" />
											<form:errors path="description" cssclass="error"></form:errors>
										</div>
										<!-- <div class="form-group">
											<label for="productImageURL">Adres URL obrazka</label> <input
												type="text" class="form-control" id="productImageURL"
												placeholder="">
										</div> -->
									</fieldset>
								</div>
							</div>

							<fieldset>
								<button type="submit" class="btn btn-default">Dodaj</button>
							</fieldset>
						</form:form>
					</c:when>
					<c:otherwise>
						<span>Nie masz uprawnień do dodawania nowego produktu</span>
					</c:otherwise>
				</c:choose>

			</div>
			<!-- ./.main-content -->
			<div class="col-md-2"></div>
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>