<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Form
</h1>

<form:form modelAttribute="testModel">
<form:input path="test"/>
<input type="submit" value="Wyslij"></input>
</form:form>

</body>
</html>