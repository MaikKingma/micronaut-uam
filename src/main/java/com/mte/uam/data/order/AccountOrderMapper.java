package com.mte.uam.data.order;

import com.mte.uam.domain.order.AccountOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Maik Kingma
 */

@Mapper
public interface AccountOrderMapper {

    AccountOrderMapper INSTANCE = Mappers.getMapper(AccountOrderMapper.class);

    @Mapping(target = "finalized", ignore = true)
    AccountOrderEntity accountOrderToAccountOrderEntity(AccountOrder accountOrder);

    AccountOrder accountOrderEntityToAccountOrder(AccountOrderEntity accountOrderEntity);

}
