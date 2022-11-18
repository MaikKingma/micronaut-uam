package com.mte.uam.process;

import com.mte.uam.data.account.AccountRepository;
import com.mte.uam.domain.order.AccountOrderService;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.util.StringUtils;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.mockito.InjectMocks;

import static org.mockito.Mockito.mock;

@MicronautTest(transactional = false)
@Requires(property = "mockito.test.enabled", defaultValue = StringUtils.FALSE, value = StringUtils.TRUE)
class AccountListenerTest {

    @Inject
    private AccountOrderService accountOrderService;

    @InjectMocks
    private AccountListener accountListener;

    @Inject
    private AccountRepository accountRepository;

    @MockBean(AccountOrderService.class)
    AccountOrderService accountOrderService() {
        return mock(AccountOrderService.class);
    }

}