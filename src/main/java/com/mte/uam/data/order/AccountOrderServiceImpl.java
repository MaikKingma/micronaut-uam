package com.mte.uam.data.order;

import com.mte.uam.domain.order.AccountOrder;
import com.mte.uam.domain.order.AccountOrderService;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.exceptions.HttpStatusException;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;
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
        Optional<AccountOrderEntity> accountOrder = accountOrderRepository.findById(username);
        if(accountOrder.isPresent()){
            accountOrderRepository.update(accountOrder.get().setFinalized());
        }
    }

}
