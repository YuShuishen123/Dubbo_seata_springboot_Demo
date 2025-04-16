package dubbo_seata.dubbo_common.storageInterface;


import dubbo_seata.dubbo_common.Exception.CustomException;

/**
 * @author Yu'S'hui'shen
 */
public interface StorageService {

    /**
     * 扣除存储数量
     * @param commodityCode 商品编码
     * @param count 数量
     */
    void deduct(String commodityCode, int count) throws CustomException;
}
