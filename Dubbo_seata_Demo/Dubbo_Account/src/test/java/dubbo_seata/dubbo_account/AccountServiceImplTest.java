package dubbo_seata.dubbo_account;

import dubbo_seata.dubbo_common.AccountInterface.AccountService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceImplIntegrationTest {

    @DubboReference
    private AccountService accountService;

    @Test
    void testDebit_RealDatabase() {
        // 先确保测试数据库中有userId=testUser的记录

    }
}
