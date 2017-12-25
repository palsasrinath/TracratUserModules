<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body bgcolor="#D8BFD8">
	<h1>Get Users Role Details Byid</h1>
	<table>
		<thead>
			<tr>
				<th>RoleId</th>
				<th>UserId</th>
				<th>Status</th>
				<th>CreatedDate</th>
				<th>CreatedBy</th>
				<th>ModifiedDate</th>
				<th>ModifiedBy</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${roleDto}" var="i">
				<tr>
					<td><c:out value="${i.role_id}" /></td>
					<td><c:out value="${i.user_id}" /></td>
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