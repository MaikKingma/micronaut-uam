package com.mte.uam.domain.order;

import com.mte.uam.DomainEvent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Getter
    @Builder.Default
    private List<DomainEvent> domainEvents = new ArrayList<>();

    public static AccountOrder create(String firstName, String lastName, String username) {
        return new AccountOrder(firstName, lastName, username, Arrays.asList(new AccountOrderCreatedEvent(username)));
    }

    @Value
    public static class AccountOrderCreatedEvent extends DomainEvent {
        String username;
    };
}
