package dubbo_seata.dubbo_common.AccountInterface;

import dubbo_seata.dubbo_common.Exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Yu'S'hui'shen
 */
@Component
@Slf4j
public class AccountServiceMock implements AccountService {
    @Override
    public void debit(String userId, int money) {
        // 建议添加日志和更安全的返回值
        log.info("账户服务繁忙，请稍后重试");
        throw new CustomException("账户服务繁忙，请稍后重试", 500);
    }
}
