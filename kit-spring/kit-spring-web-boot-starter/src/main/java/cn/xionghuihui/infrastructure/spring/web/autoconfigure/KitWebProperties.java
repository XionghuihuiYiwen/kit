package cn.xionghuihui.infrastructure.spring.web.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Web配置
 *
 * @author huihui.xiong
 * @since 2022-07-07 14:38:45
 */
@ConfigurationProperties(prefix = KitWebProperties.PREFIX)
public class KitWebProperties {

    public static final String PREFIX = "kit.web";

    /**
     * 全局开关
     */
    private boolean enable = true;

    /**
     * 是否自动包装RestController为 RestResult 对象
     */
    private boolean autoWrapperRestResult = true;

    /**
     * 是否开启全局异常处理
     */
    private boolean globalExceptionHandler = true;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isAutoWrapperRestResult() {
        return autoWrapperRestResult;
    }

    public void setAutoWrapperRestResult(boolean autoWrapperRestResult) {
        this.autoWrapperRestResult = autoWrapperRestResult;
    }

    public boolean isGlobalExceptionHandler() {
        return globalExceptionHandler;
    }

    public void setGlobalExceptionHandler(boolean globalExceptionHandler) {
        this.globalExceptionHandler = globalExceptionHandler;
    }
}
