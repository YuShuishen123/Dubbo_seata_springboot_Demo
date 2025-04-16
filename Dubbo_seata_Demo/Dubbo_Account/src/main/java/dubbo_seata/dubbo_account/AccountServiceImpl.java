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

@DubboService
@Slf4j
public class AccountServiceImpl implements AccountService {

    /*引入mapper层更新余额接口*/
    private final AccountMapper accountMapper;
    public AccountServiceImpl(AccountMapper accountMapper){
        this.accountMapper = accountMapper;
    }

    @Transactional
    @Override
    public String debit(String userId, int money) throws CustomException{
        /*调用更新余额接口*/
        if(accountMapper.updateAccount(userId,money) == 0) {
            throw  new CustomException("扣减余额失败", "500");
        }
        return "扣减余额成功";
    }
}