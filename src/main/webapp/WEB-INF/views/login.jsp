<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>

<tiles:insertDefinition name="defaultTemplate">

	<tiles:putAttribute name="Title" value="Logowanie" />
	<tiles:putAttribute name="body">
		<c:if test="${not empty categoryList}">
			<tiles:putAttribute name="categoryList" value="${categoryList}" />
		</c:if>
		<tiles:putAttribute name="loginStatus" value="${loginStatus}" />
		<div class="row">
			<div class="col-md-2"></div>
			<div id="main-content" class="no-cover col-md-8">

				<h1>Zaloguj się</h1>
				<div class="alert alert-info alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					Jeżeli nie posiadasz konta przejdź do <a href="register.html"><strong>strony
							rejestracji</strong></a>.
				</div>
				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="msg">${msg}</div>
				</c:if>
				<form role="form" class="login" name='loginForm'
					action="<c:url value='/j_spring_security_check' />" method='POST'>
					<div class="row">
						<div class="col-md-3"></div>
						<div class="col-md-6">
							<fieldset>
								<div class="form-group">
									<label for="loginEmail">Email</label> <input type="email"
										class="form-control" id="loginEmail" name='username'
										placeholder="" required="required" type="email">
								</div>
								<div class="form-group">
									<label for="loginPassword">Hasło</label> <input type="password"
										class="form-control" id="loginPassword" name='password'
										placeholder="" required="required" pattern=".{6,}"
										title="Pole Hasło musi mieć minimum 6 znaków"> <a
										href="#">Zapomniałem hasła</a><br />
								</div>
							</fieldset>
							<fieldset>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
								<button name="submit" type="submit" class="btn btn-default">Zaloguj
									się</button>
							</fieldset>
						</div>
						<div class="col-md-3"></div>
					</div>
				</form>

			</div>
			<!-- ./.main-content -->
			<div class="col-md-2"></div>
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>