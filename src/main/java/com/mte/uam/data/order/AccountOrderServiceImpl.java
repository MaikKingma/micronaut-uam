package com.mte.uam.data.order;

import com.mte.uam.domain.order.AccountOrder;
import com.mte.uam.domain.order.AccountOrderService;
import jakarta.inject.Singleton;

/**
 * @author Maik Kingma
 */

@Singleton
public class AccountOrderServiceImpl implements AccountOrderService {

    private final AccountOrderRepository accountOrderRepository;

    public AccountOrderServiceImpl(AccountOrderRepository accountOrderRepository) {
        this.accountOrderRepository = accountOrderRepository;
    }

    @Override
    public void register(AccountOrder order) {
        accountOrderRepository.save(AccountOrderMapper.INSTANCE.accountOrderToAccountOrderEntity(order));
    }
}
