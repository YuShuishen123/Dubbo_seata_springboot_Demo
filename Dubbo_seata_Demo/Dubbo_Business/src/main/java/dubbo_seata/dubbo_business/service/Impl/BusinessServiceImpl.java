package dubbo_seata.dubbo_business.service.Impl;

import dubbo_seata.dubbo_business.service.BusinessService;
import dubbo_seata.dubbo_common.AccountInterface.AccountService;
import dubbo_seata.dubbo_common.DTO.OrderDTO;
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

    @DubboReference
    AccountService accountService;

    @Override
    public OrderDTO purchase(String userId, String commodityCode, int orderCount) {
        /*调用库存扣减服务*/
        storageService.deduct(commodityCode,orderCount);
        /*调用订单服务创建订单*/
        return orderService.create(userId,commodityCode,orderCount);
    }
}
