package cn.xionghuihui.infrastructure.kit.common.util;

import cn.xionghuihui.infrastructure.kit.common.exception.BizException;
import cn.xionghuihui.infrastructure.kit.common.exception.IExceptionInfo;

/**
 * 异常工具类
 * @author huihui.xiong
 * @since 2022-07-06 17:57:43
 */
public class ExceptionUtil {

    /**
     * 创建异常
     */
    private static BizException createBizException(IExceptionInfo exceptionInfo) {
        return new BizException(exceptionInfo);
    }

    /**
     * 创建异常
     */
    private static BizException createBizException(IExceptionInfo exceptionInfo, String msg) {
        return new BizException(msg, exceptionInfo);
    }

    /**
     * 传入异常信息直接抛出 Biz异常
     * @param exceptionInfo 异常信息描述
     */
    public static void bizError(IExceptionInfo exceptionInfo) {
        throw createBizException(exceptionInfo);
    }

    /**
     * 传入异常信息直接抛出 Biz异常
     * @param exceptionInfo 异常信息描述
     * @param msg           错误信息
     */
    public static void bizError(IExceptionInfo exceptionInfo, String msg) {
        throw createBizException(exceptionInfo, msg);
    }

}
