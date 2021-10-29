<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<style>
		.error {color: red}
	</style>
	
	<title>Student Registration Form</title>
</head>

<body>
	<body style="background-color:powderblue;">
	
	<form:form action="processForm" modelAttribute="student">
	
		First name: <form:input path="firstName" />
		
		<br><br>
	
		Last name: <form:input path="lastName" />
			<form:errors path="lastName" cssClass="error"/>
		
		<br><br>
		
		Country: 
		<form:select path="country">
			
			<form:option value="Bosnia" label="Bosnia"/>
			<form:option value="Germany" label="Germany"/>
					
		</form:select>
		
		<br>
		
		Windows <form:checkbox path="operatingSystems" value="Windows"/>
		Linux  <form:checkbox path="operatingSystems" value="Linux"/>
		Mac OS <form:checkbox path="operatingSystems" value="MacOs"/>
		
		<br>
		Number of free passes: <form:input path="freePasses" />
								<form:errors path="freePasses" cssClass="error"/>
		
		<br>
	
		<input type="submit" value="Submit" />
	
	</form:form>


</body>

</html>












