package com.aries.email.felt.core.DO;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;

@Getter
public class MailReceiversDO {
    private List<MailAddress> toList;
    private List<MailAddress> ccList;
    private List<MailAddress> bccList;

    public MailReceiversDO() {
        toList = Lists.newArrayList();
        ccList = Lists.newArrayList();
        bccList = Lists.newArrayList();
    }

    public MailReceiversDO(MailAddress address) {
        this();
        toList.add(address);
    }

    public static MailReceiversDO of(String address) {
        return new MailReceiversDO(MailAddress.of(address));
    }

    public static MailReceiversDO of(List<String> addresses) {
        MailReceiversDO result = new MailReceiversDO();
        for (String address : addresses) {
            result.addToReceiver(MailAddress.of(address));
        }
        return result;
    }

    public static MailReceiversDO of(MailAddress address) {
        return new MailReceiversDO(address);
    }

    public MailReceiversDO addToReceiver(MailAddress receiver) {
        this.toList.add(receiver);
        return this;
    }

    public MailReceiversDO addCcReceiver(MailAddress receiver) {
        this.ccList.add(receiver);
        return this;
    }

    public MailReceiversDO addBbcReceiver(MailAddress receiver) {
        this.bccList.add(receiver);
        return this;
    }

    public MailReceiversDO addToReceiver(MailAddress firstAddress, MailAddress... addresses) {
        this.toList.add(firstAddress);
        this.toList.addAll(Lists.newArrayList(addresses));
        return this;
    }

    public MailReceiversDO addCcReceiver(MailAddress firstAddress, MailAddress... addresses) {
        this.ccList.add(firstAddress);
        this.ccList.addAll(Lists.newArrayList(addresses));
        return this;
    }

    public MailReceiversDO addBbcReceiver(MailAddress firstAddress, MailAddress... addresses) {
        this.bccList.add(firstAddress);
        this.bccList.addAll(Lists.newArrayList(addresses));
        return this;
    }

    public MailReceiversDO addToReceiver(List<MailAddress> addresses) {
        this.toList.addAll(addresses);
        return this;
    }

    public MailReceiversDO addCcReceiver(List<MailAddress> addresses) {
        this.ccList.addAll(addresses);
        return this;
    }

    public MailReceiversDO addBbcReceiver(List<MailAddress> addresses) {
        this.bccList.addAll(addresses);
        return this;
    }

}
