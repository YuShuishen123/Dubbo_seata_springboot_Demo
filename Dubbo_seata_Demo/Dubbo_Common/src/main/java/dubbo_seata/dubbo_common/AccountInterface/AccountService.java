package dubbo_seata.dubbo_common.AccountInterface;


/**
 * @author Yu'S'hui'shen
 */

public interface AccountService {

    /**
     * 从用户账户中扣减
     * @param userId  用户id
     * @param money   扣减金额
     */
    String debit(String userId, int money);
}
