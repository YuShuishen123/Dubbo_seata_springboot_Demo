package dubbo_seata.dubbo_common.Exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Yu'S'hui'shen
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ConstraintViolationException.class)
    public Response<String> handleConstraintViolationException(ConstraintViolationException ex) {
        logger.warn("ConstraintViolationException: {}", ex.getMessage());

        String errorMessage = ex.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("; "));

        return Response.fail(400, errorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        logger.warn("参数校验失败: {}", ex.getMessage());

        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return Response.fail(400, "参数校验失败", errors);
    }

    @ExceptionHandler(BindException.class)
    public Response<Map<String, String>> handleBindException(BindException ex) {
        logger.warn("参数绑定失败: {}", ex.getMessage());

        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return Response.fail(400, "参数绑定失败", errors);
    }

    @ExceptionHandler(CustomException.class)
    public Response<Void> handleCustomException(CustomException ex) {
        logger.warn("自定义异常: message={}, errorCode={}", ex.getMessage(), ex.getErrorCode());
        try {
            return Response.fail(ex.getErrorCode(), ex.getMessage());
        } catch (NumberFormatException e) {
            return Response.fail(400, ex.getMessage());
        }
    }

    @ExceptionHandler(NullPointerException.class)
    public Response<Void> handleNullPointerException(NullPointerException ex) {
        logger.warn("请求中缺少必要的参数: {}", ex.getMessage());
        return Response.fail(400, "请求中缺少必要的参数");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Response<Void> handleIllegalArgumentException(IllegalArgumentException ex) {
        logger.warn("非法参数: {}", ex.getMessage());
        return Response.fail(400, "非法参数");
    }

    @ExceptionHandler({DataAccessException.class, SQLException.class})
    public Response<Void> handleDatabaseException(Exception ex) {
        logger.warn("数据库操作异常: {}", ex.getMessage());
        return Response.fail(500, "数据库操作异常，请稍后重试");
    }

    @ExceptionHandler(Exception.class)
    public Response<Void> handleGeneralException(Exception ex) {
        logger.warn("服务器发生错误: {}", ex.getMessage());

        Throwable rootCause = getRootCause(ex);

        if (rootCause instanceof CustomException customEx) {
            logger.warn("嵌套捕获自定义异常: message={}, errorCode={}", customEx.getMessage(), customEx.getErrorCode());
            return Response.fail(customEx.getErrorCode(), customEx.getMessage());
        }
        return Response.fail(500, "服务器发生错误，请稍后再试");
    }

    private Throwable getRootCause(Throwable throwable) {
        Throwable cause = throwable.getCause();
        if (cause == null || cause == throwable) {
            return throwable;
        }
        return getRootCause(cause);
    }
}
