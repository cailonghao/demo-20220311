package demo.cloud.user;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableAutoDataSourceProxy
@MapperScan(basePackages = "demo.cloud.user.mapper")
@EnableFeignClients(basePackages = {"demo.cloud.api.**.feign"})
@SpringBootApplication(scanBasePackages = {"demo.cloud"})
public class DemoCloudUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCloudUserApplication.class, args);
    }
}
