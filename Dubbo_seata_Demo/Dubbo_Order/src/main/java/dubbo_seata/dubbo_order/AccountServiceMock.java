package dubbo_seata.dubbo_order;

import dubbo_seata.dubbo_common.AccountInterface.AccountService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Yu'S'hui'shen
 */
@Slf4j
public class AccountServiceMock implements AccountService {
    @Override
    public String debit(String userId, int money) {
        // 建议添加日志和更安全的返回值
        log.info("[WARN] AccountService降级触发，userId={}", userId);
        return "{\"code\":503,\"msg\":\"账户服务繁忙，请稍后重试\"}";
    }
}
