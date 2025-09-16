package com.coupang_eats_gdmotors.hoowave.account.application.port.out;

import com.coupang_eats_gdmotors.hoowave.account.core.Account;

import java.util.Optional;

public interface AccountRepositoryPort {

    Optional<Account> getAccountByUsername(String userId);

    void insert(Account account);

}
