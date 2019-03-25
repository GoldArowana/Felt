package com.aries.email.felt.core.DO;

import com.sun.mail.util.PropUtil;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeMessage;
import java.io.InputStream;

public class MimeMail extends MimeMessage {
    private boolean strict = true;

    public MimeMail() {
        super((Session) null);
    }

    public MimeMail(Session session) {
        super(session);
    }

    public MimeMail(Session session, InputStream is) throws MessagingException {
        super(session, is);
    }

    public MimeMail(MimeMessage source) throws MessagingException {
        super(source);
    }

    protected MimeMail(Folder folder, int msgnum) {
        super(folder, msgnum);
    }

    protected MimeMail(Folder folder, InputStream is, int msgnum) throws MessagingException {
        super(folder, is, msgnum);
    }

    protected MimeMail(Folder folder, InternetHeaders headers, byte[] content, int msgnum) throws MessagingException {
        super(folder, headers, content, msgnum);
    }

    public void setSession(Session session) {
        super.session = session;
    }

    public void initStrict() {
        if (session != null)
            strict = PropUtil.getBooleanSessionProperty(session,
                    "mail.mime.address.strict", true);
    }
}
