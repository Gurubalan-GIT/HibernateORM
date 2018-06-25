<%@ page import="java.io.PrintWriter" %>
<%--
  Author: Gurubalan Harikrishnan
  Date: 24-06-2018
  Time: 21:25
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registered</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/custom.css" rel="stylesheet">
    <script src="js/jQuery-3.3.1.js"></script>
    <script src="js/jQuery.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<%
    String email=(String)session.getAttribute("email");
%>
<div class="text-center">
    Success! <%= email %>
</div>
</body>
</html>
