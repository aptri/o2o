function submitUpload() {
    $("#addForm").ajaxSubmit({
        type: "post",
        url: "/upload/uploadPic",
        dataType: "text",
        success: function (data) {
            var jsonObject = $.parseJSON(data);
            $("#shop_image").attr("src", jsonObject.realPath);
            $("#shopImg").val(jsonObject.relativePath);
        },
        error: function () {
            alert("系统错误");
        }
    })
}

function changeVerifyCode(img) {
    img.src = "../Kaptcha?" + Math.floor(Math.random() * 100);
}

function checkForm() {
    var shopName = $("#addForm input[name=shopName]").val();
    if (shopName == "") {
        alert("商铺名称不能为空！");
        $("#addForm input[name=shopName]").focus();
        return false;
    }
    var shopCategoryId = $("#shopCategoryId").val();
    if (shopCategoryId == "") {
        alert("商铺类别不能为空！");
        $("#shopCategoryId").focus();
        return false;
    }
    var areaId = $("#areaId").val();
    if (areaId == "") {
        alert("区域不能为空！");
        $("#areaId").focus();
        return false;
    }
    var shopAddr = $("#addForm [name=shopAddr]").val();
    if (shopAddr == "") {
        alert("地址能为空！");
        $("#addForm [name=shopAddr]").focus();
        return false;
    }
    var phone = $("#addForm input[name=phone]").val();
    if (phone == "") {
        alert("电话不能为空！");
        $("#addForm input[name=phone]").focus();
        return false;
    }
    var shopImg = $("#addForm input[name=shopImg]").val();
    if (shopImg == "") {
        alert("图片不能为空！");
        $("#addForm input[name=shopImg]").focus();
        return false;
    }
    var captCha_in = $("#addForm input[name=captCha_in]").val();
    if (captCha_in == "") {
        alert("验证码不能为空！");
        $("#addForm input[name=captCha_in]").focus();
        return false;
    }
    return true;
}

function shopSave() {
    if (checkForm()) {
        $.ajax({
            type: "POST",
            url: "/shop/shopSave",
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
    }
}