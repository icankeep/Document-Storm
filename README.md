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


