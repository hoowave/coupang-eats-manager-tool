package com.coupang_eats_gdmotors.hoowave.account.application.port.in;

import com.coupang_eats_gdmotors.hoowave.account.core.command.LoginCmd;
import com.coupang_eats_gdmotors.hoowave.account.core.command.RegisterCmd;
import com.coupang_eats_gdmotors.hoowave.account.core.info.LoginInfo;
import com.coupang_eats_gdmotors.hoowave.account.core.info.RegisterInfo;

public interface AccountPort {
    RegisterInfo register(RegisterCmd registerCmd);
    LoginInfo login(LoginCmd loginCmd);
}
