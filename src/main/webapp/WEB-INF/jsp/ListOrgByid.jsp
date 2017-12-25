<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body bgcolor="#D8BFD8">
	<h1>Organization Details Byid</h1>
	<table border="1">
		<thead>
			<tr>
				<th>OrganizationId</th>
				<th>Status</th>
				<th>CreatedDate</th>
				<th>CreatedBy</th>
				<th>ModifiedDate</th>
				<th>ModifiedBy</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${orgDto}" var="i">
				<tr>
					<td><c:out value="${i.org_id}" /></td>
					<td><c:out value="${i.status}" /></td>
					<td><c:out value="${i.created_date}" /></td>
					<td><c:out value="${i.created_by}" /></td>
					<td><c:out value="${i.modified_date}" /></td>
					<td><c:out value="${i.modified_by}" /></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>