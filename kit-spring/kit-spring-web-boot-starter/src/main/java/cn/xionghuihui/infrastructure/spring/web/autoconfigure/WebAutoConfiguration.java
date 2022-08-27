package cn.xionghuihui.infrastructure.spring.web.autoconfigure;

import cn.xionghuihui.infrastructure.spring.web.core.handler.JdbcExceptionHandler;
import cn.xionghuihui.infrastructure.spring.web.core.handler.MybatisExceptionHandler;
import cn.xionghuihui.infrastructure.spring.web.core.handler.WebExceptionHandler;
import cn.xionghuihui.infrastructure.spring.web.core.advice.RestResponseBodyAdvice;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;

/**
 * Web相关通用配置
 *
 * @author huihui.xiong
 * @since 2022-07-07 14:29:45
 */
@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@EnableConfigurationProperties(KitWebProperties.class)
@ConditionalOnProperty(name = WebAutoConfiguration.ENABLE_KEY, havingValue = "true", matchIfMissing = true)
public class WebAutoConfiguration {

    /**
     * 自动配置开关
     */
    public static final String ENABLE_KEY = KitWebProperties.PREFIX + ".enable";

    /**
     * 是否开启自动包装WrapperRest
     */
    public static final String ENABLE_WRAPPER_REST_RESULT = KitWebProperties.PREFIX + ".autoWrapperRestResult";

    /**
     * 是否开启全局异常处理
     */
    public static final String ENABLE_GLOBAL_EXCEPTION_RESULT = KitWebProperties.PREFIX + ".globalExceptionHandler";

    @Bean
    @ConditionalOnProperty(name = ENABLE_WRAPPER_REST_RESULT, havingValue = "true", matchIfMissing = true)
    public RestResponseBodyAdvice restResponseBodyAdvice() {
        return new RestResponseBodyAdvice();
    }

    @Bean
    @ConditionalOnProperty(name = ENABLE_GLOBAL_EXCEPTION_RESULT, havingValue = "true", matchIfMissing = true)
    public WebExceptionHandler controllerExceptionAdvice() {
        return new WebExceptionHandler();
    }

    @Bean
    @ConditionalOnProperty(name = ENABLE_GLOBAL_EXCEPTION_RESULT, havingValue = "true", matchIfMissing = true)
    @ConditionalOnBean(PersistenceException.class)
    public MybatisExceptionHandler mybatisExceptionHandler() {
        return new MybatisExceptionHandler();
    }

    @Bean
    @ConditionalOnProperty(name = ENABLE_GLOBAL_EXCEPTION_RESULT, havingValue = "true", matchIfMissing = true)
    @ConditionalOnBean(DataAccessException.class)
    public JdbcExceptionHandler jdbcExceptionHandler() {
        return new JdbcExceptionHandler();
    }
}
