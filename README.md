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
## 3. 创建一个服务提供模块 cloud-consume-order-8002
## 4. 工程重构，将公共代码抽取到一个公共模块中 cloud-common
    1、创建一个新模块 cloud-common
    2、将上两个模块公用的代码块移到该模块
    3、修改上两个模块的pom.xml，依赖这个公共包
## 5. 使用Eureka作为注册服务中心 
    1、创建一个新模块cloud-eureka-server-7001
    2、改造cloud-provider-payment-8001,可以注册到Eureka
    3、改造cloud-consume-order-8002，可以注册到Eureka

    
    

