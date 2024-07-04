<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>

<!-- action에서 슬래쉬(/)가 없으면 상대경로 사용한다는 것, [현재 URL이 속한 계층 경로 + /save] -->
<form action="save" method="post">
  username: <input type="text" name="username" />
  age:      <input type="text" name="age" />
  <button type="submit">전송</button>
</form>

</body>
</html>