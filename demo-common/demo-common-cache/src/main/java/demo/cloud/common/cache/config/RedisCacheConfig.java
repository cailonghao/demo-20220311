package demo.cloud.common.cache.config;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import demo.cloud.common.cache.adapter.CacheTtlAdapter;
import demo.cloud.common.cache.bo.CacheNameWithTtlBO;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@EnableCaching
@Configuration
public class RedisCacheConfig {

    @Resource
    LettuceConnectionFactory lettuceConnectionFactory;


    @Bean
    public CacheManager cacheManager(CacheTtlAdapter cacheTtlAdapter) {

        RedisCacheManager redisCacheManager = new RedisCacheManager(

                RedisCacheWriter.nonLockingRedisCacheWriter(lettuceConnectionFactory),
                // ??????????????????????????? key ???????????????
                this.getRedisCacheConfigurationWithTtl(3600),
                // ?????? key ??????
                this.getRedisCacheConfigurationMap(cacheTtlAdapter));

        redisCacheManager.setTransactionAware(true);
        return redisCacheManager;
    }

    private Map<String, RedisCacheConfiguration> getRedisCacheConfigurationMap(CacheTtlAdapter cacheTtlAdapter) {
        if (cacheTtlAdapter == null) {
            return Collections.emptyMap();
        }
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>(16);

        for (CacheNameWithTtlBO cacheNameWithTtlBO : cacheTtlAdapter.listCacheNameWithTtl()) {
            redisCacheConfigurationMap.put(cacheNameWithTtlBO.getCacheName(),
                    getRedisCacheConfigurationWithTtl(cacheNameWithTtlBO.getTtl()));
        }
        return redisCacheConfigurationMap;
    }

    private RedisCacheConfiguration getRedisCacheConfigurationWithTtl(Integer seconds) {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        redisCacheConfiguration = redisCacheConfiguration
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer()))
                .entryTtl(Duration.ofSeconds(seconds));

        return redisCacheConfiguration;
    }

    /**
     * ?????????redis??????????????????,??????????????????ObjectMapper.?????????MVC?????????
     * https://juejin.im/post/5e869d426fb9a03c6148c97e
     */
    @Bean
    public RedisSerializer<Object> redisSerializer() {
        ObjectMapper objectMapper = new ObjectMapper();
        // ????????????????????????????????????????????????????????????
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // ?????????????????????????????????????????????
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // ?????????????????????????????????????????????,???????????????
        objectMapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
        // ??????????????????dateTime???????????????,
        objectMapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        // ??????JSR310?????????????????????,????????????????????????JDK8??????????????????
        objectMapper.registerModule(new JavaTimeModule());
        // ???????????????????????????????????????,??????????????????@class
        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL,
                JsonTypeInfo.As.PROPERTY);
        // ??????null??????????????????
        GenericJackson2JsonRedisSerializer.registerNullValueSerializer(objectMapper, null);
        return new GenericJackson2JsonRedisSerializer(objectMapper);
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisSerializer<Object> redisSerializer) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(lettuceConnectionFactory);
        template.setDefaultSerializer(redisSerializer);
        template.setValueSerializer(redisSerializer);
        template.setHashValueSerializer(redisSerializer);
        template.setKeySerializer(StringRedisSerializer.UTF_8);
        template.setHashKeySerializer(StringRedisSerializer.UTF_8);
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate() {
        return new StringRedisTemplate(lettuceConnectionFactory);
    }

    @Bean
    @ConditionalOnMissingBean
    public CacheTtlAdapter cacheTtl() {
        return Collections::emptyList;
    }

}
