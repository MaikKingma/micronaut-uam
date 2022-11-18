package com.mte.uam.data.account;

import com.mte.uam.domain.account.Account;
import com.mte.uam.domain.account.AccountService;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Singleton
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Override
    public void create(Account account) {
        accountRepository.save(AccountMapper.INSTANCE.accountToAccountEntity(account));
    }

    public List<AccountEntity> findAll() {
        return StreamSupport.stream(accountRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public AccountEntity findByName(String username) {
        return accountRepository.findByUsername(username);
    }
}
