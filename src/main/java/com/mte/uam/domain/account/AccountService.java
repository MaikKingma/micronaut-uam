package com.mte.uam.domain.account;

import com.mte.uam.domain.order.AccountOrder;

public interface AccountService {

    Account create(AccountOrder accountOrder);

}
