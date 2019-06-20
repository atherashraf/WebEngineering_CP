<%@ page isELIgnored="false" %>
<html>
<head>
    <title>PUCIT</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <div class="row"><h2>${message}</h2></div>
    <div class="row">
        <div class="col-12 alert" id="divResponseAlert"></div>
    </div>
    <div class="row">
        <button id="createUserTable" class="btn btn-primary btn-block">Add User Table</button>
        <a id="insertUser" class="btn btn-primary btn-block" href="add_user_form">Add User</a>
    </div>
</div>
</body>
<script src="resources/js/common_utils.js"></script>
<script>
    $(function () {
        $('#divResponseAlert').hide();
        $('#createUserTable').click(function (evt) {
            var url = "create_user_table";
            $.ajax({
                url: url,
                dataType: "json",
                success: function (res) {
                    showResponseAlert(res.resType, res.msg);
                },
                error: function (jqXhr, textStatus, errorThrown) {
                    // $('#divResponseAlert').text(errorThrown);
                    // console.exception(errorThrown);
                    showResponseAlert('alert-danger', errorThrown);
                }
            })
        });
    })

</script>
</html>
