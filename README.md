# SpringCloud2020Demo
## 1.创建父工程 

## 2. 创建一个服务提供模块 cloud-provider-payment-8001
### 步骤:
    1、建Maven Module模块
    2、改pom.xml
    3、写配置文件application.yml
    4、主启动类
    5、其它业务类等
### 包名划分
    common,公共类
    utils,工具类
    entity,实体类,与数据库表一一对应,继承Model<>,实现pkVal()
    dto,数据转换类,根据controller方法中定义的参数要求
    vo,最终返回给调用者的数据包装格式
    service,服务层的方法
    controller,控制层的方法
    mapper,继承BasedMapper<>的接口,实现数据库的操作
    

