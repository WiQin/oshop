##文件上传微服务

###图片上传
请求路径：api/upload/image  
请求方式:POST
请求参数：文件，参数类型为file，不过spring会封装为MultipleFile
响应参数：上传成功后得到的文件url路径


逻辑实现：略

添加路由
禁止忽略路由前缀
绕过网关缓存  
默认情况下，所有的请求经过Zuul网代理，默认会通过SpringMVC预先对请求进行处理，缓存。普通请求并不会有什么问题，但是对于文件上传，就会造成不必要的网络负担。在高并发时，可能导致网络瘫痪，网络阻塞，Zuul网关不可用。这样我们的整个系统就瘫痪了。

所以，我们上传文件的请求需要绕过Zuul的请求缓存，直接通过路由到达目标微服务：

官方文档：

通过Zuul上传文件
如果您@EnableZuulProxy您可以使用代理路径上传文件，只要文件很小，它就应该工作。对于大文件，有一个替代路径绕过“/ zuul / ”中的Spring DispatcherServlet（以避免多部分处理）。也就是说，如果zuul.routes.customers=/customers/*则可以将大文件发送到“/ zuul / customers / *”。servlet路径通过zuul.servletPath进行外部化。如果代理路由引导您通过Ribbon负载均衡器，例如，超大文件也将需要提升超时设置

我们这里借助于Nginx完成配置：

# 解决zuul放行请求（不缓存）
location /api/upload {
    rewrite "^/(.*)$" /zuul/$1;
}