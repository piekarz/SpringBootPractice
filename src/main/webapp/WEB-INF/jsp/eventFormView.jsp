<!DOCTYPE html>
<html>
<head>
<title>Page Title</title>
</head>
<body>
    <form action="event-register" method="POST">

      Name:<br>
      <input type="text" value = "${param.name}" name="name"><br>

      Surname:<br>
      <input type="text" value ="${param.surname}" name="surname"><br>

      <input type="submit" value="Send">

    </form>
</body>
</html>