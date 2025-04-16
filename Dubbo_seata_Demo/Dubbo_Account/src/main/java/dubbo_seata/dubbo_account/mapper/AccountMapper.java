package dubbo_seata.dubbo_account.mapper;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dubbo_seata.dubbo_account.DO.AccountDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Yu'S'hui'shen
 * 余额数据持久化层
 */
@Mapper
public interface AccountMapper extends BaseMapper<AccountDO> {

    /**
     * 扣减用户余额
     * @param userId 用户id
     * @param money 扣减金额
     * @return 更改行数
     */
    default int updateAccount(String userId, int money) {
        UpdateWrapper<AccountDO> wrapper = new UpdateWrapper<>();
        wrapper.eq("user_id", userId)
                // 关键在这里！使用SQL表达式实现减法
                .setSql("money = money - " + money);

        // 这里不需要updateObj了，因为setSql已经包含了更新逻辑
        return update(null, wrapper);
    }
}
