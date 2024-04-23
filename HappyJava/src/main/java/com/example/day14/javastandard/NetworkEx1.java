package com.example.day14.javastandard;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkEx1 {
    public static void main(String[] args) {
        InetAddress ip = null;
        InetAddress[] ipArr = null;

        try {
            ip = InetAddress.getByName("www.naver.com");
            System.out.println("getHostName() : " + ip.getHostName());
            System.out.println("getHostAddress() : " + ip.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
