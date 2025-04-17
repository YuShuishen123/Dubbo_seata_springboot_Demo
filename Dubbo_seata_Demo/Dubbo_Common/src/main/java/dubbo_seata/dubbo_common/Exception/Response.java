package dubbo_seata.dubbo_common.Exception;

import lombok.Data;

/**
 * @author Yu'S'hui'shen
 */
@Data
public class Response<T> {

    // 状态码，例如：200（成功），400（请求错误），500（服务器错误）
    private int code;

    // 提示信息，例如："操作成功" 或 "操作失败"
    private String message;

    // 具体的数据，使用泛型适配不同类型的返回值
    private T data;

    // 私有化构造方法，使用静态工厂方法创建实例
    private Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 快捷方法：成功响应
    public static <T> Response<T> success(T data) {
        return new Response<>(200, "Success", data);
    }

    // 快捷方法：成功响应（自定义消息）
    public static <T> Response<T> success(String message, T data) {
        return new Response<>(200, message, data);
    }

    // 快捷方法：失败响应
    public static <T> Response<T> fail(int code, String message) {
        return new Response<>(code, message, null);
    }

    // 快捷方法：失败响应（附带数据）
    public static <T> Response<T> fail(int code, String message, T data) {
        return new Response<>(code, message, data);
    }

    // 快捷方法：失败响应（自定义消息，无数据）
    public static <T> Response<T> fail(String message) {
        return new Response<>(400, message, null);
    }


    // 重写 toString 方法（方便日志打印）
    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

