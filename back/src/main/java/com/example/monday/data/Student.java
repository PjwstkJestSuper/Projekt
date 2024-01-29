package com.example.monday.data;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Student {

    public Student(String name, StudentUnit unit, Tryb tryb, Boolean erasmusStatus) {
        this.name = name;
        this.unit = unit;
        this.tryb = tryb;
        this.erasmusStatus = erasmusStatus;
        //this.course = course;
    }
    public Student(String name, StudentUnit unit, Long index, Tryb tryb, Boolean ErasmusStatus) {
        this.name = name;
        this.unit = unit;
        this.index = index;
        this.tryb = tryb;
        this.erasmusStatus = ErasmusStatus;
        //this.course = course;
    }

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private Boolean erasmusStatus;
    @Enumerated(EnumType.STRING)
    private StudentUnit unit;
    @Enumerated(EnumType.STRING)
    private Tryb tryb;
    @Enumerated(EnumType.STRING)
    @Setter
    private Long index;

}
