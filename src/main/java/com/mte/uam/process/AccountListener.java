package com.mte.uam.process;

import com.mte.uam.data.account.AccountEntity;
import com.mte.uam.domain.order.AccountOrderService;
import io.micronaut.context.annotation.Factory;
import io.micronaut.data.event.listeners.PostPersistEventListener;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jan Boonen & Maik Kingma
 */
@Slf4j
@Factory
public class AccountListener {

    private final AccountOrderService accountOrderService;

    public AccountListener(AccountOrderService accountOrderService) {
        this.accountOrderService = accountOrderService;
    }

    @Singleton
    PostPersistEventListener<AccountEntity> afterAccountPersist() {
        return (accountEntity) -> {
            var accountOrder = accountOrderService.findById(accountEntity.getUsername());
            if (!accountOrder.isFinalized()) {
                accountOrder.finishOrder();
                accountOrderService.update(accountOrder);
            }
        };
    }
}
