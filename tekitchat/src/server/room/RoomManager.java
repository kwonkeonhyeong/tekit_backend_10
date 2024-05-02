package server.room;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import server.User;

public class RoomManager {
    private static int TEMP_ROOM_NUMBER = 1;

    private final Map<Integer, ChatRoom> roomList = new HashMap<>();
    private final Map<String, User> users;

    public RoomManager(Map<String, User> users) {
        this.users = users;
    }

    public void create(User user) {
        ChatRoom chatRoom = new ChatRoom(TEMP_ROOM_NUMBER,users);
        synchronized (roomList) {
            roomList.put(TEMP_ROOM_NUMBER, chatRoom);
        }
        chatRoom.selfMessage("방 번호 [" + TEMP_ROOM_NUMBER + "]가 생성되었습니다.", user);
        TEMP_ROOM_NUMBER++;
        chatRoom.join(user);
    }

    public void enter(int roomNumber, User user) {
        ChatRoom chatRoom = roomList.get(roomNumber);
        chatRoom.join(user);
    }

    public boolean isEmptyRooms() {
        return roomList.isEmpty();
    }

    public void refresh() {
        List<Integer> removeRooms = roomList.values().stream()
                .filter(ChatRoom::isEmptyMembers).map(ChatRoom::getRoomNumber).toList();

        for (Integer roomNumber : removeRooms) {
            roomList.remove(roomNumber);
        }
    }

    public boolean isExistRoom(int roomNumber) {
        return roomList.containsKey(roomNumber);
    }

    @Override
    public String toString() {
        return roomList.keySet().toString();
    }
}
