package com.example.day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {
        try(
                Socket socket = new Socket("127.0.0.1",9999);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
                ) {
            String line = null;
            while((line = keyboard.readLine()) != null) {
                if("exit".equalsIgnoreCase(line.trim())) {
                    break;
                }
                out.println(line);

                String response = in.readLine();
                System.out.println("서버로부터 받은 응답 메시지 : " + response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
