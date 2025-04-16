package dubbo_seata.dubbo_account.utils.MapStruct;

import dubbo_seata.dubbo_account.DO.AccountDO;
import dubbo_seata.dubbo_common.DTO.AccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Yu'S'hui'shen
 */
@Mapper
public interface AccountDomainMapper {
    AccountDomainMapper INSTANCE = Mappers.getMapper(AccountDomainMapper.class);

    AccountDO toAccountDO(AccountDTO accountDTO);

    AccountDTO toAccountDO(AccountDO accountDO);
}
