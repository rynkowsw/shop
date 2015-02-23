<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="Title" value="Rejestracja" />
	<tiles:putAttribute name="body">
		<c:if test="${not empty categoryList}">
			<tiles:putAttribute name="categoryList" value="${categoryList}" />
		</c:if>
		<tiles:putAttribute name="loginStatus" value="${loginStatus}" />
		<div class="row">
			<div class="col-md-2"></div>
			<div id="main-content" class="no-cover col-md-8">

				<h1>Zarejestruj się</h1>

				<div class="alert alert-info alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Zamknij</span>
					</button>
					Jeżeli posiadasz już konto przejdź do <a href="login.html"><strong>strony
							logowania</strong></a>.
				</div>

				<form:form action="register" commandName="newUser" method="POST">
					<div class="row">
						<div class="col-md-6">
							<fieldset>
								<h4>Dane kontaktowe</h4>
								<div class="form-group">
									<label for="registerName">Imie</label>
									<form:input path="firstName" maxlength="30" type="text"
										class="form-control" id="registerName" placeholder=""
										required="required" pattern="[A-Z]{1}[a-z]*"
										title="Imie musi zaczynać się z dużej litery i zawierać tylko litery oraz mieć nie więcej niż 30 znaków" />
									<form:errors path="firstName" cssclass="error"></form:errors>
								</div>
								<div class="form-group">
									<label for="registerSurname">Nazwisko</label>
									<form:input path="secondName" maxlength="30" type="text"
										class="form-control" id="registerSurname" placeholder=""
										required="required" pattern="[A-Z]{1}[a-z]*"
										title="Nazwisko musi zaczynać się z dużej litery i zawierać tylko litery oraz mieć nie więcej niż 30 znaków" />
									<form:errors path="secondName" cssclass="error"></form:errors>
								</div>
								<div class="form-group">

									<label for="registerEmail">Email</label>
									<form:input path="email" maxlength="30" type="email"
										class="form-control" id="registerEmail" placeholder=""
										required="required" />
									<form:errors path="email" cssclass="error"></form:errors>
								</div>
							</fieldset>

							<div class="form-group">
								<label for="registerPhone">Numer telefonu</label>
								<form:input path="phoneNumber" type="tel"
									pattern="(\+?\d[- .]*){9,11}"
									title="Pole Numer telefonu musi zawierać od 9 do 11 cyfr od 0 do 9"
									class="form-control" required="required" />
								<form:errors path="phoneNumber" cssclass="error"></form:errors>
							</div>
							<fieldset>
								<h4>Konto</h4>
								<div class="form-group">
									<label for="registerPassword">Hasło</label>
									<form:input name="Pass" path="password" type="password"
										class="form-control" id="registerPassword" placeholder=""
										required="required" pattern="((?=.*\d)(?=.*[A-Z])).{6,30}"
										title="Pole Hasło musi mieć minimum 6 znaków i maksimum 30 znaków oraz zawierać cyfrę i dużą literę"
										onchange="form.PassConfirm.pattern = this.value;" />
									<form:errors path="password" cssclass="error"></form:errors>
								</div>
								<div class="form-group">
									<label for="registerPassword2">Powtórz Hasło</label> <input
										name="PassConfirm" type="password" class="form-control"
										id="registerPassword2" placeholder="" required="required"
										pattern=".{6,30}"
										title="Pole Powtórz Hasło musi mieć minimum 6 znaków i maksimum 30 znaków oraz być identyczne jak pole Hasło">
								</div>
							</fieldset>
						</div>

						<div class="col-md-6">
							<fieldset>
								<h4>Dane do wysyłki</h4>
								<div class="form-group">
									<label for="registerAddress">Adres</label> <input type="text"
										class="form-control" id="registerAddress" placeholder="">
								</div>
								<div class="form-group">
									<label for="registerPostcode">Kod pocztowy</label> <input
										type="text" class="form-control" id="registerPostcode"
										placeholder="">
								</div>
								<div class="form-group">
									<label for="registerCity">Miasto</label> <input type="text"
										class="form-control" id="registerCity" placeholder="">
								</div>
							</fieldset>


							<fieldset>
								<h4>Dane do faktury</h4>
								<div class="form-group">
									<label for="registerCompany">Nazwa firmy</label> <input
										type="text" class="form-control" id="registerCompany"
										placeholder="">
								</div>
								<div class="form-group">
									<label for="registerNIP">NIP</label> <input type="text"
										class="form-control" id="registerNIP" placeholder="">
								</div>
							</fieldset>
						</div>
					</div>

					<fieldset>
						<div class="checkbox">
							<label> <input type="checkbox" id="registerTerms"
								required="required" title="Proszę zaakceptować regulamin">
								Zapoznałem się i akceptuję <a href="#">regulamin</a>.
							</label>
						</div>
						<button type="submit" class="btn btn-default">Zarejestruj
							się</button>
					</fieldset>
				</form:form>

			</div>
			<!-- ./.main-content -->
			<div class="col-md-2"></div>
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>