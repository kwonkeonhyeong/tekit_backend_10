package cilent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import server.ServerMessageReader;

public class Client {
    public static void main(String[] args) {
        String hostName = "localhost";
        int portNumber = 1212;

        Socket socket;
        PrintWriter out;
        BufferedReader in;

        try {
            socket = new Socket(hostName, portNumber);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner stdIn = new Scanner(System.in);

            String duplicationId = "false";
            do {
                if ("true".equals(duplicationId)) {
                    System.out.println("중복된 ID입니다. 다른 ID를 입력해주세요.");
                }
                System.out.print("닉네임을 입력하세요: ");
                String nickName = stdIn.nextLine();
                out.println(nickName);
                duplicationId = in.readLine();
            }
            while (duplicationId.equals("true"));

            Thread readThread = new Thread(new ServerMessageReader(in));
            readThread.start();

            String userInput;
            while (true) {
                userInput = stdIn.nextLine();

                if ("/bye".equals(userInput)) {
                    out.println(userInput);
                    break;
                }

                out.println(userInput);
            }

            socket.close();
            out.close();
            in.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}