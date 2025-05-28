package dubbo_seata.dubbo_business.appConfigeration;

import dubbo_seata.dubbo_common.Exception.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yu'S'hui'shen
 * @description 配置全局异常处理
 */
@Configuration
public class MapStructConfiguration {
    @Bean
    public GlobalExceptionHandler orderMapStruct() {
        return new GlobalExceptionHandler();
    }
}
