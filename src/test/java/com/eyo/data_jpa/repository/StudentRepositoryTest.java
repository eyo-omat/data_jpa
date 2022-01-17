package com.eyo.data_jpa.repository;

import com.eyo.data_jpa.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .firstName("Kojo")
                .lastName("duncan")
                .email("kjk@mail.com")
                .age(76)
                .guardianName("Thanos")
                .guardianEmail("snap@mail.com")
                .guardianMobile("0.5")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void getAllStudents() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("Student List: " + studentList);
    }
}