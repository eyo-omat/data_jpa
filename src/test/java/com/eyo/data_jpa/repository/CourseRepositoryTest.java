package com.eyo.data_jpa.repository;

import com.eyo.data_jpa.model.Course;
import com.eyo.data_jpa.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void getAllCourses() {
        List<Course> courses = courseRepository.findAll();

        System.out.println("Courses: " + courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Dape")
                .lastName("Ola")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(4)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
}