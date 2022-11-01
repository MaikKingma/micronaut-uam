package com.mte.uam.process;

import com.mte.uam.data.order.AccountOrderEntity;
import com.mte.uam.data.order.AccountOrderMapper;
import com.mte.uam.domain.account.AccountService;
import io.micronaut.context.annotation.Factory;
import io.micronaut.data.event.listeners.PostPersistEventListener;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Maik Kingma
 */

@Slf4j
@Factory
@AllArgsConstructor
public class AccountOrderListener {

    private AccountService accountService;

    @Singleton
    PostPersistEventListener<AccountOrderEntity> afterAccountOrderPersist() {
        return (accountOrderEntity) -> {
            accountService.create(AccountOrderMapper.INSTANCE.accountOrderEntityToAccountOrder(accountOrderEntity));
            log.info("AccountOrder persisted: {}", accountOrderEntity.getUsername());
        };
    }
}