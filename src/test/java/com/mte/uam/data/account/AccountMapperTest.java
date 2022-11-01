package com.mte.uam.data.account;

import com.mte.uam.domain.account.Account;
import com.mte.uam.domain.order.AccountOrder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountMapperTest {

    @Test
    void shouldMapAccountOrderToAccountEntity() {
        var accountOrder = AccountOrder.builder()
                .username("test")
                .firstName("First Name")
                .lastName("Last Name")
                .build();

        var result = AccountMapper.INSTANCE.accountOrderToAccountEntity(accountOrder);
        assertThat(result).isEqualTo(AccountEntity.builder().username("test")
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
