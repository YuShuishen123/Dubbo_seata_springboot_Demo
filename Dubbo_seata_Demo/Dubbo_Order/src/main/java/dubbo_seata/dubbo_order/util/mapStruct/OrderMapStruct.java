package dubbo_seata.dubbo_order.util.mapStruct;

import dubbo_seata.dubbo_common.DTO.OrderDTO;
import dubbo_seata.dubbo_order.DO.OrderDO;

/**
 * @author Yu'S'hui'shen
 */
public interface OrderMapStruct {

     /**
      * 运输层对象转换为数据层对象
      * @param orderDTO 运输层对象
      * @return 数据层对象
      */

     OrderDO toOrderDO(OrderDTO orderDTO);

     /**
      * 数据层对象转换为运输层对象
      * @param orderDO 数据层对象
      * @return 运输层对象
      */

     OrderDTO toOrderDTO(OrderDO orderDO);
}
