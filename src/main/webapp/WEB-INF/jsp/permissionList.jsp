<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body bgcolor="#D8BFD8">
	<h1>Permissions Details</h1>
	<table>
		<thead>
			<tr>
				<th>PermissionId</th>
				<th>RoleId</th>
				<th>Status</th>
				<th>CreatedDate</th>
				<th>CreatedBy</th>
				<th>ModifiedDate</th>
				<th>ModifiedBy</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${permissionList}" var="i">
				<tr>
					<td><c:out value="${i.permission_id}" /></td>
					<td><c:out value="${i.role_id}" /></td>
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