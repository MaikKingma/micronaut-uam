package com.mte.uam.query.account;

import com.mte.uam.data.account.AccountEntity;
import com.mte.uam.domain.account.AccountService;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
class AccountQueriesTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Inject
    AccountService accountService;

    @MockBean(AccountService.class)
    AccountService accounts() {
        return mock(AccountService.class);
    }

    @Test
    void shouldGetAllAccounts() {
        AccountEntity accountEntity = AccountEntity.builder()
                .firstName("TestFirst")
                .lastName("TestLast")
                .username("Test@test.test")
                .build();

        List<AccountEntity> accountEntities = new ArrayList<>();
        accountEntities.add(accountEntity);

        AccountView expected = new AccountView(
                accountEntity.getFirstName(),
                accountEntity.getLastName(),
                accountEntity.getUsername());

        when(accountService.findAll()).thenReturn(accountEntities);

        var request = HttpRequest.GET("/accounts");
        var response = client.toBlocking().exchange(request, AccountView[].class);
        var body = response.getBody();

        assertEquals(response.getStatus(), HttpStatus.OK);
        assertThat(body.get()).usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(expected);

    }

    @Test
    void shouldGetKeycloakUserByUsername() {
        UUID accountId = UUID.randomUUID();

        AccountEntity accountEntity = AccountEntity.builder()
                .id(accountId)
                .firstName("TestFirst")
                .lastName("TestLast")
                .username("Test@test.test")
                .build();

        KeycloakUserView expected = new KeycloakUserView(
                accountEntity.getId(),
                accountEntity.getFirstName(),
                accountEntity.getLastName(),
                accountEntity.getUsername()
        );

        when(accountService.findByName(accountEntity.getUsername())).thenReturn(accountEntity);

        var request = HttpRequest.GET("/accounts/" + accountEntity.getUsername() + "/keycloak-user");
        var response = client.toBlocking().exchange(request, KeycloakUserView.class);

        assertEquals(response.getStatus(), HttpStatus.OK);
        assertNotNull(response.body());
        assertEquals(expected.accountId(), response.body().accountId());
        assertEquals(expected.firstName(), response.body().firstName());
        assertEquals(expected.lastName(), response.body().lastName());
        assertEquals(expected.username(), response.body().username());
    }

}