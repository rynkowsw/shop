<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rejestracja test</title>
</head>
	<body>
		<form:form commandName="newUser" method="POST">
		<span>
			<dl>
				<dt><fmt:message key="user.firstName"/></dt>
				<dd><form:input path="firstName" maxlength="50"/></dd>
			</dl>	
			<dl>
				<dt><fmt:message key="user.secondName"/></dt>
				<dd><form:input path="secondName" maxlength="40"/></dd>
			</dl>	
			<dl>
				<dt><fmt:message key="user.email"/></dt>
				<dd><form:input path="email" maxlength="30"/></dd>
			</dl>	
			<dl>
				<dt><fmt:message key="user.phoneNumber"/></dt>
				<dd><form:input path="phoneNumber" maxlength="11"/></dd>
			</dl>	
			<dl>
				<dt><fmt:message key="user.role"/></dt>
				<dd><form:input path="role" maxlength="15"/></dd>
			</dl>	
			
			<dl>
				<dt><input type="submit" value="Utwórz"></dt>
			</dl>
		</span>
		</form:form>
	</body>
</html>