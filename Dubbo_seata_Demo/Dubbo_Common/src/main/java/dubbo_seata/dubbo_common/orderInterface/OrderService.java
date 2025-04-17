package dubbo_seata.dubbo_common.orderInterface;


import dubbo_seata.dubbo_common.DTO.OrderDTO;
import dubbo_seata.dubbo_common.Exception.CustomException;

/**
 * @author Yu'S'hui'shen
 */
public interface OrderService {
    /**
     * 创建订单
     * @param userId    用户id
     * @param commodityCode  商品编码
     * @param orderCount  商品数量
     */
    OrderDTO create(String userId, String commodityCode, int orderCount) throws CustomException;
}
