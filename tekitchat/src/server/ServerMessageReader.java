package server;

import java.io.BufferedReader;
import java.io.IOException;

public class ServerMessageReader implements Runnable {
    private final BufferedReader in;

    public ServerMessageReader(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            String serverLine;
            while((serverLine = in.readLine()) != null) {
                System.out.println(serverLine);
            }
        } catch (IOException e) {
            System.out.println("서버와의 연결이 끊겼습니다.");;
        }
    }
}
