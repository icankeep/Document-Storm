# Document-Storm
实现文档转换的一个网站，目前支持PDF转Word，对Word文档进行翻译等操作，网站还可以获取网易云热门评论等信息

## 环境

部署在阿里云服务器：http://47.100.45.234:8080/docstorm/

JDK1.8

基于Maven构建的JavaWeb项目

使用Tomcat服务器

使用Java原生Servlet和Jsp进行开发，前端使用JavaScript,JQuery和BootStrap进行开发

翻译模块：用了谷歌翻译相关的翻译接口

网易云模块：爬取网易云23个排行榜歌曲列表,一次爬取一个列表,在内存中存储一个列表的所有歌曲热门评论,
每次请求随机获取一个评论,所有评论用完之后再爬取下一个歌曲列表

[测试文件](https://github.com/icankeep/Document-Storm/tree/master/src/test/resources)

已知bug:

- markdown转pdf如果markdown文件中存在中文会乱码
- 上传的文件名如果为中文,自动变为下划线

原因:时间仓促，未进行编码相关转换,所以尽量使用英文文件英文名!

代码写的不是特别整洁,后面有机会再修改顺便完善

![2019-05-22 19-47-53屏幕截图.png](https://i.loli.net/2019/05/22/5ce5386cbf0b394548.png)


## 2020.3.16更新，停止维护，网站已停，最后更新一下部署步骤

## 部署DocumentStorm
（当初部署的时候就觉得属实麻烦，可惜当初没学docker，现在也懒得去改了）
1. 在主机安装wkhtml
2. [nginx配置文件](#nginx.conf)，[整个nginx压缩包](nginx.tar.gz)
3. 部署云音乐爬取项目，部署后启动(项目在主文件夹[NeteaseCloudMusicApi.tar.gz](NeteaseCloudMusicApi.tar.gz)
4. 部署DocumentStorm，放置在tomcat的webapp下，并更改sever.xml
5. tomcat配置文件server.xml,在项目主文件夹,[整个tomcat压缩包](tomcat.zip)


## nginx.conf
```
user  www www;
worker_processes auto;
error_log  /www/wwwlogs/nginx_error.log  crit;
pid        /www/server/nginx/logs/nginx.pid;
worker_rlimit_nofile 51200;

events
    {
        use epoll;
        worker_connections 51200;
        multi_accept on;
    }

http
    {
        include       mime.types;
		#include luawaf.conf;

		include proxy.conf;

        default_type  application/octet-stream;

        server_names_hash_bucket_size 512;
        client_header_buffer_size 32k;
        large_client_header_buffers 4 32k;
        client_max_body_size 50m;

        sendfile   on;
        tcp_nopush on;

        keepalive_timeout 60;

        tcp_nodelay on;

        fastcgi_connect_timeout 300;
        fastcgi_send_timeout 300;
        fastcgi_read_timeout 300;
        fastcgi_buffer_size 64k;
        fastcgi_buffers 4 64k;
        fastcgi_busy_buffers_size 128k;
        fastcgi_temp_file_write_size 256k;
		fastcgi_intercept_errors on;

        gzip on;
        gzip_min_length  1k;
        gzip_buffers     4 16k;
        gzip_http_version 1.1;
        gzip_comp_level 2;
        gzip_types     text/plain application/javascript application/x-javascript text/javascript text/css application/xml;
        gzip_vary on;
        gzip_proxied   expired no-cache no-store private auth;
        gzip_disable   "MSIE [1-6]\.";

        limit_conn_zone $binary_remote_addr zone=perip:10m;
		limit_conn_zone $server_name zone=perserver:10m;

        server_tokens off;
        access_log off;

## https配置，若没有也可以不配置   
server {
listen 443;
server_name docstorm.top;  # localhost修改为您证书绑定的域名。
ssl on;   #设置为on启用SSL功能。
ssl_certificate cert/docstorm.top.pem;   #将domain name.pem替换成您证书的文件名。
ssl_certificate_key cert/docstorm.top.key;   #将domain name.key替换成您证书的密钥文件名。
ssl_session_timeout 5m;
ssl_ciphers ECDHE-RSA-AES128-GCM-SHA256:ECDHE:ECDH:AES:HIGH:!NULL:!aNULL:!MD5:!ADH:!RC4;  #使用此加密套件。
ssl_protocols TLSv1 TLSv1.1 TLSv1.2;   #使用该协议进行配置。
ssl_prefer_server_ciphers on;   
location / {
proxy_pass http://127.0.0.1:8080;
}
}

## 端口映射，外部的80端口映射到内部3000，也就是外部访问localhost:80就可以到云音乐项目的主页  
server 
{
	listen  80;
	server_name localhost;
	location /
        {
		proxy_pass http://127.0.0.1:3000;
	}
}

server
    {
        listen 888;
        server_name phpmyadmin;
        index index.html index.htm index.php;
        root  /www/server/phpmyadmin;

        #error_page   404   /404.html;
        include enable-php.conf;

        location ~ .*\.(gif|jpg|jpeg|png|bmp|swf)$
        {
            expires      30d;
        }

        location ~ .*\.(js|css)?$
        {
            expires      12h;
        }

        location ~ /\.
        {
            deny all;
        }

        access_log  /www/wwwlogs/access.log;
    }
include /www/server/panel/vhost/nginx/*.conf;
}
```




