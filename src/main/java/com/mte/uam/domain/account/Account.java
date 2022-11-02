package com.mte.uam.domain.account;

import lombok.*;

/**
 * @author Jan Boonen
 */

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Account {

    @Getter
    private String firstName;

    @Getter
    private String lastName;

    @Getter
    private String username;

    public static Account create(String firstName, String lastName, String username) {
        return new Account(firstName, lastName, username);
    }
}
