package cn.xionghuihui.infrastructure.spring.oss.autoconfigure.minio;

import io.minio.MinioClient;

/**
 * 提供自定义的配置
 *
 * @author huihui.xiong
 * @since 2022-08-23 11:52:05
 */
@FunctionalInterface
public interface MinioCustomizer {

    void customize(MinioClient.Builder builder);
}
