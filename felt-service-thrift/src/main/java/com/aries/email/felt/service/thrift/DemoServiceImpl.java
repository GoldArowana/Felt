package com.aries.email.felt.service.thrift;

import com.aries.email.felt.contract.thrift.DemoService;
import com.aries.email.felt.contract.thrift.dto.Person;
import com.aries.email.felt.contract.thrift.dto.QueryParameter;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.List;

public class DemoServiceImpl implements DemoService.Iface {


    public String ping() throws TException {
        System.out.println("ping()");
        return "pong";
    }

    public List<Person> getPersonList(QueryParameter parameter) throws TException {
        //System.out.println(parameter.getAgeStart() + " - " + parameter.getAgeEnd());

        List<Person> list = new ArrayList<Person>(10);
        for (short i = 0; i < 10; i++) {
            Person p = new Person();
            p.setAge(i);
            p.setChildrenCount(Byte.valueOf(i + ""));
            p.setName("test" + i);
            p.setSalary(10000D);
            p.setSex(true);
            list.add(p);
        }
        return list;
    }
}