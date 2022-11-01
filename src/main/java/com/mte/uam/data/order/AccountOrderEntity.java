package com.mte.uam.data.order;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import lombok.*;

/**
 * @author Maik Kingma
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@MappedEntity(value = "account_order")
public class AccountOrderEntity {

    @Id
    private String username;

    @MappedProperty(value = "firstname")
    private String firstName;

    @MappedProperty(value = "lastname")
    private String lastName;

    @MappedProperty(value = "finalized")
    private boolean finalized;

    AccountOrderEntity setFinalized() {
        finalized = true;
        return this;
    }

}
