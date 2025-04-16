package dubbo_seata.dubbo_common.DTO;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * @author Yu'S'hui'shen
 */
@Data
public class OrderDTO implements Serializable {

    private String orderId;

    private String userId;

    private String commodityCode;

    private Integer count;

    private Integer money;

    @Serial
    private static final long serialVersionUID = 1L;
}