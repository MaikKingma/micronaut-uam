package com.mte.uam.data.account;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import lombok.*;

/**
 * @author Jan Boonen
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@MappedEntity(value = "account")
@EqualsAndHashCode
public class AccountEntity {

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
