function submitUpload() {
    $("#editForm").ajaxSubmit({
        type: "post",
        url: "/upload/uploadPic",
        dataType: "text",
        success: function (data) {
            var jsonObject = $.parseJSON(data);
            $("#category_image").attr("src", jsonObject.realPath);
            $("#shopCategoryImg").val(jsonObject.relativePath);
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
    var shopCategoryName = $("#addForm input[name=shopCategoryName]").val();
    if (shopCategoryName == "") {
        alert("商铺名称不能为空！");
        $("#addForm input[name=shopCategoryName]").focus();
        return false;
    }
    var priority = $("#addForm [name=priority]").val();
    if (priority == "") {
        alert("类别优先级不能为空！");
        $("#addForm [name=priority]").focus();
        return false;
    }
    var shopCategoryImg = $("#addForm input[name=shopCategoryImg]").val();
    if (shopCategoryImg == "") {
        alert("图片不能为空！");
        $("#addForm input[name=shopCategoryImg]").focus();
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

function categoryUpdate() {
    if (checkForm()) {
        $.ajax({
            type: "POST",
            url: "/category/categoryUpdate",
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
    }
}