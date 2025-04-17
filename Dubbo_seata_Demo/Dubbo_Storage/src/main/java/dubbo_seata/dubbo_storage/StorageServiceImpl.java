package dubbo_seata.dubbo_storage;


import dubbo_seata.dubbo_common.Exception.CustomException;
import dubbo_seata.dubbo_common.storageInterface.StorageService;
import dubbo_seata.dubbo_storage.Mapper.StorageMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Yu'S'hui'shen
 */
@DubboService
public class StorageServiceImpl implements StorageService {
    private static final Logger log = LoggerFactory.getLogger(StorageServiceImpl.class);
    /**
     * 注入持久化层接口
     */
    StorageMapper storageMapper;

    public StorageServiceImpl(StorageMapper storageMapper) {
        this.storageMapper = storageMapper;
    }

    @Override
    public void deduct(String commodityCode, int count) throws CustomException {
        log.info("开始扣减库存:{}数量:{}", commodityCode, count);
        int result = storageMapper.deduct(commodityCode, count);
        log.info("UPDATE返回值: {}", result);
        log.info("除零异常发生前,库存扣减发生后,该商品库存:{}",storageMapper.selectByCommodityCode(commodityCode));
        /*抛出异常测试回滚*/
//        throw new CustomException("测试错误",400);

        if (result == 0) {
            log.info("抛出异常");
            throw new CustomException("库存错误", 500);
        }
    }
}
