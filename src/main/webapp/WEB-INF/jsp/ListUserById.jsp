<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body bgcolor="#D8BFD8">
	<h1>GetUserDetails</h1>
	<table>
		<thead>
			<tr>
				<th>UserId</th>
				<th>OrgId</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Age</th>
				<th>Gender</th>
				<th>MobileNumber</th>
				<th>SuperuserFlag</th>
				<th>Status</th>
				<th>CreatedDate</th>
				<th>CreatedBy</th>
				<th>ModifiedDate</th>
				<th>ModifiedBy</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ListUser}" var="i">
				<tr>
					<td><c:out value="${i.user_id}" /></td>
					<td><c:out value="${i.org_id}" /></td>
					<td><c:out value="${i.first_name}" /></td>
					<td><c:out value="${i.last_name}" /></td>
					<td><c:out value="${i.age}" /></td>
					<td><c:out value="${i.gender}" /></td>
					<td><c:out value="${i.mobile_number}" /></td>
					<td><c:out value="${i.superUserFlag}" /></td>
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