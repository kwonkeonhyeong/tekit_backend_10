package org.example.springmvcexam.domain;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class FriendsService {
    private final List<Friend> friendList;

    public void saveFriends(Friend friend) {
        friendList.add(friend);
    }
}
