$(function () {
    $("#toAddView").click(function () {
        window.location.href="/headline/toHeadLineAdd";
    });

});
function editView(lineId) {
    window.location.href="/headline/toHeadLineEdit?lineId="+lineId;
}

