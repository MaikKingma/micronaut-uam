package com.mte.uam.domain.account;

import com.mte.uam.data.account.AccountEntity;

import java.util.List;

public interface AccountService {

    void create(Account account);

    List<AccountEntity> findAll();

    AccountEntity findByName(String username);

}
