package com.mte.uam.process;

import com.mte.uam.data.order.AccountOrderEntity;
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

    @Singleton
    PostPersistEventListener<AccountOrderEntity> afterAccountOrderPersist() { //
        return (accountOrder) -> log.info("order persisted: {}", accountOrder.getUsername() );
    }
}