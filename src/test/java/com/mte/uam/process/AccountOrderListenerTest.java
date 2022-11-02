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
import org.mockito.ArgumentCaptor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@MicronautTest
@Requires(property = "mockito.test.enabled", defaultValue = StringUtils.FALSE, value = StringUtils.TRUE)
class AccountOrderListenerTest {

    @Inject
    private AccountService accountService;

    @Inject
    private AccountOrderRepository accountOrderRepository;

    @Test
    void shouldReturnAccountAfterAccountOrderPersist() {
        var accountArgumentCaptor = ArgumentCaptor.forClass(Account.class);
        var accountOrderEntity = AccountOrderEntity.builder()
                .username("test")
                .firstName("First Name")
                .lastName("Last Name")
                .build();
        accountOrderRepository.save(accountOrderEntity);

        verify(accountService).create(accountArgumentCaptor.capture());
        var result = accountArgumentCaptor.getValue();
        assertThat(result.getUsername()).isEqualTo("test");
        assertThat(result.getFirstName()).isEqualTo("First Name");
        assertThat(result.getLastName()).isEqualTo("Last Name");
    }

    @MockBean(AccountService.class)
    AccountService accountService() {
        return mock(AccountService.class);
    }
}