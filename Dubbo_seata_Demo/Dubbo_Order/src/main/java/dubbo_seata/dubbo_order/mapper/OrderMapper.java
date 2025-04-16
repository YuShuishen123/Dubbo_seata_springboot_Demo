package dubbo_seata.dubbo_order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dubbo_seata.dubbo_order.DO.OrderDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Yu'S'hui'shen
 * @version 1.0
 * 订单持久化接口
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderDO> {

    /**
     * 创建订单
     *
     * @param orderDO 订单对象
     * @return 创建订单结果
     */
    default int createOrder(@Param("orderDO") OrderDO orderDO) {
        return insert(orderDO);
    }

}
