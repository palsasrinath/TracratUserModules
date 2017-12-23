<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body bgcolor="#D8BFD8">
	<h1>Address Details</h1>
	<table>
		<thead>
			<tr>
				<th>AddressId</th>
				<th>UserId</th>
				<th>Address1</th>
				<th>Address2</th>
				<th>State</th>
				<th>Country</th>
				<th>Pin</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${addressList}" var="i">
				<tr>
					<td><c:out value="${i.address_id}" /></td>
					<td><c:out value="${i.user_id}" /></td>
					<td><c:out value="${i.address1}" /></td>
					<td><c:out value="${i.address2}" /></td>
					<td><c:out value="${i.state}" /></td>
					<td><c:out value="${i.country}" /></td>
					<td><c:out value="${i.pin}" /></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>