package com.example.jpa.hrexam;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Region {
    @Id
    private Integer regionId;
    private String regionName;
}
