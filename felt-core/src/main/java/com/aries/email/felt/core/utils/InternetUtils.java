package com.aries.email.felt.core.utils;

import com.aries.email.felt.core.DO.MailAddress;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.List;

public class InternetUtils {
    public static InternetAddress[] addressList2InternetArr(List<MailAddress> addresses) {
        final InternetAddress[] result = new InternetAddress[addresses.size()];
        for (int i = 0; i < addresses.size(); i++) {
            try {
                result[i] = new InternetAddress(addresses.get(i).toString());
            } catch (AddressException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
