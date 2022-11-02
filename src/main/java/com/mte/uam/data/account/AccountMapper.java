package com.mte.uam.data.account;

import com.mte.uam.domain.account.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mapping(target = "id", source = "accountId")
    AccountEntity accountToAccountEntity(Account account);

    @Mapping(target = "accountId", source = "id")
    Account accountEntityToAccount(AccountEntity accountEntity);

}
