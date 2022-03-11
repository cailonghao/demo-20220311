package demo.cloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"demo.cloud"})
public class DemoCloudUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCloudUserApplication.class, args);
    }
}
