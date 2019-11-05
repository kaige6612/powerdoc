$().ready(function () {
    var ctx = "";
    $("#loginForm").submit(function() {
        var userName = $("#userName").val();
        var password = $("#password").val();
        $.ajax({
            url: "/login/userLogin",
            cache: false,
            async: true,
            method: "post",
            contentType:"application/json",
            data: JSON.stringify({username: userName, password: password}),
            success: function (response) {
                if(response.code == 404) {
                    alert(response.message);
                } else if (response.code == 200) {
                    window.location = "/";
                } else {
                    var msg = response && response.message ?  response.message : "未知错误";
                    alert(msg);
                }
            },
            error : function (req, err) {

            }
        });
        return false;
   });
});