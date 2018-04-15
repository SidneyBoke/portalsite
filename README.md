# portalsite
Portal Web

#web.xml
发现我默认生成的web.xml中头部的配置是web-app_2_3.dtd，这就导致后面的servlet、jsp、EL等采用的全是2.3版本，
而在2.3版本中，jsp页面是不支持EL的，所以当我们在jsp中使用语句${message} ，无法得到正确的解析。
应该采用3.0版本：
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
         id="WebApp_ID" version="3.0">
 临时措施：
 在头文件中添加isELIgnored="false"
 <%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
 
 #mapping.xml
 idea开发环境下，xml映射文件应该放在resources目录下，否则无法自动打包到发布包中
 
 #spring AOP or AspectJ
AspectJ需要额外的aspectjweaver.jar包

#viewResolver
jsp和freemarker共同使用，参考http://mxdba.iteye.com/blog/658077和https://blog.csdn.net/z69183787/article/details/40426603

#messageConverters
为了文件下载不出现乱码，添加ByteArray转换器，参考：https://blog.csdn.net/kernel_32/article/details/50792139