package com.example.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoThreadServer {
    private static final int PORT_NUMBER = 9999;

    public static void main(String[] args) {
        // 1. ServerSocket 생성.. -- 1개만 있으면 됨.
        try (
                ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
                ) {
            while(true){
                Socket clientSocket = serverSocket.accept();
                // 클라이언트마다 각자 실행 할 수 있도록 만들어야 함!! (스레드!!)
                EchoThread echoThread = new EchoThread(clientSocket);
                echoThread.start();
            }
        } catch (IOException e) {}
    }
}

class EchoThread extends Thread {

    private Socket socket;

    EchoThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println(socket.getInetAddress().getHostAddress() + "로 부터 연결되었습니다.");
        try(
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                ) {
            String line = null;
            while((line = in.readLine()) != null){
                System.out.println("클라이언트로 부터 받은 메시지 : " + line);
                out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}