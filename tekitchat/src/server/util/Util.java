package server.util;

import java.util.Map;
import server.User;

public class Util {
    public static void whisper(String msg, User user, Map<String, User> users) {

        String[] splitMsg = msg.split(" ",3);

        if (splitMsg.length != 3) {
            user.getOut().println("귓속말 형식에 맞게 입력해주세요. /to 닉네임 메세지");
            return;
        }

        String targetUser = splitMsg[1];

        if(users.containsKey(targetUser)) {
            users.get(targetUser).getOut().println("/from " + user.getId() + " " + splitMsg[2]);
        } else {
            user.getOut().println("귓속말 대상이 존재하지 않습니다.");
        }
    }

    public static String printUsers(Map<String, User> users) {
        StringBuilder membersMsg = new StringBuilder();
        membersMsg.append("[");
        int index = 0;
        for (String user : users.keySet()) {
            if (index == users.values().size()-1) {
                membersMsg.append(user).append("]");
            } else {
                membersMsg.append(user).append(",");
                index++;
            }
        }
        return membersMsg.toString();
    }
}
