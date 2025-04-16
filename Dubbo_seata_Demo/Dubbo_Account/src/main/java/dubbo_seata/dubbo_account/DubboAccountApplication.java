package dubbo_seata.dubbo_account;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author Yu'S'hui'shen
 */
@EnableDubbo
@MapperScan("dubbo_seata.dubbo_account.mapper")
@SpringBootApplication
public class DubboAccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboAccountApplication.class, args);
    }

}
