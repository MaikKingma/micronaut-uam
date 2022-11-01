package com.mte.uam.data.account;

import com.mte.uam.domain.account.Account;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountMapperTest {

    @Test
    void shouldMapAccountToAccountEntity() {
        var accountOrder = Account.builder()
                .username("test")
                .firstName("First Name")
                .lastName("Last Name")
                .build();

        var result = AccountMapper.INSTANCE.accountToAccountEntity(accountOrder);
        assertThat(result).isEqualTo(AccountEntity.builder()
                .username("test")
                .firstName("First Name")
                .lastName("Last Name")
                .build());
    }

    @Test
    void shouldMapAccountEntityToAccount() {
        var accountEntity = AccountEntity.builder()
                .username("test")
                .firstName("First Name")
                .lastName("Last Name")
                .build();

        var result = AccountMapper.INSTANCE.accountEntityToAccount(accountEntity);
        assertThat(result).isEqualTo(Account.builder().username("test")
                .firstName("First Name")
                .lastName("Last Name")
                .build());
    }

}
