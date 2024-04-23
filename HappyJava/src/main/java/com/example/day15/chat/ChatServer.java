package com.example.day15.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ChatServer {
    private static final int PORT = 3131;

    public static void main(String[] args) {
        try (
                // 1. 서버 소캣을 생성!
                ServerSocket serverSocket = new ServerSocket(PORT);
        ) {
            System.out.println("서버가 준비되었습니다.");
            // 여러명의 클라이언트의 정보를 기억할 공간
            Map<String, PrintWriter> chatClients = new HashMap<>();
            while (true) {
                // 2. accept()를 통해서 소캣을 얻어옴. (여러명의 클라이언트와 접속할 수 있도록 구현)
                Socket socket = serverSocket.accept();
                // Thread 이용 !!
                new ChatThread(socket, chatClients).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ChatThread extends Thread {
    private final Socket socket;
    private String id;
    private Map<String, PrintWriter> chatClients;

    private BufferedReader in;
    private PrintWriter out;

    // 생성자를 통해서 클라이언트 소캣을 얻어옴
    public ChatThread(Socket socket, Map<String, PrintWriter> chatClients) {
        this.socket = socket;
        this.chatClients = chatClients;

        // 클리어언트가 생성될 때 클라이언트로부터 아이디를 얻어오게 하고 싶어요.
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Client가 접속하자마자 id를 보낸다는 약속!!
            id = in.readLine();
            // 이때.. 모든 사용자에게 id님이 입장했다는 정보를 알려줌
            broadcast(id + "님이 입장하셨습니다.");
            System.out.println("새로운 사용지의 아이디는 " + id + "입니다.");

            // 동시에 일어날 수도..
            synchronized (chatClients) {
                chatClients.put(id, out);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        // run
        // 연결된 클라이언트가 메시지를 전송하면, 그 메시지를 받아서 다른 사용자들에게 보내줌
        // 각각 클라이언트와 통신 할 수 있는 통로 얻어옴.
        // 모든 클라이언크에게 전송하기 위해서 무엇을??
        String msg = null;
        try {
            while ((msg = in.readLine()) != null) {
                if ("/quit".equalsIgnoreCase(msg)) {
                    break;
                }

                if (msg.indexOf("/to") == 0) {
                    sengMsd(msg);
                    continue;
                }
                broadcast(id + " : " + msg);
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            synchronized (chatClients) {
                chatClients.remove(id);
            }
            broadcast(id + "님이 채팅에서 나갔습니다.");

            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    // 전체 사용자에세 알려주는 메서드
    public void broadcast(String msg) {
        for (PrintWriter out : chatClients.values()) {
            out.println(msg);
        }
//
//        synchronized (chatClients) {
//            Iterator<PrintWriter> it = chatClients.values().iterator();
//            while (it.hasNext()) {
//                PrintWriter out = it.next();
//                try {
//                    out.println(msg);
//                } catch (Exception e) {
//                    it.remove(); // 브로드캐스트 할 수 없는 사용자 제거
//                    e.printStackTrace();
//                }
//            }
//        }
    }

    // 특정사용자한테만 보내기
    public void sengMsd(String msg) {
        int firstSpaceIndex = msg.indexOf(" ");
        if (firstSpaceIndex == -1) {
            return; // 공백이 없다면....
        }
        int secondSpaceIndex = msg.indexOf(" ", firstSpaceIndex + 1);
        if(secondSpaceIndex == -1) {
            return; // 보낼메세지가 없다면....
        }

        String to = msg.substring(firstSpaceIndex + 1, secondSpaceIndex);
        String message = msg.substring(secondSpaceIndex + 1);

        // to(수신자)에게 메시지 전송.
        PrintWriter pw = chatClients.get(to);
        if(pw != null) {
            pw.println(id + "님으로부터 온 비밀 메시지 : " + message);
        } else {
            System.out.println("오류 : 수신자" + to + "님을 찾을 수 없습니다.");
        }
    }
}