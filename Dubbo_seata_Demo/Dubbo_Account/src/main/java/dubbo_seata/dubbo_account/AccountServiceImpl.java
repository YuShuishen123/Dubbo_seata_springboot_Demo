package dubbo_seata.dubbo_account;

import dubbo_seata.dubbo_account.mapper.AccountMapper;
import dubbo_seata.dubbo_common.AccountInterface.AccountService;
import dubbo_seata.dubbo_common.Exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Yu'S'hui'shen
 */

@DubboService(parameters = {"exceptionToBiz", "true"})
@Slf4j
public class AccountServiceImpl implements AccountService {

    /*引入mapper层更新余额接口*/
    private final AccountMapper accountMapper;
    public AccountServiceImpl(AccountMapper accountMapper){
        this.accountMapper = accountMapper;
    }

    @Transactional
    @Override
    public void debit(String userId, int money) throws CustomException{
        log.info("开始扣减余额");
        /*调用更新余额接口*/
        int result = accountMapper.updateAccount(userId,money);
        log.info("result:{}", result);
        if(result == 0) {
            log.info("扣减余额失败,抛出异常");
            throw  new CustomException("扣减余额失败", 500);
        }
    }
}