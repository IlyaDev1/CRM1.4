<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Edit lesson</title>
	<link rel="stylesheet" type="text/css" href="../addstyle.css">
	</head>
	
	<body>
		<h3>Edit lesson</h3>
		<form method="post">
		<input type="hidden" value="${lesson.id}" name="id" />
		<label>time</label><br>
		<input name="time" value="${lesson.time}" /><br><br>
		<label>subject</label><br>
		<input name="subject" value="${lesson.subject}" /><br><br>
		<label>category</label><br>
		<input name="category" value="${lesson.category}" /><br><br>
		<input type="submit" value="Send" />
		</form>
	</body>
</html>