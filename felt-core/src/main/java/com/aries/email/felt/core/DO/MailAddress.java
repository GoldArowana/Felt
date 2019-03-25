package com.aries.email.felt.core.DO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MailAddress {
    private String address;

    public static MailAddress of(String address) {
        return new MailAddress(address);
    }

    @Override public String toString() {
        return this.address;
    }
}
