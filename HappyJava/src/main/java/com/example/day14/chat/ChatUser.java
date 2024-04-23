package com.example.day14.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatUser {
    private static final int PORT_NUMBER = 39391;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket("127.0.0.1", PORT_NUMBER);
                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader chat = new BufferedReader(new InputStreamReader(System.in));
                ) {
            String line = null;
            while((line = chat.readLine()) != null) {
                pw.println(line);

                System.out.println(br.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
