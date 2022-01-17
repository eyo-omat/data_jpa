package com.eyo.data_jpa.repository;

import com.eyo.data_jpa.model.Course;
import com.eyo.data_jpa.model.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder()
                .title("DATA")
                .credit(7)
                .build();

        CourseMaterial material = CourseMaterial.builder()
                .url("data.com")
                .course(course)
                .build();

        courseMaterialRepository.save(material);
    }

    @Test
    public void getAllCourses() {
        List<CourseMaterial> materials = courseMaterialRepository.findAll();

        System.out.println("Materials: " + materials);
    }
}