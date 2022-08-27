package cn.xionghuihui.infrastructure.spring.web.core.handler;

import cn.xionghuihui.infrastructure.kit.common.exception.SystemExceptionInfo;
import cn.xionghuihui.infrastructure.kit.common.vo.RestResult;
import org.apache.ibatis.exceptions.PersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Mybatis相关的异常处理
 *
 * @author huihui.xiong
 * @since 2022-07-07 19:06:11
 */
@RestControllerAdvice
public class MybatisExceptionHandler {
    
    /**
     * 日志输出
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisExceptionHandler.class);

    /**
     * PersistenceException 异常
     */
    @ExceptionHandler({PersistenceException.class})
    public RestResult<?> handleDataAccessException(PersistenceException exception) {
        LOGGER.error("访问数据库异常", exception);
        return RestResult.error(SystemExceptionInfo.DATA_ACCESS_ERROR);
    }

}
