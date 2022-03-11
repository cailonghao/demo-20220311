package demo.cloud.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"demo.cloud"})
public class DemoAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoAuthApplication.class, args);
    }
}

