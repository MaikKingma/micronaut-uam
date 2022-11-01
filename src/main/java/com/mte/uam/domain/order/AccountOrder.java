package com.mte.uam.domain.order;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author Maik Kingma
 */

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountOrder {

    @Getter
    private String firstName;

    @Getter
    private String lastName;

    @Getter
    private String username;

    public static AccountOrder create(String firstName, String lastName, String username) {
        return new AccountOrder(firstName, lastName, username);
    }
}
