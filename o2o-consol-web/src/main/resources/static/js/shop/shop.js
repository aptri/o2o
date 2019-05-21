$(function () {
    $("#toAddView").click(function () {
        window.location.href="/shop/toShopAdd";
    });
});
function editView(shopId) {
    window.location.href="/shop/shopEdit?shopId="+shopId;
}