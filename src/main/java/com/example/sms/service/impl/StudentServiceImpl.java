package com.example.sms.service.impl;

import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;
import com.example.sms.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Student Implementation Class - Make sure to add Service Annotation to this type of class
@Service
public class StudentServiceImpl implements StudentService {

    // Inject Dependency as Constructor Based
    private StudentRepository studentRepository ;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        // Return a list of Students
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

}
