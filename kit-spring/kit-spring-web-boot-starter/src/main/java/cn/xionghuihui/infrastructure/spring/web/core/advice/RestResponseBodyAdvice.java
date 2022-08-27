package cn.xionghuihui.infrastructure.spring.web.core.advice;

import cn.xionghuihui.infrastructure.kit.common.vo.RestResult;
import cn.xionghuihui.infrastructure.spring.web.anno.RawResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author huihui.xiong
 * @since 2022-07-07 15:00:05
 */
@RestControllerAdvice
public class RestResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 如果当前对象本身就是RestResult类型的数据，直接返回即可
        if (returnType.getGenericParameterType().equals(RestResult.class)) {
            return false;
        }
        // String 类型直接返回，因为其默认是采用 String消息转换器，在beforeBodyWrite写出的时候会报错，处理比较麻烦，需要手动转为String
        if (returnType.getGenericParameterType().equals(String.class)) {
            return false;
        }
        // 只有不被RawResult标记的方法才会进入逻辑
        return !returnType.hasMethodAnnotation(RawResult.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return RestResult.success(body);
    }
}
