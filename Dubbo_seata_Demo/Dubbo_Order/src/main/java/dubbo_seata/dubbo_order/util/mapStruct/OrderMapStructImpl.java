package dubbo_seata.dubbo_order.util.mapStruct;

import dubbo_seata.dubbo_common.DTO.OrderDTO;
import dubbo_seata.dubbo_order.DO.OrderDO;

/**
 * @author Yu'S'hui'shen
 */
public class OrderMapStructImpl implements OrderMapStruct {

    @Override
    public OrderDO toOrderDO(OrderDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }

        OrderDO orderDO = new OrderDO();
        // 映射字段
        orderDO.setOrderId(orderDTO.getOrderId());
        orderDO.setUserId(orderDTO.getUserId());
        orderDO.setCommodityCode(orderDTO.getCommodityCode());
        orderDO.setCount(orderDTO.getCount());
        orderDO.setMoney(orderDTO.getMoney());
        // id 字段由数据库自增生成，无需映射

        return orderDO;
    }

    @Override
    public OrderDTO toOrderDTO(OrderDO orderDO) {
        if (orderDO == null) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();
        // 映射字段
        orderDTO.setOrderId(orderDO.getOrderId());
        orderDTO.setUserId(orderDO.getUserId());
        orderDTO.setCommodityCode(orderDO.getCommodityCode());
        orderDTO.setCount(orderDO.getCount());
        orderDTO.setMoney(orderDO.getMoney());

        return orderDTO;
    }
}