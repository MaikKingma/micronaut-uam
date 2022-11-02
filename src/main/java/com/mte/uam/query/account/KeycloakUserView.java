package com.mte.uam.query.account;

import java.util.UUID;

record KeycloakUserView(UUID accountId, String firstName, String lastName, String username) {
}
