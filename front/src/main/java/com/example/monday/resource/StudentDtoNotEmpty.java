package com.example.monday.resource;

import com.example.monday.data.Tryb;
import com.example.monday.data.StudentUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDtoNotEmpty {
    private UUID id;
    private String name;
    private StudentUnit unit;
    private Tryb Tryb;
    private Boolean ErasmusStatus;
    private Long index;
}
