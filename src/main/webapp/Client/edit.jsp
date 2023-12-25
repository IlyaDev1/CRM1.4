<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Edit Client</title>
	<link rel="stylesheet" type="text/css" href="../addstyle.css">
	</head>
	
	<body>
		<h3>Edit client</h3>
		<form method="post">
		<input type="hidden" value="${client.id}" name="id" />
		<label>name</label><br>
		<input name="name" value="${client.name}" /><br><br>
		<label>lesson</label><br>
		<input name="lesson" value="${client.lesson}" /><br><br>
		<input type="submit" value="Send" />
		</form>
	</body>
</html>