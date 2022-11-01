package com.mte.uam.data.account;

import com.mte.uam.domain.account.Account;
import com.mte.uam.domain.account.AccountService;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

@Singleton
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Override
    public void create(Account account) {
        accountRepository.save(AccountMapper.INSTANCE.accountToAccountEntity(account));
    }
}
