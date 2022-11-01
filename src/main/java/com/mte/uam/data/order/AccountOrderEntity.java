package com.mte.uam.data.order;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
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
@MappedEntity
public class AccountOrderEntity {

    @Id
    @Getter
    private String username;

    @Getter
    private String firstName;

    @Getter
    private String lastName;
}
