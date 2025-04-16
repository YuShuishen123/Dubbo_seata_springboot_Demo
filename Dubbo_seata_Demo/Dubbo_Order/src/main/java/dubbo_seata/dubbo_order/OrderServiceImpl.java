package dubbo_seata.dubbo_order;


import dubbo_seata.dubbo_common.AccountInterface.AccountService;
import dubbo_seata.dubbo_common.DTO.OrderDTO;
import dubbo_seata.dubbo_common.Exception.CustomException;
import dubbo_seata.dubbo_common.orderInterface.OrderService;
import dubbo_seata.dubbo_order.DO.OrderDO;
import dubbo_seata.dubbo_order.mapper.OrderMapper;
import dubbo_seata.dubbo_order.util.mapStruct.OrderMapStruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Yu'S'hui'shen
 */
@DubboService
@Slf4j
public class OrderServiceImpl implements OrderService {

    /*引入订单mapper接口*/
    OrderMapper orderMapper;

    OrderMapStruct orderMapStruct;



    @DubboReference(
            loadbalance = "roundrobin",
            // 建议增加这些配置：
            timeout = 3000,  // 超时时间(ms)
            retries = 0,     // 禁用重试（与failfast配合）
            mock = "fail:dubbo_seata.dubbo_order.AccountServiceMock"
    )
    AccountService accountService;


    public OrderServiceImpl(OrderMapStruct orderMapStruct, AccountService accountService, OrderMapper orderMapper) {
        this.orderMapStruct = orderMapStruct;
        this.accountService = accountService;
        this.orderMapper = orderMapper;
    }

    @Override
    @Transactional
    public OrderDTO create(String userId, String commodityCode, int orderCount) throws CustomException{

        /*计算总价*/
        int orderMoney = orderCount * 10;

        /*扣减账户余额*/
        log.info(accountService.debit(userId,orderMoney));

        /*生成订单内容*/
        OrderDO orderDO = new OrderDO();
        long timestamp = System.currentTimeMillis();
        orderDO.setOrderId(String.valueOf(timestamp % 1000000000) +
                ThreadLocalRandom.current().nextInt(0, 10));
        orderDO.setUserId(userId);
        orderDO.setCommodityCode(commodityCode);
        orderDO.setCount(orderCount);
        orderDO.setMoney(orderMoney);
        /*持久化存储订单*/
        if(orderMapper.createOrder(orderDO) == 0){
            throw new CustomException("订单插入失败","500");
        }
        OrderDTO orderDTO =  orderMapStruct.toOrderDTO(orderDO);
        log.info("orderDO = {}", orderDO);
        log.info("orderDTO = {}", orderDTO);
        /*返回订单*/
        return orderDTO;
    }
}
