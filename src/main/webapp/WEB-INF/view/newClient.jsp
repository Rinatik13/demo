<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTUPE html>
<html>
<body>

<h2>Client info</h2>
<br>

<form:form action="saveClient" modelAttribute="client">

Name <form:input path="name"/>
<br>
<br>
Phone <form:input path="phone"/>
<br>
<br>
Email <form:input path="email"/>
<br>
<input type="submit" value="Add"/>
</form:form>

</body>
</html>