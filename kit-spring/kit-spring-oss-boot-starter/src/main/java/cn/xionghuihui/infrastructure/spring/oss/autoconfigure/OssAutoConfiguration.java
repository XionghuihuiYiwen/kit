package cn.xionghuihui.infrastructure.spring.oss.autoconfigure;

import cn.xionghuihui.infrastructure.spring.oss.autoconfigure.minio.MinioCustomizer;
import io.minio.MinioClient;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 文件服务自动配置
 *
 * @author huihui.xiong
 * @since 2022-08-19 17:23:59
 */
@Configuration
@EnableConfigurationProperties(OssProperties.class)
@ConditionalOnProperty(prefix = OssProperties.PREFIX, name = "enable",havingValue = "true", matchIfMissing = true)
public class OssAutoConfiguration {

    /**
     * Minio 相关配置信息
     */
    @ConditionalOnProperty(prefix = OssProperties.PREFIX, name = "active", havingValue = "minio")
    @Configuration
    public static class MinioAutoConfiguration {

        /**
         * OkHttpClient 相关配置
         */
        @ConditionalOnMissingBean(OkHttpClient.class)
        @Bean
        public OkHttpClient okHttpClient() {
            return new OkHttpClient.Builder().build();
        }

        /**
         * MinioClient相关配置
         */
        @ConditionalOnMissingBean(MinioClient.class)
        @Bean
        public MinioClient minioClient(OssProperties ossProperties, OkHttpClient okHttpClient,
                                       ObjectProvider<MinioCustomizer> customers) {
            MinioClient.Builder builder = MinioClient.builder()
                    .endpoint(ossProperties.getEndpoint())
                    .credentials(ossProperties.getAccessKey(), ossProperties.getSecretKey())
                    .httpClient(okHttpClient);
            customers.stream().forEach(minioCustomizer -> minioCustomizer.customize(builder));
            return builder.build();
        }
    }
}
