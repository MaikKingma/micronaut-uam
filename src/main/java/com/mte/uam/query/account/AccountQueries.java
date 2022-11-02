package com.mte.uam.query.account;

import com.mte.uam.data.account.AccountEntity;
import com.mte.uam.domain.account.AccountService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;
import java.util.stream.Collectors;

@Controller("/accounts")
public class AccountQueries {

    private final AccountService accountService;

    public AccountQueries(AccountService accountService) {
        this.accountService = accountService;
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public List<AccountView> getAccounts(){

        List<AccountEntity> accountEntities = accountService.findAll();

        return accountEntities.stream().map(
                        ae -> new AccountView(
                                ae.getFirstName(),
                                ae.getLastName(),
                                ae.getUsername()))
                        .collect(Collectors.toList());
    }

}
