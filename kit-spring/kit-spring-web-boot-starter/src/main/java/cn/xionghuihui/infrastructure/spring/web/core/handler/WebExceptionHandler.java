package cn.xionghuihui.infrastructure.spring.web.core.handler;

import cn.xionghuihui.infrastructure.kit.common.exception.BizException;
import cn.xionghuihui.infrastructure.kit.common.exception.SystemExceptionInfo;
import cn.xionghuihui.infrastructure.kit.common.vo.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.StringJoiner;

/**
 * Rest请求异常统一拦截
 *
 * @author huihui.xiong
 * @since 2022-07-07 14:51:29
 */
@RestControllerAdvice
public class WebExceptionHandler {

    /**
     * 日志输出
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(WebExceptionHandler.class);

    /**
     * 处理业务异常
     */
    @ExceptionHandler(BizException.class)
    public RestResult<?> handlePlatformException(BizException exception) {
        LOGGER.error("业务异常", exception);
        return RestResult.error(exception.getiExceptionInfo());
    }

    /**
     * 处理 SpringMVC 请求参数缺失
     *
     * 例如说，接口上设置了 @RequestParam("xx") 参数，结果并未传递 xx 参数
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public RestResult<?> missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException ex) {
        LOGGER.warn("SpringMVC 请求参数缺失异常", ex);
        return RestResult.errorWithMessage(SystemExceptionInfo.BAD_REQUEST_ERROR, String.format("请求参数缺失:%s", ex.getParameterName()));
    }

    /**
     * 处理 SpringMVC 请求参数类型错误
     *
     * 例如说，接口上设置了 @RequestParam("xx") 参数为 Integer，结果传递 xx 参数类型为 String
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public RestResult<?> methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException ex) {
        LOGGER.warn("SpringMVC 请求参数类型错误", ex);
        return RestResult.errorWithMessage(SystemExceptionInfo.BAD_REQUEST_ERROR, String.format("请求参数类型错误:%s", ex.getMessage()));
    }

    /**
     * 处理 SpringMVC 参数校验不正确
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RestResult<?> methodArgumentNotValidExceptionExceptionHandler(MethodArgumentNotValidException ex) {
        LOGGER.warn("SpringMVC 参数校验异常", ex);
        return RestResult.errorWithMessage(SystemExceptionInfo.BAD_REQUEST_ERROR, getBindErrorMessage(ex.getAllErrors()));
    }

    /**
     * 处理 SpringMVC 参数绑定不正确
     */
    @ExceptionHandler(BindException.class)
    public RestResult<?> bindExceptionHandler(BindException ex) {
        LOGGER.warn("SpringMVC 参数参数绑定异常", ex);
        return RestResult.errorWithMessage(SystemExceptionInfo.BAD_REQUEST_ERROR, getBindErrorMessage(ex.getAllErrors()));
    }

    /**
     * 处理 SpringMVC 请求方法不正确
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public RestResult<?> httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException ex) {
        LOGGER.warn("请求方式错误", ex);
        return RestResult.errorWithMessage(SystemExceptionInfo.BAD_REQUEST_ERROR, String.format("请求方法不正确:%s", ex.getMessage()));
    }

    /**
     * 获取绑定异常信息
     */
    private String getBindErrorMessage(List<ObjectError> allErrors) {
        StringJoiner stringJoiner = new StringJoiner(",");
        allErrors.forEach(objectError -> stringJoiner.add(objectError.getObjectName()));
        return stringJoiner.toString();
    }
}
