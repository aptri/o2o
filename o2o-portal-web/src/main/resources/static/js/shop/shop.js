$(function () {
    $("#bn-me").click(function () {
        $.openPanel("#rightPanel");
    });
});
function shopDetail(shopId) {
    window.location.href="/shop/shopDetail?shopId="+shopId;
}
function shopListByCategory(categoryId) {
    window.location.href="/shop/queryShopByCategoryId?categoryId="+categoryId;
}