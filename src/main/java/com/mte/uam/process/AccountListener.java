package com.mte.uam.process;

import com.mte.uam.data.account.AccountEntity;
import com.mte.uam.data.order.AccountOrderEntity;
import com.mte.uam.data.order.AccountOrderMapper;
import com.mte.uam.domain.order.AccountOrderService;
import io.micronaut.context.annotation.Factory;
import io.micronaut.data.event.listeners.PostPersistEventListener;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jan Boonen
 */
@Slf4j
@Factory
@AllArgsConstructor
public class AccountListener {

    private AccountOrderService accountOrderService;

    @Singleton
    PostPersistEventListener<AccountEntity> afterAccountPersist() {
        return (account) -> {
            accountOrderService.finalize(account.getUsername());
            log.info("Account finalized: {}", account.getUsername());
        };
    }
}
