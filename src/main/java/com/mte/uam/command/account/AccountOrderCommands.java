package com.mte.uam.command.account;

import com.mte.uam.domain.order.AccountOrder;
import com.mte.uam.domain.order.AccountOrderService;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;

/**
 * @author Maik Kingma
 */
@Slf4j
@Controller("/accounts")
public class AccountOrderCommands {

    private final AccountOrderService accountOrderService;

    public AccountOrderCommands(AccountOrderService accountOrderService) {
        this.accountOrderService = accountOrderService;
    }

    @ExecuteOn(TaskExecutors.IO)
    @Post(uri = "/register", consumes = MediaType.APPLICATION_JSON)
    @Status(HttpStatus.ACCEPTED)
    public void registerAccount(@Body RegisterAccountDTO registerAccountDTO) {
        log.info("creating account order from DTO");
        AccountOrder accountOrder = AccountOrder.create(registerAccountDTO.firstName, registerAccountDTO.lastName, registerAccountDTO.username);
        accountOrderService.register(accountOrder);
    }

    @Introspected
    @ReflectiveAccess
    record RegisterAccountDTO(@NotBlank String username, @NotBlank String firstName, @NotBlank String lastName) { }
}
