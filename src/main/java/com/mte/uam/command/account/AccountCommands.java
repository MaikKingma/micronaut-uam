package com.mte.uam.command.account;

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

    @Post(uri = "/register", consumes = MediaType.APPLICATION_JSON)
    @Status(HttpStatus.ACCEPTED)
    public void registerAccount(@Body RegisterAccountDTO registerAccountDTO) {
        log.info(registerAccountDTO.toString());
    }

    record RegisterAccountDTO(String username, String firstName, String lastName) { }
}
