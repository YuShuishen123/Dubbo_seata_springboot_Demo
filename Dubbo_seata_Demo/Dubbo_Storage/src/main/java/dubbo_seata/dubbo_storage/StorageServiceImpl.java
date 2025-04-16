package dubbo_seata.dubbo_storage;


import dubbo_seata.dubbo_common.storageInterface.StorageService;
import org.apache.dubbo.config.annotation.DubboService;

import static java.lang.System.*;

/**
 * @author Yu'S'hui'shen
 */
@DubboService
public class StorageServiceImpl implements StorageService {

    private int test;
    @Override
    public void deduct(String commodityCode, int count) {
        test++;
    }
}
