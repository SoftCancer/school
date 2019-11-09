
layui.define(['jquery','$tool'],function (exports) {

    // 引入tool.js,使用其中的方法；
    var $tool = layui.$tool,
        // 引入jquery
        $ = layui.jquery


    /**
     * 封装post请求
     * @param url ：请求地址；
     * @param params：请求参数；
     * @param successCallback ：成功回调
     * @param erorCallback
     */
    function doPost(url,params,successCallback,errorCallback) {
        $.ajax({
            url:url,
            data:params,
            method:'post',
            dataType:'json',//数据类型为json
            success:function (data) {
                // alert("请求成功："+JSON.stringify(data));
                successCallback(data);
            },
            error:function (error) {
                // alert("请求shibai："+JSON.stringify(error));
                errorCallback(error);
            }
        });
    }
    /**
     * 封装 GET 请求
     * @param url ：请求地址；
     * @param params：请求参数；
     * @param successCallback ：成功回调
     * @param erorCallback
     */
    function doGet(url,params,successCallback,errorCallback) {
        $.ajax({
            url:url,
            data:params,
            method:'get',
            success:function (data) {
                successCallback(data);
            },
            error:function (error) {
                errorCallback(error);
            }
        });
    }


    var API ={

        // 登录请求
        Login:function (params,successCallback,errorCallback) {
            doPost($tool.getContext() + "login/auth",params,successCallback,errorCallback);
        }


    };

    // 输出扩展模块
    exports('$api',API);



});