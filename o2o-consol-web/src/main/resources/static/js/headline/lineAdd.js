function submitUpload() {
    $("#addForm").ajaxSubmit({
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
    var lineName = $("#addForm input[name=lineName]").val();
    if (lineName == "") {
        alert("导航名称不能为空！");
        $("#addForm input[name=lineName]").focus();
        return false;
    }
    var priority = $("#addForm [name=priority]").val();
    if (priority == "") {
        alert("优先级不能为空！");
        $("#addForm [name=priority]").focus();
        return false;
    }
    var lineImg = $("#addForm input[name=lineImg]").val();
    if (lineImg == "") {
        alert("图片不能为空！");
        $("#addForm input[name=lineImg]").focus();
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

function lineSave() {
    if (checkForm()) {
        $.ajax({
            type: "POST",
            url: "/headline/headLineSave",
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