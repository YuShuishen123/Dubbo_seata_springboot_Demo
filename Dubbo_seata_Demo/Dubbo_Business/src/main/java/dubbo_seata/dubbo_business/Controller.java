package dubbo_seata.dubbo_business;

import dubbo_seata.dubbo_business.service.BusinessService;
import dubbo_seata.dubbo_common.DTO.OrderDTO;
import dubbo_seata.dubbo_common.Exception.Response;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yu'S'hui'shen
 */

@RestController
@RequestMapping("/business")
public class Controller {

    final BusinessService businessService;

    public Controller(BusinessService businessService) {
        this.businessService = businessService;
    }

    /**
     * 购买
     *
     * @param userId        用户ID
     * @param commodityCode 商品编码
     * @param orderCount    数量
     */
    @GetMapping("/purchase")
    public Response<OrderDTO> purchase(@RequestParam("userId") String userId,
                                       @RequestParam("commodityCode") String commodityCode,
                                       @RequestParam("count") int orderCount) {
        return Response.success("创建订单成功",businessService.purchase(userId,commodityCode,orderCount));
    }
}
