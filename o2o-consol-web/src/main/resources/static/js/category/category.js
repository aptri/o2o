$(function () {
    $("#toAddView").click(function () {
        window.location.href="/shopCategory/toCategoryAdd";
    });
});
function editView(shopCategoryId) {
    window.location.href="/shopCategory/toCategoryEdit?shopCategoryId="+shopCategoryId;
}