package dubbo_seata.dubbo_common.Exception;

import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Yu'S'hui'shen
 * 自定义异常类
 */
@Getter
public class CustomException extends RuntimeException implements Serializable {

    private final int errorCode;

    /**
     * 自定义异常方法
     * @param message 错误信息
     * @param errorCode 错误码
     */
    public CustomException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    @Serial
    private static final long serialVersionUID = 1L;
}
