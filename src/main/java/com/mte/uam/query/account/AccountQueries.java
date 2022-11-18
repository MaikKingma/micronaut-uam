package com.mte.uam.query.account;

import com.mte.uam.domain.account.AccountService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller("/accounts")
public class AccountQueries {

    private final AccountService accountService;

    public AccountQueries(AccountService accountService) {
        this.accountService = accountService;
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public List<AccountView> getAccounts(){
        return accountService.findAll().stream()
                .map(ae -> new AccountView(ae.getFirstName(), ae.getLastName(), ae.getUsername()))
                .collect(Collectors.toList());
    }

    @Get(uri = "/{username}/keycloak-user", produces = MediaType.APPLICATION_JSON)
    public KeycloakUserView getAccount(String username) {
        var account = accountService.findByName(username);
        return new KeycloakUserView(account.getId(), account.getFirstName(), account.getLastName(), account.getUsername());
    }

    record AccountView(String firstName, String lastName, String username) {}

    record KeycloakUserView(UUID accountId, String firstName, String lastName, String username) {}
}
