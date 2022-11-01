package com.mte.uam.query.account;

import com.mte.uam.data.account.AccountRepository;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

@MicronautTest
class AccountQueriesTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Inject
    AccountRepository accountRepository;

}