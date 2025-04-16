package dubbo_seata.dubbo_order.appConfigeration;

import dubbo_seata.dubbo_order.util.mapStruct.OrderMapStruct;
import dubbo_seata.dubbo_order.util.mapStruct.OrderMapStructImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yu'S'hui'shen
 */
@Configuration
public class MapStructConfiguration {
    @Bean
    public OrderMapStruct orderMapStruct() {
        return new OrderMapStructImpl();
    }
}
