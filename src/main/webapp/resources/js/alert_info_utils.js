let loadingDiv = $('#loadingDiv');
let responseDiv = $('#divResponseAlert');
loadingDiv.hide();
responseDiv.hide();

let showResponseAlert = function (resType, msg, timeout = 4000) {
    responseDiv.show();
    responseDiv.addClass(resType);
    responseDiv.text(msg);
    window.setTimeout(function () {
        if (responseDiv.is(":visible")) {
            responseDiv.slideUp(500, function () {
                $(this).hide();
            });
        }
    }, timeout);
}

$(document).on({
    ajaxStart: function () {
        if (responseDiv.is(":visible")) responseDiv.hide();
        loadingDiv.css("display", "block");
    },
    ajaxStop: function () {
        loadingDiv.css("display", "none");;
    }
});
