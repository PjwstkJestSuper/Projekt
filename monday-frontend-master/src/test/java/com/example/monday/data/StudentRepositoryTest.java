package com.example.monday.data;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** simple junit tests without mockito
 */
@Deprecated
class StudentRepositoryTest {

    @Test
    void shouldReturnMaxIndexWhenStudentListIsNotEmpty() {
        var studentRepository = new StudentDataComponent();
        var student = new Student("Karol", StudentUnit.GDANSK,Tryb.Staconajrny,true,new Course() ,1L);
        studentRepository.setStudents(List.of(student));

        var maxIndex = studentRepository.getMaxIndex();

        assertEquals(student.getIndex(), maxIndex);
    }

    @Test
    void shouldReturnZeroWhenStudentListNotEmpty() {
        var studentRepository = new StudentDataComponent();

        var maxIndex = studentRepository.getMaxIndex();

        assertEquals(0L, maxIndex);
    }
}
