package cn.xionghuihui.infrastructure.kit.common.base;

/**
 * 基础的异常类型
 *
 * @author huihui.xiong
 * @since 2022-07-06 17:47:15
 */
public class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
