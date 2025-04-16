package dubbo_seata.dubbo_business;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Yu'S'hui'shen
 */
@EnableDubbo
@SpringBootApplication
public class DubboBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboBusinessApplication.class, args);

    }

}
