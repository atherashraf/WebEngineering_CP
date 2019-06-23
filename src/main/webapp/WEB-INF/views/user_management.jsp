<%@ page isELIgnored="false" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title>PUCIT</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href='<spring:url value="/css/base.css" />'/>
</head>
<body>
<div class="container">
    <div class="row text-center">
        <h1 class="col-md-12">${message}</h1>
    </div>
    <div class="row">
        <%--<div class="col-12 alert" id="divResponseAlert"></div>--%>
        <jsp:include page="/WEB-INF/views/alert_info.jsp"></jsp:include>
    </div>
    <div class="row">
        <button id="createUserTable" class="btn btn-primary btn-block">Add User Table</button>
        <a id="insertUser" class="btn btn-primary btn-block" href="add_user_form">Add User</a>
    </div>
</div>
</body>

<script>
    $(function () {
        $('#createUserTable').click(function (evt) {
            var url = "create_user_table";
            $.ajax({
                url: url,
                dataType: "json",
                success: function (res) {
                    showResponseAlert(res.resType, res.msg);
                },
                error: function (jqXhr, textStatus, errorThrown) {
                    showResponseAlert('alert-danger', errorThrown);
                }
            })
        });
    })

</script>
</html>
