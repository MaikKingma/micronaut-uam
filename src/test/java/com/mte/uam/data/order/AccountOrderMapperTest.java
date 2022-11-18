package com.mte.uam.data.order;

import com.mte.uam.domain.order.AccountOrder;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest(transactional = false)
class AccountOrderMapperTest {

    @Test
    void shouldMapAccountOrderToAccountOrderEntity() {
        AccountOrder accountOrder = AccountOrder.builder()
                .username("TestUsername")
                .lastName("TestLastname")
                .firstName("TestFirstname")
                .build();

        AccountOrderEntity accountOrderEntity = AccountOrderMapper.INSTANCE.accountOrderToAccountOrderEntity(accountOrder);

        assertNotNull(accountOrderEntity);
        assertEquals(accountOrderEntity.getFirstName(), accountOrder.getFirstName());
        assertEquals(accountOrderEntity.getLastName(), accountOrder.getLastName());
        assertEquals(accountOrderEntity.getUsername(), accountOrder.getUsername());

    }

    @Test
    void shouldMapAccountOrderEntityToAccountOrder() {
        AccountOrderEntity accountOrderEntity = AccountOrderEntity.builder()
                .username("TestUsername")
                .lastName("TestLastname")
                .firstName("TestFirstname")
                .build();

        AccountOrder accountOrder = AccountOrderMapper.INSTANCE.accountOrderEntityToAccountOrder(accountOrderEntity);

        assertNotNull(accountOrder);
        assertEquals(accountOrder.getFirstName(), accountOrderEntity.getFirstName());
        assertEquals(accountOrder.getLastName(), accountOrderEntity.getLastName());
        assertEquals(accountOrder.getUsername(), accountOrderEntity.getUsername());

    }
}
