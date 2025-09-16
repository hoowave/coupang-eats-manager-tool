package com.coupang_eats_gdmotors.hoowave.account.infrastructure.repository;

import com.coupang_eats_gdmotors.hoowave.account.core.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountJpaRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUserId(String userId);
}