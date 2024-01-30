package com.example.monday.resource;

import com.example.monday.data.Course;

public class CourseMapper {

    public CourseDto toDto(Course course) {
        return new CourseDto(
                course.getId(),
                course.getName(),
                course.getUnit(),
                course.getIndex(),
                course.getMinMean(),
                course.getSubject()
        );
    }

    public Course toEntity(CreateCourse createCourse) {
        return new Course(createCourse.getName(), createCourse.getSubject(),createCourse.getUnit(), createCourse.getMinMean());
    }
}
