<%@ page import="com.helman.Entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: afshin
  Date: 12/23/20
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        body {
            background: #ddf8ff;
        }
        table{
            border: 3px solid #ccc;
            box-sizing: border-box;
        }
        input[type=number] {
            margin: 10px;
            border: 3px solid #ccc;
            box-sizing: border-box;
        }
        #home{
            position: absolute;
            right: 0;
            margin: 5px;
            cursor: pointer;
        }
        #add{
            position: absolute;
            right: 90px;
            margin: 5px;
            cursor: pointer;
        }
        h2 {
            margin: 0 auto 40px;
            font: 40px Helvetica;
            alignment: center;
        }
    </style>
</head>
<body>
<br><div class="container">
    <form action="UserAct" method="post">
        <div>
            <span class="span">Id : <input type="text" name="id"></span>
            <input type="submit" value="Show User" id="submit" class="btn btn-info">
            <input type="hidden" name="crud" value="read">
            <input type="button" value="Home" id="home" class="btn btn-info" onclick="location.href='index.jsp';">
            <input type="button" value="Add" id="add" class="btn btn-info" onclick="location.href='UserAdd.jsp';">
        </div>
    </form>
</div>
    <%String payam = (String) request.getAttribute("message");
    if (payam != null){%>
    <h2><%=payam%></h2>
<%}%>
<div class="container">
    <table>
        <tr>
            <td>Id</td>
            <td>Username</td>
            <td>Password</td>
            <td>Employeefk</td>
            <td>Delete</td>
            <td>Edit</td>
        </tr>
        <%List<User> userList= (List<User>) request.getAttribute("Users");
        if (userList == null){%>
        <h2>There is no data.</h2>
        <%}else{
        for (User user : userList){
        if (user != null){%>
        <tr>
            <td><%=user.getId()%></td>
            <td><%=user.getUsername()%></td>
            <td><%=user.getPassword()%></td>
            <td><%=user.getEmployeefk()%></td>
            <td><a href="/UserAct?id=<%=user.getId()%>&crud=delete">Delete</a></td>
            <td><a href="/UserAct?id=<%=user.getId()%>&crud=edit">edit</a></td>
        </tr>
        <%}}}%>
    </table>
</div>
</body>
</html>
