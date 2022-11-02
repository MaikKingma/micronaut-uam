package com.mte.uam.process;

import com.mte.uam.data.order.AccountOrderEntity;
import com.mte.uam.data.order.AccountOrderMapper;
import com.mte.uam.domain.account.AccountService;
import io.micronaut.context.annotation.Factory;
import io.micronaut.data.event.listeners.PostPersistEventListener;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Maik Kingma
 */

@Slf4j
@Factory
public class AccountOrderListener {

    private final AccountService accountService;

    public AccountOrderListener(AccountService accountService) {
        this.accountService = accountService;
    }

    @Singleton
    PostPersistEventListener<AccountOrderEntity> afterAccountOrderPersist() {
        return (accountOrderEntity) -> {
            if (!accountOrderEntity.isFinalized()) {
                log.info("AccountOrder persisted: {}", accountOrderEntity.getUsername());
                var accountOrder = AccountOrderMapper.INSTANCE.accountOrderEntityToAccountOrder(accountOrderEntity);
                var account = accountOrder.convertToAccount();
                accountService.create(account);
            }
        };
    }
}