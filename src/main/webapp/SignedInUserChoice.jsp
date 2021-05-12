<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form name="signedInUserChoice" method="get"
		action="ApplicationStatusServlet">
		<table>
			<td>UserId for application status</td>
			<td><input type="text" name="userid" /></td>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
	<form name="signedInUserChoice" method="get"
		action="ApplyApplicationServlet">
		<table>
			<tr>
				<button onclick="location.href='NewApplication.jsp'">Apply
					new Loan</button>
			</tr>
		</table>
	</form>
</body>
</html>