package dubbo_seata.dubbo_common.Exception;

import lombok.Getter;

/**
 * @author Yu'S'hui'shen
 * 自定义异常类
 */
@Getter
public class CustomException extends RuntimeException {

    private final  String errorCode;

    /**
     * 自定义异常方法
     * @param message 错误信息
     * @param errorCode 错误码
     */
    public CustomException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
