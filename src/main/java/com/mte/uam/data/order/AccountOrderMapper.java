package com.mte.uam.data.order;

import com.mte.uam.domain.order.AccountOrder;

/**
 * @author Maik Kingma
 */

public class AccountOrderMapper {
    public static AccountOrderEntity mapToEntity(AccountOrder order) {
        return AccountOrderEntity.builder()
                .username(order.getUsername())
                .firstName(order.getFirstName())
                .lastName(order.getLastName())
                .build();
    }
}
