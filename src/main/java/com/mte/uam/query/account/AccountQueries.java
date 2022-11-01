package com.mte.uam.query.account;

import com.mte.uam.domain.account.AccountService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/accounts")
public class AccountQueries {

    private final AccountService accountService;

    public AccountQueries(AccountService accountService) {
        this.accountService = accountService;
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public HttpResponse<?> getAccounts() {
        return HttpResponse.status(HttpStatus.OK).body(accountService.findAll());
    }

}
