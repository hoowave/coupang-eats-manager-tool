package com.coupang_eats_gdmotors.hoowave.account.application.service;

import com.coupang_eats_gdmotors.hoowave.account.application.port.in.AccountPort;
import com.coupang_eats_gdmotors.hoowave.account.application.port.out.AccountRepositoryPort;
import com.coupang_eats_gdmotors.hoowave.account.core.Account;
import com.coupang_eats_gdmotors.hoowave.account.core.command.LoginCmd;
import com.coupang_eats_gdmotors.hoowave.account.core.command.RegisterCmd;
import com.coupang_eats_gdmotors.hoowave.account.core.info.LoginInfo;
import com.coupang_eats_gdmotors.hoowave.account.core.info.RegisterInfo;
import com.coupang_eats_gdmotors.hoowave.common.exception.BaseException;
import com.coupang_eats_gdmotors.hoowave.common.response.MessageCode;
import com.coupang_eats_gdmotors.hoowave.utils.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService implements AccountPort {

    private final AccountRepositoryPort accountRepositoryPort;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    @Transactional
    public RegisterInfo register(RegisterCmd registerCmd) {
        Optional<Account> existUserId = accountRepositoryPort.getAccountByUsername(registerCmd.getUserId());
        if (existUserId.isPresent()) {
            throw new BaseException(MessageCode.REGISTER_EXIST_ID.getMessage());
        }
        var initCmd = registerCmd.toEntity(passwordEncoder.encode(registerCmd.getPassword()));
        accountRepositoryPort.insert(initCmd);
        var registerInfo = new RegisterInfo(initCmd);
        return registerInfo;
    }

    @Override
    @Transactional
    public LoginInfo login(LoginCmd loginCmd) {
        Optional<Account> existUserId = accountRepositoryPort.getAccountByUsername(loginCmd.getUserId());
        if (existUserId.isEmpty()) throw new BaseException(MessageCode.LOGIN_FAIL.getMessage());
        if (!passwordEncoder.matches(loginCmd.getPassword(), existUserId.get().getPassword()))
            throw new BaseException(MessageCode.LOGIN_FAIL.getMessage());
        String token = jwtUtil.generateToken(existUserId.get().getUserId(), existUserId.get().getRole().name());
        var loginInfo = new LoginInfo(existUserId.get() ,token);
        return loginInfo;
    }
}
