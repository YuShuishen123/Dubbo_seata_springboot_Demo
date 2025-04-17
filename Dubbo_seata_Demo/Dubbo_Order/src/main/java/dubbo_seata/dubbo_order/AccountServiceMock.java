package dubbo_seata.dubbo_order;

import dubbo_seata.dubbo_common.AccountInterface.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Yu'S'hui'shen
 */

public class AccountServiceMock implements AccountService {
    Logger logger = LoggerFactory.getLogger(AccountServiceMock.class);
    @Override
    public void debit(String userId, int money) {
        // 建议添加日志和更安全的返回值
        logger.info("账户服务繁忙，请稍后重试");
    }
}
