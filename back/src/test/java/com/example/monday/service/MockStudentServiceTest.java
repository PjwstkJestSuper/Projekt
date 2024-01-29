//package com.example.monday.service;
//
//import com.example.monday.data.*;
//import com.example.monday.resource.CreateStudent;
//import com.example.monday.resource.StudentDto;
//import com.example.monday.resource.StudentMapper;
//import com.example.monday.resource.StudentResource;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.InjectMocks;
//
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//
////Rozszerzamy junit rozszerzeniem z mockito, aby móc w junitowych testach korzystać z funkcji biblioteki mockito
//@ExtendWith(MockitoExtension.class)
//class MockStudentServiceTest {
//
//    @Mock
//    private StudentRepository studentRepository = mock(StudentRepository.class);
//
//    @Mock
//    private StudentMapper studentMapper = new StudentMapper();
//
//    @InjectMocks
//    private StudentService studentService;
//
//    @BeforeEach
//    void setUp() {
//        studentService = new StudentService(studentRepository, studentMapper);
//    }
//
//    @AfterEach
//    void cleanup() {
//        studentRepository.deleteAll();
//    }
//
//    @Test
//    void givenTrybWhenGetStudentsThenReturnListOfStudents() {
//
//        Tryb tryb = Tryb.Staconajrny;
//        Student student = new Student("Jakub", StudentUnit.GDANSK, 5L, Tryb.Staconajrny, true);
//        when(studentRepository.getStudentsByTryb(tryb)).thenReturn(Arrays.asList(student));
//
//        List<StudentDto> result = studentService.getStudentsByTryb(Tryb.Staconajrny);
//
//        assertFalse(result.isEmpty());
//        assertEquals(1, result.size());
//    }
//
//    @Test
//    void givenErasmusStatusWhenGetStudentsThenReturnListOfStudents() {
//        boolean ErasmusStatus = false;
//        Student student = new Student("Jakub", StudentUnit.GDANSK, Tryb.Staconajrny, true);
//        when(studentRepository.getStudentsByErasmusStatus(ErasmusStatus)).thenReturn(Arrays.asList(student));
//
//        List<StudentDto> result = studentService.getStudentsByErasmusStatus(ErasmusStatus);
//
//        assertFalse(result.isEmpty());
//        assertEquals(1, result.size());
//    }
//
//    @Test
//    void givenStudentDtoWithInvalidIndexWhenUpdateStudentThenThrowException() {
//
//        Long index = 5L;
//        StudentDto studentDto = new StudentDto(UUID.fromString("f0154237-c4fb-4219-af3d-c5e6e9d2bf00"),"Jakub", StudentUnit.GDANSK, Tryb.Staconajrny, true, index);
//
//        when(studentRepository.getStudentByIndex(index)).thenReturn(null);
//
//        Exception exception = assertThrows(RuntimeException.class, () -> {
//            studentService.updateStudent(studentDto);
//        });
//
//        String expectedMessage = "Student not found";
//        String actualMessage = exception.getMessage();
//
//        assertTrue(actualMessage.contains(expectedMessage));
//    }
//
//    @Test
//    void givenIndexWhenGetStudentThenReturnStudentDto() {
//        Long index = 5L;
//        Student student = new Student("Jakub", StudentUnit.GDANSK, index, Tryb.Staconajrny, true);
//        StudentDto studentDto = new StudentDto(UUID.fromString("e9234d34-76ca-48d8-8978-f901b8a1c0db"),"Jakub", StudentUnit.GDANSK, Tryb.Staconajrny, true, index);
//        when(studentRepository.getStudentByIndex(index)).thenReturn(student);
//        when(studentMapper.toDto(student)).thenReturn(studentDto);
//
//        StudentDto result = studentService.getStudentByIndex(index);
//
//        assertNotNull(result);
//        assertEquals(studentDto, result);
//    }
//
//    @Test
//    void whenGetAllThenReturnListOfAllStudents() {
//        Student student1 = new Student("Jakub", StudentUnit.GDANSK, 5L, Tryb.Staconajrny, true);
//        Student student2 = new Student("Zygfryd", StudentUnit.WARSZAWA, 6L, Tryb.Niestacjonarny, true);
//        StudentDto studentDto1 = new StudentDto(UUID.fromString("e7ef62ba-e9b2-4fcc-a6a3-6ac03b1f4bbc"),"Jakub", StudentUnit.GDANSK, Tryb.Staconajrny, true, 5L);
//        StudentDto studentDto2 = new StudentDto(UUID.fromString("b24d0839-7fba-4581-ad51-17766f932e10"),"Zygfryd", StudentUnit.WARSZAWA, Tryb.Niestacjonarny, false, 6L);
//
//        when(studentRepository.findAll()).thenReturn(Arrays.asList(student1, student2));
//        when(studentMapper.toDto(student1)).thenReturn(studentDto1);
//        when(studentMapper.toDto(student2)).thenReturn(studentDto2);
//
//        List<StudentDto> result = studentService.getAll();
//
//        assertNotNull(result);
//        assertEquals(2, result.size());
//        assertTrue(result.containsAll(Arrays.asList(studentDto1, studentDto2)));
//    }
//
//}


