<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<sf:form method="post"
		action="${pageContext.request.contextPath }/bSack"
		modelAttribute="universities">
		<table>
	<tr>
		<th>Code</th>
		<th>Department</th>
		<th>Degree</th>
		<th>GPA</th>
		<th>Work Experience</th>
		<th>Research Work</th>
		<th>Other Certifications</th>
	</tr>
	<c:forEach items="${universities}" var="university" varStatus="status">
		<tr>
			<td align="center">${status.count}</td>
			<td><input name="universities[${status.index}].code" value="${university.code}"/></td>
			<td><input name="universities[${status.index}].department" value="${university.department}"/></td>
			<td><input name="universities[${status.index}].degree" value="${university.degree}"/></td>
			<td><input name="universities[${status.index}].gpa" value="${university.gpa}"/></td>
			<td><input name="universities[${status.index}].workExperience" value="${university.workExperience}"/></td>
			<td><input name="universities[${status.index}].researchWork" value="${university.researchWork}"/></td>
			<td><input name="universities[${status.index}].otherCertifications" value="${university.otherCertifications}"/></td>
		</tr>
	</c:forEach>
</table></sf:form>

</body>
</html>