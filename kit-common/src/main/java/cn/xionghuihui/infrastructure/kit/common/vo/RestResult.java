package cn.xionghuihui.infrastructure.kit.common.vo;

import cn.xionghuihui.infrastructure.kit.common.exception.IExceptionInfo;

import java.io.Serializable;
import java.util.Objects;

/**
 * Rest接口通用返回对象
 *
 * @author huihui.xiong
 * @since 2022-07-07 10:00:58
 */
public class RestResult<T> implements Serializable {

    private static final long serialVersionUID = 3176254131787524237L;

    /**
     * 处理成功时的Code码
     */
    public static final String SUCCESS_CODE = "1";

    /**
     * 响应码
     */
    private String code;

    /**
     * 消息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    /**
     * 根据IExceptionInfo构建返回结果
     * @param errorInfo 错误描述
     * @return          RestResult返回结果
     */
    public static <T> RestResult<T> error(IExceptionInfo errorInfo) {
        RestResult<T> result = new RestResult<>();
        result.setCode(errorInfo.getErrorCode());
        result.setMessage(errorInfo.getErrorMessage());
        return result;
    }

    /**
     * 根据IExceptionInfo 和 数据 构建返回结果
     * @param errorInfo 错误描述
     * @param data      数据
     * @return          RestResult返回结果
     */
    public static <T> RestResult<T> errorWithData(IExceptionInfo errorInfo, T data) {
        RestResult<T> result = new RestResult<>();
        result.setCode(errorInfo.getErrorCode());
        result.setMessage(errorInfo.getErrorMessage());
        result.setData(data);
        return result;
    }

    /**
     * 根据IExceptionInfo 和 自定义的错误信息 构建返回结果
     * @param errorInfo         错误描述
     * @param errorMessage      自定义的错误信息
     * @return                  RestResult返回结果
     */
    public static <T> RestResult<T> errorWithMessage(IExceptionInfo errorInfo, String errorMessage) {
        RestResult<T> result = new RestResult<>();
        result.setCode(errorInfo.getErrorCode());
        result.setMessage(errorMessage);
        return result;
    }

    /**
     * 构建成功的返回结果
     * @param data      返回的数据
     * @return          RestResult返回结果
     */
    public static <T> RestResult<T> success(T data) {
        RestResult<T> result = new RestResult<>();
        result.setCode(RestResult.SUCCESS_CODE);
        result.setData(data);
        return result;
    }

    /**
     * 构建成功的返回结果
     * @param data      返回的数据
     * @param message   消息
     * @return          RestResult返回结果
     */
    public static <T> RestResult<T> success(T data, String message) {
        RestResult<T> result = new RestResult<>();
        result.setCode(RestResult.SUCCESS_CODE);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public RestResult() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RestResult)) return false;
        RestResult<?> that = (RestResult<?>) o;
        return Objects.equals(code, that.code) && Objects.equals(message, that.message) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, data);
    }


}
