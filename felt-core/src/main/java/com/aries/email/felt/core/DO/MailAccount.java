package com.aries.email.felt.core.DO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MailAccount {
    private String address;
    private String loginName;
    private String password;

    public static MailAccount of(String address, String loginName, String password) {
        return new MailAccount(address, loginName, password);
    }
}
