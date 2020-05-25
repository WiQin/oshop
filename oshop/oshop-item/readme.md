#商品微服务
创建聚合工程
1.api:提供服务需要的接口，实体类等  
2.service:具体业务实现  
2.1引依赖 
2.2启动类，配置

## 商品分类查询

##跨域问题解决
浏览器向服务端查询分类数据有跨域限制
浏览器对ajax的安全限制，阻止跨站攻击
==>页面（manage.oshop.com）  到  后台(api.oshop.com)

解决：
jsonp（script标签 只能发起GET请求）   nginx反向代理   CORS

CORS（跨域资源共享）

##品牌管理
tb_brand  tb_category_brand
后台提供接口
1.品牌查询
2.品牌新增  
名称，首字母，logo,分类（三级都选择，允许多选）
路径：api/item/brand    请求方式：post

###图片上传  oshop-upload
剥离为一个微服务

##商品表结构设计
###规格
不用分类商品规格参数不同--需基于相同分类做设计
相同分类下不同商品规格值不同--规格的key和value分开保存，保存到两张表中
key与分类绑定，value与商品绑定
规格参数模板设计：竖表设计（分类id,规格参数名称）
规格需要分组，也进行竖表设计，规格组

实例设计：类别  规格  组   属性

####规格组查询实现
SpecGroup
####当前规格组规格参数查询
SpecParam

###SPU和SKU数据结构
SPU:标准产品单位，一组具有共同属性的商品集（所有SKU共享的属性）
SKU:库存量单位，SPU商品集因具体特性不同而细分的每个商品（每个SKU的特有属性）

SPU：id（主键）  title(标题)  description(描述)  specification(规格)  packing_list(包装)  after_service(售后服务)  comment(评价)
SKU：标题  价格  对于商品特有参数（颜色，内存等）如何设计-->包含在规格参数中-->需在规格参数中加字段（generic  是否为sku通用属性）

SPU: SPU_PARAM  SPU_DETAIL
SKU: SKU  STOCK

##商品查询
###商品列表查询