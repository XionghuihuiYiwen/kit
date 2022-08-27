package cn.xionghuihui.infrastructure.kit.common.exception;

import cn.xionghuihui.infrastructure.kit.common.base.BaseException;

/**
 * 业务异常
 *
 * @author huihui.xiong
 * @since 2022-07-06 17:48:25
 */
public class BizException extends BaseException {

    private final IExceptionInfo iExceptionInfo;

    public BizException(IExceptionInfo iExceptionInfo) {
        super(iExceptionInfo.getErrorMessage());
        this.iExceptionInfo = iExceptionInfo;
    }

    public BizException(String message, IExceptionInfo iExceptionInfo) {
        super(message);
        this.iExceptionInfo = iExceptionInfo;
    }

    public BizException(String message, Throwable cause, IExceptionInfo iExceptionInfo) {
        super(message, cause);
        this.iExceptionInfo = iExceptionInfo;
    }

    public BizException(Throwable cause, IExceptionInfo iExceptionInfo) {
        super(cause);
        this.iExceptionInfo = iExceptionInfo;
    }

    public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, IExceptionInfo iExceptionInfo) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.iExceptionInfo = iExceptionInfo;
    }

    public IExceptionInfo getiExceptionInfo() {
        return iExceptionInfo;
    }

}
