package com.eyo.data_jpa.repository;

import com.eyo.data_jpa.model.Guardian;
import com.eyo.data_jpa.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

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
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                        .name("Hulk")
                .email("gamma@mail.com")
                .mobile("8373")
                .build();

        Student student = Student.builder()
                .firstName("Jojo")
                .lastName("nuke")
                .email("joke@mail.com")
                .age(39)
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void getAllStudents() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("Student List: " + studentList);
    }

    @Test
    public void getStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("kojo");

        System.out.println("Student List: " + students);
    }

    @Test
    public void getStudentLikeName() {
        List<Student> students = studentRepository.findByFirstNameContaining("jo");

        System.out.println("Student List: " + students);
    }

    @Test
    public void getStudentByGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Thanos");

        System.out.println("Student List: " + students);
    }

    @Test
    public void getStudentByFirstNameAndLastName() {
        List<Student> students = studentRepository.findByFirstNameAndLastName("jojo", "nuke");

        System.out.println("Student List: " + students);
    }

    @Test
    public void getStudentByEmail() {
        Optional<Student> student = studentRepository.findByEmail("joke@mail.com");

        assert student.isPresent();
        System.out.println("Student List: " + student);
    }

    @Test
    public void getStudentFirstNameByEmail() {
        String studentFirstName = studentRepository.getStudentFirstNameByEmail("joke@mail.com");

        System.out.println("First Name: " + studentFirstName);
    }

    @Test
    public void getStudentByEmailNative() {
        Student student = studentRepository.getStudentByEmail("joke@mail.com");

        System.out.println("Student: " + student);
    }

    @Test
    public void getStudentByEmailNamedParam() {
        Student student = studentRepository.getStudentByEmail("joke@mail.com");

        System.out.println("Student: " + student);
    }

    @Test
    public void updateStudentFirstNameByEMail() {
        studentRepository.updateStudentNameByEmail("Eyo", "kj@mail.com");
    }
}