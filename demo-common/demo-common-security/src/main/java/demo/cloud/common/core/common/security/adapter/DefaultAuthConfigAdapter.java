package demo.cloud.common.core.common.security.adapter;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
public class DefaultAuthConfigAdapter implements AuthConfigAdapter {

    private static final String FEIGN_INSIDER_URI = "/feign/insider/**";

    private static final String EXTERNAL_URI = "/**/ua/**";

    private static final String DOC_URI = "/v2/api-docs";

    public DefaultAuthConfigAdapter() {
        log.info("----------***----------default filter adapter loading ......");
    }

    @Override
    public List<String> pathPattern() {
        return Collections.singletonList("/*");
    }

    @Override
    public List<String> excludePathPattern(String... paths) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add(DOC_URI);
        arrayList.add(FEIGN_INSIDER_URI);
        arrayList.add(EXTERNAL_URI);
        arrayList.addAll(Arrays.asList(paths));
        return arrayList;
    }
}
