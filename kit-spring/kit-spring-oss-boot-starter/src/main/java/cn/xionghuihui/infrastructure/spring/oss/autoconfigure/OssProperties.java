package cn.xionghuihui.infrastructure.spring.oss.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;

/**
 * OSS相关配置
 *
 * @author huihui.xiong
 * @since 2022-08-19 17:24:48
 */
@ConfigurationProperties(prefix = OssProperties.PREFIX)
public class OssProperties {

    public static final String PREFIX = "kit.oss";

    /**
     * 激活的配置
     */
    private String active;

    /**
     * Minio地址
     */
    private String endpoint;

    /**
     * accessKey
     */
    private String accessKey;

    /**
     * secretKey
     */
    private String secretKey;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
