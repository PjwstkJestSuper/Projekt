package com.example.monday.resource;

import com.example.monday.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/students-page")
@RequiredArgsConstructor
public class StudentPageController {

    private final StudentService studentService;

    @GetMapping
    public String returnStudentsPage(Model model) {
        var students = studentService.getAll();
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping("/add")
    public String displayAddStudentPage(Model model) {
        model.addAttribute("student", new CreateStudent());
        return "addStudent";
    }

    @PostMapping
    public String saveStudent(@ModelAttribute CreateStudent createStudent) {
        studentService.saveStudent(createStudent);
        return "redirect:/students-page";
    }

    @GetMapping("/byTryb")
    public String getStudentsByTryb(Model model){
        model.addAttribute("studenciTrybData", new StudentDtoTryb());
        return "byTryb";
    }

    @PostMapping("/byTryb")
    public String getStudentsByTrybSecond(Model model, @ModelAttribute StudentDto studentDto){
        var listaStudentow = studentService.getStudentsByTryb(studentDto.Tryb());
        model.addAttribute("studenciTryb", listaStudentow);
        return "byTryb";
    }

    @GetMapping("/byErasmusStatus")
    public String getStudentsByErasmusStatus(Model model){
        model.addAttribute("studenciErasmusStatusData", new StudentDtoErasmusStatus());
        return "byErasmusStatus";
    }

    @PostMapping("/byErasmusStatus")
    public String getStudentsByErasmusStatusSecond(Model model, @ModelAttribute StudentDto studentDto){
        var listaStudentow = studentService.getStudentsByErasmusStatus(studentDto.ErasmusStatus());
        model.addAttribute("studenciErasmusStatus", listaStudentow);
        return "byErasmusStatus";
    }

    @GetMapping("/searchStudent")
    public String showEditStudentForm(Model model) {
        model.addAttribute("studentSearchData", new StudentDtoNotEmpty()); // Pusty obiekt DTO do wyszukiwania
        return "searchStudent";
    }

    @GetMapping("/editStudent")
    public String editStudentForm(Model model, @RequestParam Long index) {
        StudentDto student = studentService.getStudentByIndex(index);
        if(student == null) {
            return "student not found";
        }
        model.addAttribute("studentData", student);
        return "editStudent";
    }

    @PostMapping("/editStudent")
    public String editStudentFormSecond(@ModelAttribute("studentData") StudentDto studentDto) {
        studentService.updateStudent(studentDto);
        return "redirect:/students-page";
    }


}
