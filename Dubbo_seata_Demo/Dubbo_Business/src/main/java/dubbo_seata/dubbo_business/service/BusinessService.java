package dubbo_seata.dubbo_business.service;


import dubbo_seata.dubbo_common.DTO.OrderDTO;

/**
 * @author Yu'S'hui'shen
 */


public interface BusinessService {

    /**
     * 采购
     * @param userId            用户id
     * @param commodityCode     商品编号
     * @param orderCount        购买数量
     */
    OrderDTO purchase(String userId, String commodityCode, int orderCount);
}