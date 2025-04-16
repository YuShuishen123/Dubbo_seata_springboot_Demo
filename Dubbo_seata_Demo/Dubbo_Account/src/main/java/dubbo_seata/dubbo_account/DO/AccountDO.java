package dubbo_seata.dubbo_account.DO;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Yu'S'hui'shen
 * Account表格实体
 */
@Data
@TableName("account_tbl")
public class AccountDO {


    /**
     * Accoun表格自增主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField("user_id")
    private String userId;

    /**
     * 余额
     */
    @TableField("money")
    private int money;


}
