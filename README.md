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
    ** Eureka已停更，后续新项目不建议使用
## 6. 使用ZooKeeper作为注册服务中心
    1、cloud-provider-payment-zk-8004，
     改用zookeeper作为注册中心，pom.xml引入zookeeper的包
    2、创建一个新模块cloud-zookeeper-server-
## 7. 使用consul作为注册服务中心
    1、新建服务提供者，cloud-provider-payment-consul-8006，并注册到consul
    2、新建服务消费者，cloud-consume-order-consul-9006，并注册到consul
## 8. 使用openFeign
    1、新建模块， cloud-consume-order-feign-9007
## 9. 基于Nacos的服务提供者（作为注册服务中心）
###  1、下载安装
    https://nacos.io
    安装，解压即可
###  2、运行
    bin目录下，
    修改为单机模式，set MODE="standalone"
    打开命令行窗口，运行，startup.cmd
###  3、浏览器打开
        http://localhost:8848 ,    用户名/密码：nacos/nacos
###  4、创建新模块，作为服务提供者
       cloud-alibaba-provider-payment-9001
#### 父pom.xml中添加
        ```
            <dependency>
                <groupId>com.alibaba.cloud</groupId>
                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                <version>2.1.0.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        ```
#### 本工程pom.xml中添加
    nacos作为注册服务中心
        ```
            <!-- spring cloud alibaba nacos discovery -->
            <dependency>
                <groupId>com.alibaba.cloud</groupId>
                <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
            </dependency>
        ```
#### 配置application.yml
#### 主启动类上加@EnableDiscoveryClient注解
#### 加业务类PaymentController

## 10. 基于Nacos的服务消费者（支持负载均衡）
    1、新建模块， cloud-alibaba-consume-order-10001
    2、添加主类、配置类、controller类
## 11. Nacos作为服务配置中心
    1、新建模块，cloud-alibaba-config-nacos-11001
    2、pom.xml
    ```
        <!-- alibaba nacos config -->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
        </dependency>
    ```
    3、配置文件
        application.yml
        bootstrap.yml ,优先级高于application
    4、主类、controller类
    
    
    

