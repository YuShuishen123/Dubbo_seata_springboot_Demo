package dubbo_seata.dubbo_business.appConfigeration;

import dubbo_seata.dubbo_common.Exception.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yu'S'hui'shen
 */
@Configuration
public class MapStructConfiguration {
    @Bean
    public GlobalExceptionHandler orderMapStruct() {
        return new GlobalExceptionHandler();
    }
}
