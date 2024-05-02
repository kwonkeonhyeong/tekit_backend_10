package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import server.room.RoomManager;

public class Server {
    public static void main(String[] args) {
        try (
                ServerSocket serverSocket = new ServerSocket(1212);
        ) {
            Map<String, User> users= new HashMap<>();
            RoomManager roomManager = new RoomManager(users);
            while (true) {
                Socket socket = serverSocket.accept();

                new Thread(new ChatThread(socket, users,roomManager)).start();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
