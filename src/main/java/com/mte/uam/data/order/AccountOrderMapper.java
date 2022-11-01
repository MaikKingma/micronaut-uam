package com.mte.uam.data.order;

import com.mte.uam.domain.order.AccountOrder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Maik Kingma
 */

@Mapper
public interface AccountOrderMapper {

    AccountOrderMapper INSTANCE = Mappers.getMapper(AccountOrderMapper.class);

    AccountOrderEntity accountOrderToAccountOrderEntity(AccountOrder accountOrder);
}
