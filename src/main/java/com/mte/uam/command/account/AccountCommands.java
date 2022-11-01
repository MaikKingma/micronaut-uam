package com.mte.uam.command.account;

import com.mte.uam.domain.order.AccountOrder;
import com.mte.uam.domain.order.AccountOrderService;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Status;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Maik Kingma
 */
@Slf4j
@Controller("/accounts")
public class AccountCommands {

    private final AccountOrderService accountOrderService;

    public AccountCommands(AccountOrderService accountOrderService) {
        this.accountOrderService = accountOrderService;
    }

    @Post(uri = "/register", consumes = MediaType.APPLICATION_JSON)
    @Status(HttpStatus.ACCEPTED)
    public void registerAccount(@Body RegisterAccountDTO registerAccountDTO) {
        log.info("creating account order from DTO");
        AccountOrder accountOrder = AccountOrder.create(registerAccountDTO.firstName, registerAccountDTO.lastName, registerAccountDTO.username);
        accountOrderService.register(accountOrder);
    }

    record RegisterAccountDTO(String username, String firstName, String lastName) { }
}
