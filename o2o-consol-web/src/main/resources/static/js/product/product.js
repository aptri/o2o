function submitUpload() {
    $("#editForm").ajaxSubmit({
        type: "post",
        url: "/upload/uploadPic",
        dataType: "text",
        success: function (data) {
            var jsonObject = $.parseJSON(data);
            $("#product_image").attr("src", jsonObject.realPath);
            $("#imgAddr").val(jsonObject.relativePath);
        },
        error: function () {
            alert("系统错误");
        }
    });
    $("#addForm").ajaxSubmit({
        type: "post",
        url: "/upload/uploadPic",
        dataType: "text",
        success: function (data) {
            var jsonObject = $.parseJSON(data);
            $("#product_image").attr("src", jsonObject.realPath);
            $("#imgAddr").val(jsonObject.relativePath);
        },
        error: function () {
            alert("系统错误");
        }
    });
}

function changeVerifyCode(img) {
    img.src = "../Kaptcha?" + Math.floor(Math.random() * 100);
}
function shopDetail(shopId) {
    window.location.href="/product/shopDetail?shopId="+shopId;
}

function editView(productId) {
    window.location.href="/product/productEdit?productId="+productId;
}

function addView() {
    var shopId=$("#shopId").val();
    window.location.href="/product/productAdd?shopId="+shopId;
}

function addOrEditViewBack() {
    var shopId=$("#shopId").val();
    window.location.href="/product/shopDetail?shopId="+shopId;
}
function backShopList() {
    window.location.href="/product/toShopList";
}

function productUpdate() {
    // if (checkForm()) {
        $.ajax({
            type: "POST",
            url: "/product/productUpdate",
            data: $("#editForm").serialize(),
            timeout: 10000,
            success: function (response) {
                if ('failure' == response) {
                    alert(response);
                } else {
                    alert("更新成功！");
                }
            }
        });
    // }
}
function productSave() {
    // if (checkForm()) {
        $.ajax({
            type: "POST",
            url: "/product/productSave",
            data: $("#addForm").serialize(),
            timeout: 10000,
            success: function (response) {
                if ('failure' == response) {
                    alert(response);
                } else {
                    alert("保存成功！");
                }
            }
        });
    // }
}