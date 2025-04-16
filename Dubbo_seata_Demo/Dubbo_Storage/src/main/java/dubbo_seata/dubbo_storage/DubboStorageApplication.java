package dubbo_seata.dubbo_storage;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Yu'S'hui'shen
 */
@SpringBootApplication
@EnableDubbo
public class DubboStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboStorageApplication.class, args);
    }

}
