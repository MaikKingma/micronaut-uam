package com.mte.uam.data.account;

import com.mte.uam.domain.account.Account;
import com.mte.uam.domain.order.AccountOrder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountEntity accountOrderToAccountEntity(AccountOrder account);

    Account accountEntityToAccount(AccountEntity accountEntity);

}
