package dubbo_seata.dubbo_business.service.Impl;

import dubbo_seata.dubbo_business.service.BusinessService;
import dubbo_seata.dubbo_common.DTO.OrderDTO;
import dubbo_seata.dubbo_common.Exception.CustomException;
import dubbo_seata.dubbo_common.orderInterface.OrderService;
import dubbo_seata.dubbo_common.storageInterface.StorageService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author Yu'S'hui'shen
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    @DubboReference
    StorageService storageService;

    @DubboReference
    OrderService orderService;

    @Override
    public OrderDTO purchase(String userId, String commodityCode, int orderCount) throws CustomException {
        storageService.deduct(commodityCode, orderCount);
        return orderService.create(userId, commodityCode, orderCount);
    }
}
