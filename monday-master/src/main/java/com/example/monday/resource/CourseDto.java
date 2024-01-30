package com.example.monday.resource;

import com.example.monday.data.StudentUnit;

import java.util.UUID;

public record CourseDto(UUID id, String name, StudentUnit unit, Long index,int minMean,String subject) {
}

