package cn.alan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 在github上创建一个spring-cloud-config-center仓库
 * 并在master分支下，创建config-dev.yml,config-test.yml
 * 运行后，通过浏览器访问
 * http://localhost:3344/master/config-dev.yml
 */

@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain.class, args);
    }
}
