package com.example.monday.resource;

import com.example.monday.data.Course;
import com.example.monday.data.StudentUnit;
import com.example.monday.data.Tryb;

import java.util.UUID;

public record StudentDto(UUID id, String name, StudentUnit unit, Tryb tryb, Boolean erasmusStatus, Course course, Long index) {
}
