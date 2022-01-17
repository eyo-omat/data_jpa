package com.eyo.data_jpa.repository;

import com.eyo.data_jpa.model.Course;
import com.eyo.data_jpa.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course course = Course.builder()
                .title("IT")
                .credit(10)
                .build();
        Course course2 = Course.builder()
                .title("science")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Austin")
                .lastName("Chuckwu")
                //.courses(List.of(course, course2))
                .build();

        teacherRepository.save(teacher);
    }
}