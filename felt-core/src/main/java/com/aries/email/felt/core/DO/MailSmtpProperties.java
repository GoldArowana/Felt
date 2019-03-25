package com.aries.email.felt.core.DO;

import lombok.AllArgsConstructor;

import java.util.Properties;

import static com.aries.email.felt.core.constants.PropConst.*;
import static com.aries.email.felt.core.constants.ProtocalConst.SMTP;

@AllArgsConstructor
public class MailSmtpProperties {
    private String smtpAddress;

    public static MailSmtpProperties of(String address) {
        return new MailSmtpProperties(address);
    }

    public static Properties convert2Properties(String smtpAddress) {
        return getSmptProp(smtpAddress);
    }

    public static Properties convert2Properties(MailSmtpProperties mailSmtpProperties) {
        return getSmptProp(mailSmtpProperties.smtpAddress);
    }

    private static Properties getSmptProp(String smtpAddress) {
        Properties props = new Properties();
        //设置用户的认证方式
        props.setProperty(MAIL_SMTP_AUTH, String.valueOf(true));
        //设置传输协议
        props.setProperty(MAIL_TRANSPORT_PROTOCOL, SMTP);
        //设置发件人的SMTP服务器地址
        props.setProperty(MAIL_SMTP_HOST, smtpAddress);
        return props;
    }

    public Properties convert2Properties() {
        return getSmptProp(this.smtpAddress);
    }
}
