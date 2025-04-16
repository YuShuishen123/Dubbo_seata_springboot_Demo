package dubbo_seata.dubbo_order;


import dubbo_seata.dubbo_common.AccountInterface.AccountService;
import dubbo_seata.dubbo_common.DTO.OrderDTO;
import dubbo_seata.dubbo_common.orderInterface.OrderService;
import dubbo_seata.dubbo_order.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Yu'S'hui'shen
 */
@DubboService
@Slf4j
public class OrderServiceImpl implements OrderService {

    OrderMapper orderMapper;

    @DubboReference(
            loadbalance = "roundrobin",
            // 建议增加这些配置：
            timeout = 3000,  // 超时时间(ms)
            retries = 0,     // 禁用重试（与failfast配合）
            mock = "fail:dubbo_seata.dubbo_order.AccountServiceMock"
    )
    AccountService accountService;
    @Override
    @Transactional
    public OrderDTO create(String userId, String commodityCode, int orderCount) {
        /*计算总价*/
        int orderMoney = orderCount * 10;

        /*扣减账户余额*/
        log.info(accountService.debit(userId,orderMoney));

        /*保存订单,待定*/
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(5);
        orderDTO.setUserId(userId);
        orderDTO.setCommodityCode(commodityCode);
        orderDTO.setCount(orderCount);
        orderDTO.setMoney(orderMoney);

        /*创建订单*/
        orderMapper.createOrder(orderDTO);


        return orderDTO;

    }
}
