<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create lesson</title>
		<link rel="stylesheet" type="text/css" href="../addstyle.css">
	</head>
	
	<body>
		<p><a href="${pageContext.request.contextPath}/Lesson/index" class="button-back">
    		<img src="../back.png">
		</a></p>
		<h3>New Lesson</h3>
		<form method="post">
			<label>Time</label><br>
			<input name="time"/><br><br>
			<label>Subject</label><br>
			<input name="subject"/><br><br>
			<label>Category</label><br>
			<input name="category"/><br><br>
			<input type="submit" value="Save" />
		</form>
	</body>
</html>