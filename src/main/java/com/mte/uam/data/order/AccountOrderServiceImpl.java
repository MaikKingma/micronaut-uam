package com.mte.uam.data.order;

import com.mte.uam.domain.order.AccountOrder;
import com.mte.uam.domain.order.AccountOrderService;
import jakarta.inject.Singleton;

import java.util.Optional;

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

    @Override
    public void finalize(String username) {
        accountOrderRepository.findById(username).ifPresent(
                accountOrderEntity -> accountOrderRepository.update(accountOrderEntity.setFinalized())
        );
    }

}
