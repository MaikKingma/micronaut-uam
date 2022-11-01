package com.mte.uam.domain.order;

/**
 * @author Maik Kingma
 */

public interface AccountOrderService {
    void register(AccountOrder order);

    void finalize(String username);

}
