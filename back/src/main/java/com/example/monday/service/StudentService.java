package com.example.monday.service;

import com.example.monday.data.Tryb;
import com.example.monday.data.Student;
import com.example.monday.data.StudentRepository;
import com.example.monday.data.StudentUnit;
import com.example.monday.excetionhandler.RecordNotFoundException;
import com.example.monday.resource.CreateStudent;
import com.example.monday.resource.StudentDto;
import com.example.monday.resource.StudentMapper;
import com.example.monday.excetionhandler.InvalidStudentNameException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;


    public Student saveStudent(CreateStudent createStudent) {
        var toSave = studentMapper.toEntity(createStudent);
        var index = createIndex(createStudent.getUnit());
        toSave.setIndex(index);
        studentRepository.save(toSave);
        return toSave;
    }

    public StudentDto getStudentById(UUID id) {
        return studentRepository.findById(id)
                .map(studentMapper::toDto)
                .orElseThrow(() -> new RecordNotFoundException("Student with id " + id + " not found"));
    }

    public void deleteByName(String name){
        var studentsByName = studentRepository.getAllByName(name);
        if(studentsByName.isEmpty()) {
            throw new InvalidStudentNameException("Student with name=" + name + " not exists.");
        }
        studentRepository.deleteAll(studentsByName);
    }

    private Long createIndex(StudentUnit unit) {
        long maxIndex = studentRepository.getMaxIndex().orElse(0L);
        if(StudentUnit.GDANSK.equals(unit)) {
            return 5 + maxIndex;
        } else {
            return 10 * maxIndex;
        }
    }

    public List<StudentDto> getStudentsByName(String name) {
        return studentRepository.getFromGdanskByName(name)
                .stream()
                .map(studentMapper::toDto)
                .toList();
    }

    public List<StudentDto> getAll() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDto)
                .toList();
    }

    public List<StudentDto> getStudentsByTryb(Tryb Tryb) {
        return studentRepository.getStudentsByTryb(Tryb)
                .stream()
                .map(studentMapper::toDto)
                .toList();
    }

    public List<StudentDto> getStudentsByErasmusStatus(Boolean ErasmusStatus) {
        return studentRepository.getStudentsByErasmusStatus(ErasmusStatus)
                .stream()
                .map(studentMapper::toDto)
                .toList();
    }

    public StudentDto getStudentByIndex(Long index) {
        Student student = studentRepository.getStudentByIndex(index);
        if (student != null) {
            return studentMapper.toDto(student);
        } else {
            throw new RuntimeException("Student with id " + index + " not found");
        }
    }


    public StudentDto updateStudent(StudentDto studentDto) {
        Student student = studentRepository.getStudentByIndex(studentDto.index());
        if (student != null) {

            student.setName(studentDto.name());
            student.setUnit(studentDto.unit());
            student.setTryb(studentDto.Tryb());
            student.setErasmusStatus(studentDto.ErasmusStatus());

            student = studentRepository.save(student);

            return studentMapper.toDto(student);
        } else {
            throw new RuntimeException("Student not found");
        }
    }

}
