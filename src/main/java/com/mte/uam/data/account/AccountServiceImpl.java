package com.mte.uam.data.account;

import com.mte.uam.domain.account.Account;
import com.mte.uam.domain.account.AccountService;
import com.mte.uam.domain.order.AccountOrder;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

@Singleton
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Override
    public Account create(AccountOrder accountOrder) {
        return AccountMapper.INSTANCE.accountEntityToAccount(
                accountRepository.save(AccountMapper.INSTANCE.accountOrderToAccountEntity(accountOrder)));
    }
}
