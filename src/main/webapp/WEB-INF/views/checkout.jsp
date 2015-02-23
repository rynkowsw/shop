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
      <div class="col-md-2"></div>
      <div id="main-content" class="no-cover col-md-8">
      <h1>Kasa</h1>

        <div class="table-responsive">
          <h3>Zamówienie</h3>
          <table class="table table-hover cart">
            <thead>
              <tr>
                <th class="col-xs-8 col-sm-8 col-md-6">Produkt</th>
                <th class="col-xs-1 col-sm-1 col-md-2">Ilość</th>
                <th class="col-xs-2 col-sm-3 col-md-4">Cena</th>
              </tr>
            </thead>
            <tbody>
            	<c:forEach var="cartItem" items="${cartList}">
	            	<tr>
		                <td>${cartItem.name}</td> 
		                <td>1</td>
		                <td>${cartItem.amount}</td>
	              	</tr>
            	</c:forEach>
             
              <tr>
                <td><b>Suma</b></td>
                <td></td>
                <td><b>${sum}</b></td>
              </tr>
            </tbody>
          </table>
        </div>
        
        <form:form commandName="checkout" method="POST">
        
          <fieldset>
            <h3>Dane kontaktowe</h3>
            <div class="form-group">
              <form:label path="firstName" for="registerName">Imię</form:label>
              <form:input path="firstName" type="text" class="form-control" id="registerName" placeholder=""/>
            </div>
            <div class="form-group">
              <form:label path="secondName" for="registerSurname">Nazwisko</form:label>
              <form:input path="secondName" type="text" class="form-control" id="registerSurname" placeholder=""/>
            </div>
            <div class="form-group">
              <form:label path="email" for="registerEmail">Email</form:label>
              <form:input path="email" type="email" class="form-control" id="registerEmail" placeholder=""/>
            </div>
          </fieldset>
          
          <fieldset>
            <h3>Dane do wysyłki</h3>
            <div class="form-group">
              <form:label path="address" for="checkoutAddress">Adres</form:label>
              <form:input path="address" type="text" class="form-control" id="checkoutAddress" placeholder=""/>
            </div>
            <div class="form-group">
              <form:label path="zipCode" for="checkoutPostcode">Kod pocztowy</form:label>
              <form:input path="zipCode" type="text" class="form-control" id="checkoutPostcode" placeholder=""/>
            </div>
            <div class="form-group">
              <form:label path="city" for="checkoutCity">Miasto</form:label>
              <form:input path="city" type="text" class="form-control" id="checkoutCity" placeholder=""/>
            </div>
          </fieldset>


          <div class="checkbox">
            <label>
              <input type="checkbox" id="checkoutFaktura"> Faktura.
            </label>
          </div>

          <fieldset class="faktura">
            <h3>Dane do faktury</h3>
            <div class="form-group">
              <form:label path="companyName" for="checkoutCompany">Nazwa firmy</form:label>
              <form:input path="companyName" type="text" class="form-control" id="checkoutCompany" placeholder=""/>
            </div>
            <div class="form-group">
              <form:label path="nipCode" for="checkoutNIP">NIP</form:label>
              <form:input path="nipCode" type="text" class="form-control" id="checkoutNIP" placeholder=""/>
            </div>
          </fieldset>
          <script>
            $(document).ready(function() {
              $('#checkoutFaktura').change(function() {
                var node = $('.faktura');
                if( $(this).prop('checked') ) {
                  node.slideDown('slow');
                } else {
                  node.slideUp('slow');
                }
              });
            });
          </script>

          <fieldset>
            <button type="submit" class="btn btn-success">Złóż zamówienie</button>
          </fieldset>
        </form:form>
        
      </div> <!-- ./.main-content -->
      </div> <!-- ./.main-content -->
      <div class="col-md-2"></div>
    
	</tiles:putAttribute>
</tiles:insertDefinition>
  