package dubbo_seata.dubbo_storage.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Yu'S'hui'shen
 * 库存持久化层对象
 */

@Data
@TableName("storage_tbl")
public class StorageDO{
    /**
     * 自增主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 商品代号
     */
    @TableField("commodity_code")
    private String commodityCode;

    /**
     * 库存数量
     */
    @TableField("count")
    private Integer count;
}
