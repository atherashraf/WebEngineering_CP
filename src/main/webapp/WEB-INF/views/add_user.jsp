<%--
  Created by IntelliJ IDEA.
  User: Dr. Ather Ashraf
  Date: 6/17/2019
  Time: 12:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PUCIT</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h2>${message}</h2>
    <div class="row">
        <div class="col-12 alert" id="divResponseAlert" style="display:none"></div>
    </div>
    <div class="row">
        <div class="col-12">
            <form id="addUserForm" action="insert_user" method="post">
                <div class="form-group">
                    <label for="txtUserName">User Name</label>
                    <input class="form-control form-control-sm" type="text" id="txtUserName" name="user_name"
                           placeholder="User Name" required>
                </div>
                <div class="form-group">
                    <label for="txtEmail">Email address</label>
                    <input class="form-control form-control-sm" type="email" id="txtEmail" name="email"
                           placeholder="Email" required>
                </div>
                <div class="form-group">
                    <label for="txtPassword">Password</label>
                    <input class="form-control form-control-sm" type="password" id="txtPassword" name="pass"
                           placeholder="password" required>
                </div>
                <div class="form-group">
                    <label for="cmbUserType">User Type</label>
                    <select class="form-control form-control-sm" id="cmbUserType" name="user_type" required>
                        <c:forEach var="map" items="${userTypes}">
                            <c:forEach items="${map}" var="user">
                                <option value="${user.value}">${user.key}</option>
                            </c:forEach>
                        </c:forEach>
                    </select>
                </div>
                <div class="row justify-content-center">
                    <button class="btn btn-primary" style="width:150px;" type="submit">Submit</button>
                    <button class="btn btn-info btn-lg" style="width:150px;" type="reset">Reset</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script src="resources/js/common_utils.js"></script>
<script>

    $( "#addUserForm" ).submit(function( event ) {
        event.preventDefault();
        var form = $(this);
        var url = form.attr('action');
        $.ajax({
            type: "POST",
            url: url,
            dataType: 'json',
            data: form.serialize(), // serializes the form's elements.
            success: function(res) {
                showResponseAlert(res.resType,res.msg);
            }
        });
    });
</script>
</html>
