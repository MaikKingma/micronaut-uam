package com.mte.uam.domain.order;

/**
 * @author Maik Kingma
 */

public interface AccountOrderService {
    void save(AccountOrder order);

    AccountOrder findById(String username);

    void update(AccountOrder accountOrder);

    class AccountOrderNotFoundException  extends RuntimeException{
        public AccountOrderNotFoundException(String errorMessage) {
            super(errorMessage);
        }
    }
}
