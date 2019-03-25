package com.aries.email.felt.core.DO;

import com.aries.email.felt.core.constants.Protocol;
import com.aries.email.felt.core.utils.InternetUtils;
import com.google.common.collect.Lists;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;

public class Postman {
    private Protocol protocol;
    private String protocolAddress;
    private MailAccount account;
    private Session session;
    private MimeMail mail;

    public Postman(Protocol protocol, String protocolAddress, MailAccount account, Session session) {
        this.protocol = protocol;
        this.protocolAddress = protocolAddress;
        this.account = account;
        this.session = session;
    }

    public Postman mail(MimeMail mail) throws SendFailedException {
        this.mail = mail;
        mail.setSession(session);
        mail.initStrict();
        try {
            mail.setFrom(account.getAddress());
        } catch (MessagingException e) {
            throw new SendFailedException("设置发件人失败：" + e.getMessage());
        }

        return this;
    }

    public void receiver(MailReceiversDO receiversDO) throws SendFailedException {
        try {
            mail.addRecipients(MimeMessage.RecipientType.TO, InternetUtils.addressList2InternetArr(receiversDO.getToList()));
            mail.addRecipients(MimeMessage.RecipientType.CC, InternetUtils.addressList2InternetArr(receiversDO.getCcList()));
            mail.addRecipients(MimeMessage.RecipientType.BCC, InternetUtils.addressList2InternetArr(receiversDO.getBccList()));
        } catch (MessagingException e) {
            throw new SendFailedException("设置收件人失败：" + e.getMessage());
        }
    }

    public Postman receiver(List<String> addresses) throws SendFailedException {
        try {
            for (String address : addresses) {
                mail.addRecipients(MimeMessage.RecipientType.TO, MailAddress.of(address).toString());
            }
            return this;
        } catch (MessagingException e) {
            throw new SendFailedException("设置收件人失败：" + e.getMessage());
        }
    }

    public Postman receiver(String... addresses) throws SendFailedException {
        return receiver(Lists.newArrayList(addresses));
    }

    public void deliverNow() throws SendFailedException {
        try {
            mail.setSentDate(new Date());
        } catch (MessagingException e) {
            throw new SendFailedException("设置发送时间失败：" + e.getMessage());
        }

        try {
            Transport transport = session.getTransport();

            //设置发件人的账户名和密码
            transport.connect(account.getLoginName(), account.getPassword());
            //发送邮件，并发送到所有收件人地址，message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            transport.sendMessage(mail, mail.getAllRecipients());

            //5、关闭邮件连接
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
