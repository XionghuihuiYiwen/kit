package cn.xionghuihui.infrastructure.kit.common.exception;

/**
 * 错误信息接口
 *
 * @author huihui.xiong
 * @since 2022-07-06 16:27:28
 */
public interface IExceptionInfo {

    /**
     * 获取错误的编码
     * @return 错误编码
     */
    String getErrorCode();

    /**
     * 获取错误信息
     * @return 错误信息
     */
    String getErrorMessage();
}
