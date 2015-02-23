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
      
        <h1>Koszyk</h1>

        <div class="table-responsive">
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
          
        <a href="index.html" class="btn btn-default" role="button">Kontynuuj zakupy</a>
        <a href="checkout.html" class="btn btn-success pull-right" role="button">Przejdź do kasy</a>
        
      </div> <!-- ./.main-content -->
      <div class="col-md-2"></div>
    </div>
	</tiles:putAttribute>
</tiles:insertDefinition>
  