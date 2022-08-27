package cn.xionghuihui.infrastructure.spring.web.anno;

import com.fasterxml.jackson.annotation.JacksonAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识当前对象直接序列化，而不需要包装成CommonResult
 *
 * @author huihui.xiong
 * @since 2022-07-07 17:33:12
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation
public @interface RawResult {
}
