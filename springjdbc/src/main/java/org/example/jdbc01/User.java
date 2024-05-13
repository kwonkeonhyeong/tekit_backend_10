package org.example.jdbc01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 롬복 !!
@AllArgsConstructor
@Getter
@ToString
@NoArgsConstructor
@Setter
public class User {
    private Long id;
    private String name;
    private String email;
}
