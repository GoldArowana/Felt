package com.aries.email.felt.core.utils;

import com.aries.email.felt.core.DO.MailAccount;
import com.aries.email.felt.core.DO.MailSmtpProperties;
import com.aries.email.felt.core.DO.MimeMail;
import com.aries.email.felt.core.DO.Postman;
import com.aries.email.felt.core.constants.Protocol;
import com.aries.email.felt.core.exception.CreateMailFailedException;
import com.aries.email.felt.core.exception.MailProtocolException;

import javax.mail.MessagingException;
import javax.mail.Session;
import java.util.Properties;

import static com.aries.email.felt.core.constants.ProtocalConst.UTF8;

public class MailUtils {
    public static MimeMail createMessage() {
        return new MimeMail((Session) null);
    }

    public static MimeMail createMessage(String subject) throws CreateMailFailedException {
        MimeMail mail = new MimeMail((Session) null);
        try {
            mail.setSubject(subject, UTF8);
        } catch (MessagingException e) {
            throw new CreateMailFailedException("设置主题失败:" + e.getMessage());
        }
        return mail;
    }

    /**
     * @param protocol        发件人的协议
     * @param protocolAddress 发件人协议对应的地址
     * @param account         发件人账号
     * @return 邮递员
     * @throws MailProtocolException 协议不支持异常
     */
    public static Postman callPostman(Protocol protocol, String protocolAddress, MailAccount account) throws MailProtocolException {
        Properties props = null;
        if (protocol == Protocol.SMTP) {
            props = MailSmtpProperties.convert2Properties(protocolAddress);
            //2、创建定义整个应用程序所需的环境信息的 Session 对象
            Session session = Session.getInstance(props);
            //设置调试信息在控制台打印出来
            session.setDebug(true);
            //3、创建邮件的实例对象
            return new Postman(protocol, protocolAddress, account, session);
        }
        throw new MailProtocolException("目前没有支持该协议的邮递员");
    }
}
