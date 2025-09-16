package com.coupang_eats_gdmotors.hoowave.account.core.info;

import com.coupang_eats_gdmotors.hoowave.account.core.Account;
import com.coupang_eats_gdmotors.hoowave.account.core.enums.AccountRole;
import lombok.Getter;

@Getter
public class LoginInfo {
    private String token;
    private String userId;
    private AccountRole role;


    public LoginInfo(Account account, String token) {
        this.userId = account.getUserId();
        this.role = AccountRole.valueOf(account.getRole().name());
        this.token = token;
    }
}