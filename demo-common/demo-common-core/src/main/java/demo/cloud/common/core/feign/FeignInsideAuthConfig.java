package demo.cloud.common.core.feign;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Setter
@Getter
@RefreshScope
@Configuration
@ConfigurationProperties("feign.inside")
public class FeignInsideAuthConfig {

    /**
     * feign请求前缀
     */
    public static final String FEIGN_INSIDE_URL_PREFIX = "/feign";

    @Value("${feign.inside.key}")
    private String key;

    @Value("${feign.inside.secret}")
    private String secret;

    @Value("#{'${feign.inside.ips:}'.split(',')}")
    private List<String> ips;
}
