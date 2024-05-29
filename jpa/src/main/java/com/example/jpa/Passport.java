package com.example.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="passports")
@Getter@Setter
@NoArgsConstructor
public class Passport {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name="passport_number")
    private String passportNumber;
    @OneToOne
    @JoinColumn(name="person_id",unique = true)
    private Person person;

    public Passport(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
