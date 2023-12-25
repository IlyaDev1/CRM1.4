<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Add Client</title>
		<link rel="stylesheet" type="text/css" href="../addstyle.css">
	</head>
	
	<body>
		<p><a href="${pageContext.request.contextPath}/Client/index" class="button-back">
    		<img src="../back.png">
		</a></p>
		<h3>New Client</h3>
		<form method="post">
			<label>Name</label><br>
			<input name="name"/><br><br>
			<label>Lesson(ID)</label><br>
			<input name="lesson"/><br><br>
			<input type="submit" value="Save" />
		</form>
	</body>
</html>