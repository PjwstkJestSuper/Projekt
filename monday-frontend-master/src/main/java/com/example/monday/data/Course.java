package com.example.monday.data;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Course {

    public Course(String name, String subject, StudentUnit unit, int minMean) {
        this.name = name;
        this.subject = subject;
        this.unit = unit;
        this.minMean = minMean;
    }
    public Course(String name, StudentUnit unit, Long index, String subject, int minMean) {
        this.name = name;
        this.unit = unit;
        this.index = index;
        this.subject = subject;
        this.minMean = minMean;
    }

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String subject;
    private int minMean;
    @Enumerated(EnumType.STRING)
    private StudentUnit unit;
    @Setter
    private Long index;

}
