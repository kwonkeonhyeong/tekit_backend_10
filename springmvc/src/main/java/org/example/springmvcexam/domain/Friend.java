package org.example.springmvcexam.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Friend {
    private String id;
    private String name;
    private String email;
}
