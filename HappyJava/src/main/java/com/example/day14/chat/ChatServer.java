package com.example.day14.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    private static final int PORT_NUMBER = 39391;

    public static void main(String[] args) {
        try (
                ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
                ) {
            while(true) {
                Socket socket = serverSocket.accept();
                new Thread(new ChatThread(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
