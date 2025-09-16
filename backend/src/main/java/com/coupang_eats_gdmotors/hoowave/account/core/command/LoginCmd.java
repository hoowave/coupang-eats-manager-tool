package com.coupang_eats_gdmotors.hoowave.account.core.command;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginCmd {
    private String userId;
    private String password;
}