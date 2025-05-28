package dubbo_seata.dubbo_order;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Yu'S'hui'shen
 */
@SpringBootApplication(scanBasePackages = "dubbo_seata")
@EnableDubbo
public class DubboOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboOrderApplication.class, args);
    }

}
