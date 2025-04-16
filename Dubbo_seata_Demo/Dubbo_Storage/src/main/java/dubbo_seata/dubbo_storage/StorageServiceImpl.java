package dubbo_seata.dubbo_storage;


import dubbo_seata.dubbo_common.Exception.CustomException;
import dubbo_seata.dubbo_common.storageInterface.StorageService;
import dubbo_seata.dubbo_storage.Mapper.StorageMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Yu'S'hui'shen
 */
@DubboService
public class StorageServiceImpl implements StorageService {

    /**
     * 注入持久化层接口
     */
    StorageMapper storageMapper;

    @Override
    @Transactional
    public void deduct(String commodityCode, int count) throws CustomException {
        if(storageMapper.deduct(commodityCode,count) == 0) {
            throw  new CustomException("库存修改失败", "500");
        }
    }
}
