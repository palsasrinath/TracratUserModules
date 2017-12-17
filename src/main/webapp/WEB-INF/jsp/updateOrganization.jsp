<html>
<body bgcolor="gray">
	<h1 align="center" style="color: red;">OrganizationForm</h1>
	<form action="update_organization" method="post">
		<table align="center" border="1">

			<tr>
				<td>Organization Id::</td>
				<td><input type="text" name="org_id" /></td>
			</tr>
			<tr>
				<td>Status::</td>
				<td><input type="text" name="status" /></td>
			</tr>
			<tr>
				<td>Created Date::</td>
				<td><input type="date" name="created_date" /></td>
			</tr>
			<tr>
				<td>Created By::</td>
				<td><input type="text" name="created_by" /></td>
			</tr>
			<tr>
				<td>Modified Date::</td>
				<td><input type="date" name="modified_date" /></td>
			</tr>
			<tr>
				<td>Modified By::</td>
				<td><input type="text" name="modified_by" /></td>
			</tr>


			<tr>
				<td><input type="submit" value="Enter">
		</table>
	</form>
</body>
</html>