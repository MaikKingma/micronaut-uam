package com.mte.uam.command.account;

import com.mte.uam.data.order.AccountOrderServiceImpl;
import com.mte.uam.domain.order.AccountOrder;
import com.mte.uam.domain.order.AccountOrderService;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.util.StringUtils;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@MicronautTest(transactional = false)
@Requires(property = "mockito.test.enabled", defaultValue = StringUtils.FALSE, value = StringUtils.TRUE)
class AccountCommandsTest {

    @Inject
    AccountOrderService accountOrderService;

    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    void shouldRegisterAccount() {
        AccountOrder accountOrder =
                AccountOrder.builder().username("username").firstName("first").lastName("last").build();

        HttpResponse<Object> response = httpClient.toBlocking().exchange(HttpRequest.POST("/accounts/register",
                new AccountCommands.RegisterAccountDTO(
                "username", "first", "last")));

        assertEquals(response.getStatus(), HttpStatus.ACCEPTED);
        verify(accountOrderService, times(1)).register(any(AccountOrder.class));

    }

    @MockBean(AccountOrderServiceImpl.class)
    AccountOrderService mathService() {
        return mock(AccountOrderService.class);
    }
}