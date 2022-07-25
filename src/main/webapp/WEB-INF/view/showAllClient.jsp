<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTUPE html>
<html>
<body>

<h2> All Client </h2>
<br>
<table>
	<tr>
		<th>
			name
		</th>
		<th>
			phone
		</th>
		<th>
			email
		</th>
	</tr>
	<c:forEach var="client" items="${allClient}">
		<tr>
			<td>${client.name}</td>
			<td>${client.phone}</td>
			<td>${client.email}</td>
		</tr>

	</c:forEach>
	
</table>
<br>
<input type="button" value="Add"
onclick="window.location.href='addClient'"/>

</body>
</html>