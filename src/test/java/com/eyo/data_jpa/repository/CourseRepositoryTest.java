package com.eyo.data_jpa.repository;

import com.eyo.data_jpa.model.Course;
import com.eyo.data_jpa.model.Student;
import com.eyo.data_jpa.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    public void findAllPagination() {
        PageRequest firstPageWithThreeRecords = PageRequest.of(0, 3);
        PageRequest secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();

        long pages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("Total Elements: " + totalElements);
        System.out.println("Total Pages: " + pages);
        System.out.println("Courses: " + courses);

    }

    @Test
    public void findAllSorting() {
        PageRequest sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        PageRequest sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
        PageRequest sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("Courses: " + courses);

    }

    @Test
    public void getByTitleContaining() {
        Pageable firstPageTEnRecords = PageRequest.of(0, 10);

        List<Course> courses = courseRepository.findByTitleContaining("I", firstPageTEnRecords).getContent();

        System.out.println("Courses: " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Kudu")
                .lastName("Jaw")
                .build();

        Student student = Student.builder()
                .firstName("ifuk")
                .lastName("Julson")
                .email("bula@mail")
                .age(36)
                .build();

        Course course = Course.builder()
                .title("Java")
                .credit(9)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}