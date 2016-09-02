<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<sf:form method="post"
		action="${pageContext.request.contextPath }/feedUserProfile"
		commandName="userProfile">
		<table>
			<tr>
				<td><strong>First Name*</strong></td>
				<td><sf:input type="text" name="firstName" path="firstName" /></td><br />
					<td><sf:errors path="firstName"></sf:errors></td>
					<td>${userProfile.firstNameChanged}</td>
			</tr>
			
			<tr>
				<td><strong>Last Name*</strong>:</td>
				<td><sf:input type="text" name="lastName" path="lastName" /></td> <br />
					<td><sf:errors path="lastName"></sf:errors></td>
					<td>${userProfile.lastNameChanged}</td>
			</tr>
			
			<tr>
				<td><strong>Phone</strong></td>
				<td><sf:input type="text" name="phone" path="phone" /></td><br />
					<td><sf:errors path="phone"></sf:errors></td>
					<td>${userProfile.phoneChanged}</td>
			</tr>
			
			<tr>
				<td><strong>Email ID</strong>:</td>
				<td><sf:input type="text" name="email" path="email" /></td> <br />
					<td><sf:errors path="email"></sf:errors></td>
					<td>${userProfile.emailChanged}</td>
			</tr>
			
			<tr>
				<td><strong>Country</strong></td>
				<td><sf:input type="text" name="country" path="country" /></td><br />
					<td><sf:errors path="country"></sf:errors></td>
					<td>${userProfile.countryChanged}</td>
			</tr>
			
			<tr>
				<td><strong>Highest Major*</strong>:</td>
				<td><sf:input type="text" name="highestMajor" path="highestMajor" /></td> <br />
					<td><sf:errors path="highestMajor"></sf:errors></td>
					<td>${userProfile.highestMajorChanged}</td>
			</tr>
			
			<tr>
				<td><strong>Area Of Interest*</strong></td>
				<td><sf:input type="text" name="areaOfInterest" path="areaOfInterest" /></td><br />
					<td><sf:errors path="areaOfInterest"></sf:errors></td>
					<td>${userProfile.areaOfInterestChanged}</td>
			</tr>
			
			<tr>
				<td><strong>Current University</strong>:</td>
				<td><sf:input type="text" name="currentUniversity" path="currentUniversity" /></td> <br />
					<td><sf:errors path="currentUniversity"></sf:errors></td>
					<td>${userProfile.currentUniversityChanged}</td>
			</tr>
			
			<tr>
				<td><strong>GPA*</strong></td>
				<td><sf:input type="text" name="gpa" path="gpa" /></td><br />
					<td><sf:errors path="gpa"></sf:errors></td>
					<td>${userProfile.gpaChanged}</td>
			</tr>
			
			<tr>
				<td><strong>Number Of Backlogs*</strong>:</td>
				<td><sf:input type="text" name="numberOfBacklogs" path="numberOfBacklogs" /></td> <br />
					<td><sf:errors path="numberOfBacklogs"></sf:errors></td>
					<td>${userProfile.numberOfBacklogsChanged}</td>
			</tr>
			
			<tr>
				<td><strong>Work Experience*</strong></td>
				<td><sf:input type="text" name="workExperience" path="workExperience" /></td><br />
					<td><sf:errors path="workExperience"></sf:errors></td>
					<td>${userProfile.workExperienceChanged}</td>
			</tr>
			
			<tr>
				<td><strong>Research Work</strong>:</td>
				<td><sf:textarea  name="researchWork" path="researchWork" /></td> <br />
					<td><sf:errors path="researchWork"></sf:errors></td>
					<td>${userProfile.researchWorkChanged}</td>
			</tr>
			<tr>
				<td><strong>Other Certifications</strong></td>
				<td><sf:input type="text" name="otherCertifications" path="otherCertifications" /></td><br />
					<td><sf:errors path="otherCertifications"></sf:errors></td>
					<td>${userProfile.otherCertificationsChanged}</td>
			</tr>
					
			<tr>
				<td></td>
				<td><input type="submit" value="Get Me My Universities" name="submit" /></td>
			</tr>
		</table>
	</sf:form>


	<!-- <form action="Login" method="post">
<strong>User Email</strong>:<input type="text" name="email"><br>
<strong>Password</strong>:<input type="password" name="password"><br>
<input type="submit" value="Register">
</form> -->
	<%-- <p>
		<a href="${pageContext.request.contextPath}/home">ShowOffers</a>
	</p> --%>
</body>
</html>