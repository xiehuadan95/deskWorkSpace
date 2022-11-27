使用lite-server快速搭建服务器
作用
快速搭建服务器
自动创建各静态目录

初级玩法
进入项目根目录，执行下列步骤 :

安装lite-server :
npm init
npm install --save-dev lite-server

在package.json中添加启动命令
"scripts": {
 "dev": "lite-server"
},
则运行 npm run dev(或直接lite-server)
lite-server会自动找到index.html并运行

中级玩法
新建配置文件bs-config.json
bs-config.json中可以：
指定监听的端口号，
指定要启动的浏览器，browser是一个数组，可以添加多个浏览器
指定要监视的文件
{
"port":8084,
"browser" : ["chrome"]
}

高级玩法
新建配置文件bs-config.js，但是需要删除前面的bs-config.json
"use strict";
module.exports = {
    "port":8084,
    "browser" : ["chrome"],
    "server": {
        middleware: {
            // overrides the second middleware default with new settings
            1: require('connect-history-api-fallback')({
                index: '/index.html',
                verbose: true,
            }),
        },
    },
};