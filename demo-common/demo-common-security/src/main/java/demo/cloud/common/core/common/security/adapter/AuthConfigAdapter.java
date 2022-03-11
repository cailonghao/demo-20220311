package demo.cloud.common.core.common.security.adapter;

import java.util.List;

/**
 * 配置授权路径
 */
public interface AuthConfigAdapter {


    List<String> pathPattern();

    List<String> excludePathPattern(String... paths);
}
