package com.example.day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        try(
                ServerSocket serverSocket = new ServerSocket(9999);
                Socket socket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        ) {
           String line = null;
           while((line = in.readLine()) != null) {
               System.out.println("클라이언트에게 받은 메세지 : " + line);

               out.println(line);
           }
        } catch (Exception e){
            e.printStackTrace();
        };
    }
}
