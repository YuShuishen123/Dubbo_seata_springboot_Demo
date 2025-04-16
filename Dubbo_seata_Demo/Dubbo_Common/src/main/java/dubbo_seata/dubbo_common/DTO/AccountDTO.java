package dubbo_seata.dubbo_common.DTO;

import lombok.Data;

import java.io.Serializable;


/**
 * @author Yu'S'hui'shen
 */
@Data
public class AccountDTO implements Serializable {

    private Integer id;

    private String userId;

    private Integer money;
}