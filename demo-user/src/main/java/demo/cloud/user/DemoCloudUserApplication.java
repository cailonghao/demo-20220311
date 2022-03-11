package demo.cloud.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan(basePackages = "demo.cloud.user.mapper")
@EnableFeignClients(basePackages = {"demo.cloud.api.**.feign"})
@SpringBootApplication(scanBasePackages = {"demo.cloud"})
public class DemoCloudUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCloudUserApplication.class, args);
    }
}
