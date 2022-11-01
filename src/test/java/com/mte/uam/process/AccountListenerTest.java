package com.mte.uam.process;

import com.mte.uam.data.account.AccountEntity;
import com.mte.uam.data.account.AccountRepository;
import com.mte.uam.data.order.AccountOrderEntity;
import com.mte.uam.domain.account.Account;
import com.mte.uam.domain.order.AccountOrder;
import com.mte.uam.domain.order.AccountOrderService;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.util.StringUtils;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@MicronautTest
@Requires(property = "mockito.test.enabled", defaultValue = StringUtils.FALSE, value = StringUtils.TRUE)
class AccountListenerTest {

    @Inject
    private AccountOrderService accountOrderService;

    @InjectMocks
    private AccountListener accountListener;

    @Inject
    private AccountRepository accountRepository;

    @Test
    void shouldReturnAccountAfterAccountPersist() {
        var accountEntity = AccountEntity.builder()
                .username("test")
                .firstName("First Name")
                .lastName("Last Name")
                .build();
        accountRepository.save(accountEntity);

        verify(accountOrderService).finalize("test");
    }

    @MockBean(AccountOrderService.class)
    AccountOrderService accountOrderService() {
        return mock(AccountOrderService.class);
    }

}