package com.example.day14.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatThread implements Runnable{
    private final Socket socket;

    public ChatThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                ) {
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println("채팅 : " + line);
                out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
    }
}
