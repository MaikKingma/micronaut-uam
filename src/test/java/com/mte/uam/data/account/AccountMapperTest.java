package com.mte.uam.data.account;

import com.mte.uam.domain.account.Account;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountMapperTest {

    @Test
    void shouldMapAccountToAccountEntity() {
        var account = Account.builder()
                .username("test")
                .firstName("First Name")
                .lastName("Last Name")
                .build();

        var result = AccountMapper.INSTANCE.accountToAccountEntity(account);
        assertThat(result).isEqualTo(AccountEntity.builder()
                .username("test")
                .firstName("First Name")
                .lastName("Last Name")
                .build());
    }

    @Test
    void shouldMapAccountEntityToAccount() {
        var accountEntity = AccountEntity.builder()
                .id(UUID.fromString("0000-00-00-00-000000"))
                .username("test")
                .firstName("First Name")
                .lastName("Last Name")
                .build();

        var result = AccountMapper.INSTANCE.accountEntityToAccount(accountEntity);
        assertThat(result).isEqualTo(Account.builder()
                .accountId("00000000-0000-0000-0000-000000000000")
                .username("test")
                .firstName("First Name")
                .lastName("Last Name")
                .build());
    }

}
