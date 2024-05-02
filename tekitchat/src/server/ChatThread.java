package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;
import server.room.RoomManager;
import server.util.Util;

public class ChatThread implements Runnable {

    private final Socket socket;
    private final Map<String, User> users;
    private final RoomManager roomManager;

    private User user;
    private String id;
    private BufferedReader in;
    private PrintWriter out;


    public ChatThread(Socket socket, Map<String, User> users, RoomManager roomManager) {
        this.socket = socket;
        this.users = users;
        this.roomManager = roomManager;

        String clientIp = socket.getLocalAddress().toString().substring(1);

        System.out.printf("[ip 접속] : %s\n", clientIp);

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            boolean isDuplicate;
            do {
                id = in.readLine();
                isDuplicate = checkIdDuplication();
                out.println(isDuplicate);
            }
            while (isDuplicate);

            user = new User(id, clientIp, out, in);

            System.out.printf("[%s] %s 닉네임의 사용자가 연결했습니다.\n", clientIp, id);

            synchronized (this.users) {
                users.put(id,user);
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public boolean checkIdDuplication() {
        return users.containsKey(id);
    }


    @Override
    public void run() {
        String msg = null;
        try {
            out.println("[tekit chat 로비입니다.]");
            out.println("######################################");
            out.println("방 목록 보기 : /list");
            out.println("방 생성 : /create");
            out.println("방 입장 : /join [방번호]");
            out.println("방 나가기 : /exit");
            out.println("현재 접속 중인 사용자 목록 보기: /users");
            out.println("접속종료 : /bye");
            out.println("######################################");

            while (true) {
                roomManager.refresh();
                if ((msg = in.readLine()) == null) {
                    break;
                }

                if ("/list".equalsIgnoreCase(msg)) {
                    if (roomManager.isEmptyRooms()) {
                        out.println("생성되어 있는 채팅방이 없습니다.");
                    } else {
                        out.println("=============================================");
                        out.println("입장 가능한 채팅방");
                        out.println(roomManager.toString());
                        out.println("=============================================");
                    }
                    continue;
                }

                if("/users".equalsIgnoreCase(msg)) {
                    out.println("=============================================");
                    out.println("현재 접속중인 사용자 목록");
                    out.println(Util.printUsers(users));
                    out.println("=============================================");
                    continue;
                }

                if ("/create".equalsIgnoreCase(msg)) {
                    roomManager.create(user);
                    continue;
                }

                if (msg.matches("^/join\\s+\\d+$")) {
                    String[] splitMsg = msg.split(" ");
                    int targetRoom = Integer.parseInt(splitMsg[1]);
                    if(roomManager.isExistRoom(targetRoom)) {
                        roomManager.enter(targetRoom, user);
                    } else {
                        out.println(targetRoom + "번방은 존재하지 않는 방입니다.");
                    }
                    continue;
                }

                if(msg.matches("^/to\\s.*")) {
                    Util.whisper(msg,user,users);
                    continue;
                }

                if ("/bye".equalsIgnoreCase(msg)) {
                    System.out.printf("[%s] %s 닉네임의 사용자가 연결을 끊었습니다.\n", user.getIp(), id);
                    users.remove(id);
                    socket.close();
                    out.close();
                    in.close();
                    break;
                }

                out.println("옳바르지 않은 명령어입니다. 명령어를 확인 후 다시 입력해주세요.");

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
