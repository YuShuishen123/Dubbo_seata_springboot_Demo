package dubbo_seata.dubbo_order.util.mapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Yu'S'hui'shen
 */
@Mapper
public class OrderMapStruct {
     static OrderMapStruct INSTANCE = Mappers.getMapper(OrderMapStruct.class);
}
