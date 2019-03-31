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
        // 指定发件人的账号密码。
        MailAccount account = MailAccount.builder()
                .address("18511012947@163.com")
                .loginName("18511012947@163.com")
                .password("password")
                .build();

        // 创建邮件，并制定好邮件标题
        MimeMail mail = MailUtils.createMessage("邮件主题");

        //填写邮件内容
        mail.setContent("这里是邮件正文！！！", TEXT_HTML);

        // 呼叫邮递员
        Postman postman = MailUtils.callPostman(Protocol.SMTP, SMTP_163, account);

        // 把信件交给邮递员，并指定收件人（可以指定多个收件人）。然后让邮递员进行派件。
        postman.mail(mail).receiver("18511012947@163.com", "18511012947@163.com").deliverNow();
    }
}
