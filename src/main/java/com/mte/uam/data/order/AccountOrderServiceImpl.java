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

    public void save(AccountOrder order) {
        accountOrderRepository.save(AccountOrderMapper.INSTANCE.accountOrderToAccountOrderEntity(order));
    }

    @Override
    public AccountOrder findById(String username) {
        return AccountOrderMapper.INSTANCE.accountOrderEntityToAccountOrder(
                accountOrderRepository.findById(username)
                        .orElseThrow(() -> new AccountOrderNotFoundException("order not found")));
    }

    @Override
    public void update(AccountOrder accountOrder) {
        accountOrderRepository.update(AccountOrderMapper.INSTANCE.accountOrderToAccountOrderEntity(accountOrder));
    }
}
