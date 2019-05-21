function submitUpload() {
    $("#editForm").ajaxSubmit({
        type: "post",
        url: "/upload/uploadPic",
        dataType: "text",
        success: function (data) {
            var jsonObject = $.parseJSON(data);
            $("#line_image").attr("src", jsonObject.realPath);
            $("#lineImg").val(jsonObject.relativePath);
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
    var lineName = $("#editForm input[name=lineName]").val();
    if (lineName == "") {
        alert("导航名称不能为空！");
        $("#editForm input[name=lineName]").focus();
        return false;
    }
    var priority = $("#editForm [name=priority]").val();
    if (priority == "") {
        alert("优先级不能为空！");
        $("#editForm [name=priority]").focus();
        return false;
    }
    var lineImg = $("#editForm input[name=lineImg]").val();
    if (lineImg == "") {
        alert("图片不能为空！");
        $("#editForm input[name=lineImg]").focus();
        return false;
    }
    var captCha_in = $("#editForm input[name=captCha_in]").val();
    if (captCha_in == "") {
        alert("验证码不能为空！");
        $("#editForm input[name=captCha_in]").focus();
        return false;
    }
    return true;
}

function lineUpdate() {
    if (checkForm()) {
        $.ajax({
            type: "POST",
            url: "/headline/headLineUpdate",
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