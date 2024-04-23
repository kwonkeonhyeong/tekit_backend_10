package com.example.day15;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoServer {
    public static void main(String[] args) {
        // 1. UDP 통신 특정 port에 DatagramSocket 생성
        try {
            DatagramSocket datagramSocket = new DatagramSocket(8888);
            while (true) {
                byte[] receiveData = new byte[1024];
                byte[] sendData;
                // 클라이언트로부터 데이터를 받기 위한 DatagramPacket 생성
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                datagramSocket.receive(receivePacket);

                String message = new String(receivePacket.getData()).trim();

                InetAddress clientAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();

                sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, port);
                datagramSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
