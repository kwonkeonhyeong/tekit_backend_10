package server.room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import server.User;
import server.util.Util;

public class ChatRoom {
    private final Map<String, User> users;
    private final Map<String, User> members;
    private final int roomNumber;

    public ChatRoom(int roomNumber, Map<String, User> users) {
        this.users = users;
        this.members =  new HashMap<>();
        this.roomNumber = roomNumber;
    }

    public void join(User user) {
        synchronized (members) {
            members.put(user.getId(), user);
        }
        selfMessage(roomNumber + "번 방에 입장하였습니다.", user);
        selfMessage("채팅방 참여자 목록 보기: /roomusers", user);
        broadcast(user.getId() + "님이 입장하셨습니다.",user);
        chat(user);
    }


    public boolean isEmptyMembers() {
        return members.isEmpty();
    }

    public void chat(User user) {
        BufferedReader in = user.getIn();
        PrintWriter out = user.getOut();
        String msg;
        try {
            while((msg = in.readLine()) != null) {

                if("/roomusers".equalsIgnoreCase(msg)) {
                    out.println("현재 채팅방 인원 : " + Util.printUsers(members));
                    continue;
                }

                if(msg.matches("^/to\\s.*")) {
                    Util.whisper(msg,user,users);
                    continue;
                }

                if("/exit".equalsIgnoreCase(msg)) {
                    broadcast(user.getId() + "님이 방을 나갔습니다.",user);
                    synchronized (members) {
                        members.remove(user.getId());
                    }
                    if (isEmptyMembers()) {
                        selfMessage( roomNumber+"번 방이 삭제되었습니다.",user);
                    }
                    break;
                }

                broadcast(user.getId() + " : " + msg, user);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void selfMessage(String msg, User user) {
        user.getOut().println(msg);
    }

    public void broadcast(String msg, User user) {
        List<PrintWriter> outs = members.values().stream().map(User::getOut).toList();
        for (PrintWriter out : outs) {
            if(user.getOut().equals(out)) {
                continue;
            }
            out.println(msg);
        }
    }
}
