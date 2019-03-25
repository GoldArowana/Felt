package com.aries.email.felt.core;

import com.aries.email.felt.core.DO.MailAccount;
import com.aries.email.felt.core.DO.MimeMail;
import com.aries.email.felt.core.DO.Postman;
import com.aries.email.felt.core.constants.Protocol;
import com.aries.email.felt.core.utils.MailUtils;
import org.junit.Test;

import static com.aries.email.felt.core.constants.HostConst.SMTP_163;
import static com.aries.email.felt.core.constants.ProtocalConst.TEXT_HTML;

public class SendMailTest {
    @Test
    public void sendMailTest() throws Exception {
        MailAccount account = MailAccount.builder()
                .address("18511012947@163.com")
                .loginName("18511012947@163.com")
                .password("password")
                .build();

        MimeMail mail = MailUtils.createMessage("邮件主题");
        mail.setContent("简单的纯文本邮件！", TEXT_HTML);
        Postman postman = MailUtils.callPostman(Protocol.SMTP, SMTP_163, account);
        postman.mail(mail).receiver("18511012947@163.com", "18511012947@163.com").deliverNow();
    }
}
