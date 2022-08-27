package cn.xionghuihui.infrastructure.kit.common.exception;

/**
 * 系统预定义异常
 *
 * @author huihui.xiong
 * @since 2022-07-06 18:00:42
 */
public enum SystemExceptionInfo implements IExceptionInfo {

    /**
     * 服务器出现异常，属于未知错误才会抛出
     */
    SYS_ERROR("1001001000", "服务端异常"),

    BAD_REQUEST_ERROR("1001001001", "请求错误"),

    DATA_ACCESS_ERROR("1001001002", "数据库访问异常"),

    VALIDATE_ERROR("1001001003", "参数错误"),

    ;
    private final String errorCode;
    private final String errorMessage;

    SystemExceptionInfo(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }
}
