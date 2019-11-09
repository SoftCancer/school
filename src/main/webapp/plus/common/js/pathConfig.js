/**
 * 加密 账号：gameloft9  密码：123456
 *  @Author YaoGuangXun
 * @Date 15:43 2019/8/24
 **/
var devEnv = 'dev';

var $pathConfig = {
    // api请求地址
    apiContext : devEnv === 'product'?'http://127.0.0.1:8080/school/':'http://127.0.0.1:8080/',
// 前端资源访问根目录,生产环境请设置为托管前端资源的位置
    resUrl : devEnv === 'product'?'http://127.0.0.1:8080/school/':'http://127.0.0.1:8080/'
};