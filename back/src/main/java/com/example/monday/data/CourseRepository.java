package com.example.monday.data;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface CourseRepository extends CrudRepository<Course, UUID> {

    @Modifying
    @Transactional
    void deleteByName(String name);

    List<Course> getCoursesInUnit(String name, StudentUnit unit);

    List<Course> getAllByName(String name);

    List<Course> getAllBySubject (String subject);

    @Query("select s from Course s")
    List<Course> findAll();


    Course getCourseByIndex(Long index);

    default List<Course> getCoursesInGdansk(String name) {
        return getCoursesInUnit(name, StudentUnit.GDANSK);
    }
}
