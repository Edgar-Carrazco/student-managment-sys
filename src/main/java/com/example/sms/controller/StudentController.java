package com.example.sms.controller;

import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

// Class to handle requests
@Controller
public class StudentController {

    // Constructor based Dependency Injection
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Handler method to handle student list and return the view
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students" , studentService.getAllStudents());
        return "students"; // Return this view ( Create in Template Resources )
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student(); // Empty Student Object to Hold Form Data
        model.addAttribute("student" , student);
        return "create_student"; // Return this view ( Create in Template )
    }

    @PostMapping("/students")
    // Bind Student Form Object to Student Entity
    public String saveStudent (@ModelAttribute("student") Student student ) {
        studentService.saveStudent(student);
        // send back to students page after adding student
        return "redirect:/students";
    }

    // Handle Update Request
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id , Model model) {
        model.addAttribute("student" , studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent( @PathVariable Long id,
                                 @ModelAttribute("student") Student student,
                                 Model model ) {
        // Get Student Information
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName()) ;
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        // Save Updated Values to Student Object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
