<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Tasks</title>
		<link rel="stylesheet" type="text/css" href="../style.css">
		<link rel="stylesheet" type="text/css" href="../editButton.css">
	</head>
	
	<body>
		<p><a href="/CRM1.4/main.jsp">
    		<img src="../back.png">
		</a></p>
		
		<p><a href="${pageContext.request.contextPath}/Task/create">
    		<img src="../add.png">
		</a></p>
		
		<p><a href="${pageContext.request.contextPath}/Task/index">
    		<img src="../update.png">
		</a></p>
		
		<table>
			<tr><th>Text</th><th>Start</th><th>End</th><th>Edit</th><th>Delete</th></tr>
			<c:forEach var="task" items="${tasks}">
 			<tr>
 				<td>${task.text}</td>
    			<td>${task.start}</td>
    			<td>${task.end}</td>
    			<td>
    				<c:url var="editUrl" value="/Task/edit">
    					<c:param name="id" value="${task.id}" />
					</c:url>
					<a href="${editUrl}" class="edit-button">Edit</a>
    			</td>
    			<td>
	    			<form method="post" action='<c:url value="/Task/delete" />' style="display:inline;">
		        		<input type="hidden" name="id" value="${task.id}">
		        		<input type="submit" class="delete-button" value="Delete">
	    			</form>
    			</td>
 			</tr>
			</c:forEach>
		</table>
	</body>
</html>