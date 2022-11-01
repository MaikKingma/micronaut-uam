package com.mte.uam.process;

import com.mte.uam.data.order.AccountOrderEntity;
import com.mte.uam.data.order.AccountOrderRepository;
import com.mte.uam.domain.account.Account;
import com.mte.uam.domain.account.AccountService;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.util.StringUtils;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@MicronautTest
@Requires(property = "mockito.test.enabled", defaultValue = StringUtils.FALSE, value = StringUtils.TRUE)
class AccountOrderListenerTest {

    @Inject
    private AccountService accountService;

    @InjectMocks
    private AccountOrderListener accountOrderListener;

    @Inject
    private AccountOrderRepository accountOrderRepository;

    @Test
    void shouldReturnAccountAfterAccountOrderPersist() {
        var accountOrderEntity = AccountOrderEntity.builder()
                .username("test")
                .firstName("First Name")
                .lastName("Last Name")
                .build();
        accountOrderRepository.save(accountOrderEntity);

        var account = Account.create("First Name", "Last Name", "test");

        verify(accountService).create(account);
    }

    @MockBean(AccountService.class)
    AccountService accountService() {
        return mock(AccountService.class);
    }
}