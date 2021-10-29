<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Student Confirmation </title>
</head>

	<body>
	
	Student is confirmed:
	<br>
	First name: ${student.firstName}
	Last name: ${student.lastName}
	
	<br>
	Country: ${student.country}
	
	<br>
	
	Operating systems:
	<ul>
		<c:forEach var="temp" items="${student.operatingSystems}">
		
			<li> ${temp}</li>
	
		</c:forEach>
	
	</ul>
	<br>
	
	Free passes: ${student.freePasses}
	
	<br>
	
	</body>
	
</html>
