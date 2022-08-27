package cn.xionghuihui.infrastructure.kit.common.util;

import cn.xionghuihui.infrastructure.kit.common.exception.SystemExceptionInfo;

import java.text.MessageFormat;
import java.util.Objects;

/**
 * 校验工具类
 *
 * @author huihui.xiong
 * @since 2022-07-20 17:53:59
 */
public class ValidateUtil {

    /**
     * 校验真
     * @param condition 判断值
     * @param message   消息模版
     * @param params    消息模版参数
     */
    public static void isTrue(boolean condition, String message, Object... params) {
        if (!condition) {
            ExceptionUtil.bizError(SystemExceptionInfo.VALIDATE_ERROR, doFormat(message, params));
        }
    }

    /**
     * 校验非空
     * @param obj       判断对象
     * @param message   消息模版
     * @param params    消息模版参数
     */
    public static void notNull(Object obj, String message, Object... params) {
        if (Objects.isNull(obj)) {
            ExceptionUtil.bizError(SystemExceptionInfo.VALIDATE_ERROR, doFormat(message, params));
        }
    }

    /**
     * 将错误编号对应的消息使用 params 进行格式化。
     *
     * @param message           消息模版
     * @param params            参数
     * @return 格式化后的提示
     */
    private static String doFormat(String message, Object... params) {
        if (params == null || params.length <=0) {
            return message;
        }
        return new MessageFormat(message).format(params);
    }
}
