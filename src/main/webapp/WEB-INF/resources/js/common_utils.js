
let showResponseAlert = function (resType, msg , alertElemId = 'divResponseAlert',  timeout=4000) {

    $('#' + alertElemId).show();
    $('#' + alertElemId).addClass(resType);
    $('#' + alertElemId).text(msg);

    window.setTimeout(function() {
        $('#' + alertElemId).slideUp(500, function(){
            $(this).hide();
        });
    }, timeout);
}