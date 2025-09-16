package com.coupang_eats_gdmotors.hoowave.account.infrastructure.adapter.out;

import com.coupang_eats_gdmotors.hoowave.account.application.port.out.AccountRepositoryPort;
import com.coupang_eats_gdmotors.hoowave.account.core.Account;
import com.coupang_eats_gdmotors.hoowave.account.infrastructure.repository.AccountJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryAdapter implements AccountRepositoryPort {

    private final AccountJpaRepository accountJpaRepository;

    @Override
    public Optional<Account> getAccountByUsername(String userId) {
        Optional<Account> existAccount = accountJpaRepository.findByUserId(userId);
        return existAccount;
    }

    @Override
    public void insert(Account account) {
        accountJpaRepository.save(account);
    }
}
