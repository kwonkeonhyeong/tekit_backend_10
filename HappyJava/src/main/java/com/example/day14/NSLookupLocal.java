package com.example.day14;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookupLocal {
    public static void main(String[] args) {
        try {
            // 특정 호스트의 IP 주소 조회
            InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println("Google's IP Address = " + address.getHostAddress());;

            // 로컬 호스트의 IP 주소와 이름 조회
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("Local Host Name: " + localAddress.getHostName());
            System.out.println("Local IP Address:" + localAddress.getHostAddress());

            byte[] ip = localAddress.getAddress();
            for (int i = 0; i < ip.length; i++) {
                System.out.println(ip[i] & 0xFF); // 부호 없는 바이트로 출력
                if(i != ip.length - 1) {
                    System.out.println(".");
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
