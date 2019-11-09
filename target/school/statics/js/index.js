
// var $,tab;
layui.config({
    base: $pathConfig.resUrl + 'plus/common/js/'
}).extend({
    ajaxEnc:'ajaxEnc',
    $api:'api',
    $tool:'tool'
    // bodyTab:'bodyTab'
}).use(['form','element','layer','jquery','ajaxEnc','api','tool'],function () {
    var form = layui.form,
        layer = layui.layer,
        element = layui.element,
        $ = layui.jquery,
        api = layui.api,
        tool = layui.tool;

    $(".signOut").click(function () {

    });


});