package com.mte.uam.data.account;

import com.mte.uam.domain.account.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountEntity accountToAccountEntity(Account account);

    Account accountEntityToAccount(AccountEntity accountEntity);

}
