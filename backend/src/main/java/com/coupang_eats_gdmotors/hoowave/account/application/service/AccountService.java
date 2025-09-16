package com.coupang_eats_gdmotors.hoowave.account.application.service;

import com.coupang_eats_gdmotors.hoowave.account.application.port.in.AccountPort;
import com.coupang_eats_gdmotors.hoowave.account.application.port.out.AccountRepositoryPort;
import com.coupang_eats_gdmotors.hoowave.account.core.command.LoginCmd;
import com.coupang_eats_gdmotors.hoowave.account.core.command.RegisterCmd;
import com.coupang_eats_gdmotors.hoowave.account.core.info.LoginInfo;
import com.coupang_eats_gdmotors.hoowave.account.core.info.RegisterInfo;
import com.coupang_eats_gdmotors.hoowave.utils.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService implements AccountPort {

    private final AccountRepositoryPort accountRepositoryPort;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    @Transactional
    public RegisterInfo register(RegisterCmd registerCmd) {
        return null;
    }

    @Override
    @Transactional
    public LoginInfo login(LoginCmd loginCmd) {
        return null;
    }
}
