layui.config({
    base: $pathConfig.resUrl + 'plus/common/js/'
}).extend({
    ajaxEnc: 'ajaxEnc',
    $tool: 'tool',
    $api: 'api'
    // 加密引入


}).use(['form', 'layer', 'ajaxEnc', '$tool', '$api'], function () {
    var form = layui.form,
        $ = layui.jquery,
        $tool = layui.$tool,
        $api = layui.$api;

    //video背景
    $(window).resize(function () {
        if ($(".video-player").width() > $(window).width()) {
            $(".video-player").css({
                "height": $(window).height(),
                "width": "auto",
                "left": -($(".video-player").width() - $(window).width()) / 2
            });
        } else {
            $(".video-player").css({
                "width": $(window).width(),
                "height": "auto",
                "left": -($(".video-player").width() - $(window).width()) / 2
            });
        }
    }).resize();

    /**
     *  form 表单提交
     */
    form.on("submit(login)", function (data) {
        alert("表单数据："+ JSON.stringify(data.field));
        // 封装参数
        var params = {
            username: data.field.username,

            // 需要$sha1 加密
            password: data.field.password,
            code: data.field.code
        };
        //请求
        $api.Login(params, function (res) {
                    var datas = res.data;
                    console.log("datas:" + datas);
                    sessionStorage.setItem("sysUser", datas.username);
                    sessionStorage.setItem("userId", datas.userId);
                    location.href = $tool.getContext() + "views/index.html";
        });
        return false;
    });

    function getCookie(name){
        var r = document.cookie.match("\\b" + name + "=([^;]*)\\b");
        return r ? r[1] : undefined;
    }

    /**
     * 获取验证码
     * @Author YaoGuangXun
     * @Date 18:50 2019/6/29
     **/
    $('#img').click(function () {
        var src = $tool.getContext() + 'code/getVCode';
        $(this).attr('src',src);
    });

    // 初始化验证码
    initVerificationCode();

    /**
     * 获取验证码
     * @Author YaoGuangXun
     * @Date 16:15 2019/6/29
     **/
    function initVerificationCode() {

        if (!isLogin()) {
            window.location.href= $tool.getContext() +"views/index.html";
        } else {
            $('#img').click();
        }

    }


    /**
     * 判断是否登录
     * @Author YaoGuangXun
     * @Date 16:24 2019/6/29
     **/
    function isLogin() {
        var userId = window.sessionStorage.getItem("userId");
        return $tool.isBlank(userId);
    }

});