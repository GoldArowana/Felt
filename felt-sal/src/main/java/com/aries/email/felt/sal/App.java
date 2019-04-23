package com.aries.email.felt.sal;

import com.aries.hera.client.thrift.DiscoverClient;
import com.aries.hera.client.thrift.exception.CallFailedException;
import org.apache.thrift.transport.TTransportException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws CallFailedException, TTransportException, InterruptedException {

        System.out.println(DiscoverClient.getServices("Felt"));

//        System.out.println(DiscoverClient.registe(new ServiceInfo(){{
//            setName("Felt");
//            setHost("localhost");
//            setPort(8888);
//        }}));
//        while(true){
//            Thread.sleep(500);
//            System.out.println(DiscoverClient.getServices("Felt"));
//        }
    }
}
