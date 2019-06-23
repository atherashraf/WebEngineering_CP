<%--
  Created by IntelliJ IDEA.
  User: Dr. Ather Ashraf
  Date: 6/23/2019
  Time: 11:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>PUCIT</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href='<spring:url value="/css/base.css" />' />
</head>
<body>
    <div class="container">
        <div class="row text-center">
            <h1 class="col-md-12">${message}</h1>
        </div>
        <div class="row">
            <a class="btn btn-primary btn-block" href="user_info/">User Management</a>
        </div>
    </div>
</body>
</html>
