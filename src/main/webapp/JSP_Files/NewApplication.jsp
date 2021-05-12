<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Applying new application</title>
</head>
<body>

	<%="Welcome : " + session.getAttribute("userid")%>
	

	<form name="applyApplication" method="get"
		action="ApplyApplicationServlet">
		<table>
			<tr>
				<td>userid</td>
				<td><input type="text" name="userid" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td>Pancard_Number</td>
				<td><input type="text" name="panNumber" /></td>
			</tr>
			<tr>
				<td>Distance from bank</td>
				<td><input type="text" name="distanceFrombank" /></td>
			</tr>
			<tr>
				<td>Repayment period</td>
				<td><input type="text" name="RepaymentPeriod" /></td>
			</tr>
			<tr>
				<td>Work experience</td>
				<td><input type="text" name="WorkExp" /></td>
			</tr>
			<tr>
				<td>occupation</td>
				<td><input type="text" name="Occupation" /></td>
			</tr>
			<tr>
				<td>LoanAmount</td>
				<td><input type="text" name="LoanAmount" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
				<td><input type="reset" label="clear" /></td>
			</tr>
		</table>
	</form>
</body>
</html>