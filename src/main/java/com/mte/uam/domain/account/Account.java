package com.mte.uam.domain.account;

import lombok.*;

import java.util.UUID;

/**
 * @author Jan Boonen
 */

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Account {

    @Getter
    private String accountId;

    @Getter
    private String firstName;

    @Getter
    private String lastName;

    @Getter
    private String username;

    public static Account create(String firstName, String lastName, String username) {
        return new Account(UUID.randomUUID().toString(), firstName, lastName, username);
    }
}
