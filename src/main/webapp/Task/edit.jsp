<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Edit task</title>
	<link rel="stylesheet" type="text/css" href="../addstyle.css">
	</head>
	
	<body>
		<h3>Edit task</h3>
		<form method="post">
		<input type="hidden" value="${task.id}" name="id" />
		<label>Text</label><br>
		<input name="text" value="${task.text}" /><br><br>
		<label>Start</label><br>
		<input name="start" value="${task.start}"/><br><br>
		<label>End</label><br>
		<input name="end" value="${task.end}"/><br><br>	
		<input type="submit" value="Send" />
		</form>
	</body>
</html>