package dubbo_seata.dubbo_storage.Mapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dubbo_seata.dubbo_storage.DO.StorageDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Yu'S'hui'shen
 * 库存数据持久化层
 */
@Mapper
public interface StorageMapper extends BaseMapper<StorageDO> {

    /**
     * 更新库存
     *
     * @param commodityCode 商品编码
     * @param count         库存数量
     */
    default int deduct(@Param("commodityCode") String commodityCode, @Param("count") int count) {
        UpdateWrapper<StorageDO> wrapper = new UpdateWrapper<>();
        wrapper.eq("commodity_code", commodityCode)
                // 关键在这里！使用SQL表达式实现减法
                .setSql("count = count - " + count);
        return update(null, wrapper);
    }

    /**
     * 根据商品编码查询库存
     *
     * @param commodityCode 商品编码
     * @return 库存
     */
    default StorageDO selectByCommodityCode(@Param("commodityCode") String commodityCode) {
        return selectOne(new UpdateWrapper<StorageDO>().eq("commodity_code", commodityCode));
    }

}
