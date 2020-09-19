package cn.alan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain.class, args);
    }
}