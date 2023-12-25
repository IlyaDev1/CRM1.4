<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create Task</title>
		<link rel="stylesheet" type="text/css" href="../addstyle.css">
	</head>
	
	<body>
		<p><a href="${pageContext.request.contextPath}/Task/index" class="button-back">
    		<img src="../back.png">
		</a></p>
		<h3>New Task</h3>
		<form method="post">
			<label>Text</label><br>
			<input name="text"/><br><br>
			<label>Start</label><br>
			<input name="start"/><br><br>
			<label>End</label><br>
			<input name="end"/><br><br>
			<input type="submit" value="Save" />
		</form>
	</body>
</html>