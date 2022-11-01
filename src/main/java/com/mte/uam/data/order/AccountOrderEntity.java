package com.mte.uam.data.order;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Maik Kingma
 */

@Builder
@NoArgsConstructor
@AllArgsConstructor
@MappedEntity(value = "account_order")
public class AccountOrderEntity {

    @Id
    @Getter
    private String username;

    @Getter
    @MappedProperty(value = "firstname")
    private String firstName;

    @Getter
    @MappedProperty(value = "lastname")
    private String lastName;
}
