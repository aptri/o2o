$(function () {
    $("#toAddView").click(function () {
        window.location.href="/headline/toHeadLineAdd";
    });
    $(".swiper-container").swiper({
        autoplay: 1000,
        autoplayDisableOnInteraction: false
    });

});
function editView(lineId) {
    window.location.href="/headline/toHeadLineEdit?lineId="+lineId;
}

