//package com.example.monday.data;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@DataJpaTest //Startujemy kontekst do testów jpa
//class StudentRepositoryJpaTest {
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    @BeforeEach // uzupełniamy dane w bazie
//    void setUp() {
//        var student1 = new Student("Karola", StudentUnit.GDANSK,Tryb.Staconajrny,true);
//        var student2 = new Student("Aga", StudentUnit.WARSZAWA,Tryb.Niestacjonarny,false);
//        studentRepository.save(student1);
//        studentRepository.save(student2);
//    }
//
//    @Test
//    void givenStudents_whenGetMaxIndex_ThenReturnValidResult() {
//        var maxIndex = studentRepository.getMaxIndex();
//        assertTrue(maxIndex.isPresent());
//        assertEquals(20L, maxIndex.get());
//    }
//
//
//}
