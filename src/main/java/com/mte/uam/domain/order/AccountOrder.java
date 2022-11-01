package com.mte.uam.domain.order;

import lombok.*;
import com.mte.uam.domain.account.Account;

/**
 * @author Maik Kingma
 */

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class AccountOrder {

    @Getter
    private String firstName;

    @Getter
    private String lastName;

    @Getter
    private String username;

    @Getter
    private boolean finalized;

    public static AccountOrder create(String firstName, String lastName, String username) {
        return new AccountOrder(firstName, lastName, username, false);
    }

    public Account convertToAccount() {
        return Account.create(firstName, lastName, username);
    }

    public void finishOrder() {
        finalized = true;
    }
}
