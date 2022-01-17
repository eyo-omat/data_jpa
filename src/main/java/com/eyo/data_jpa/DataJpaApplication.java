package com.eyo.data_jpa;

import com.eyo.data_jpa.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataJpaApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository repository) {
//        return args -> {
//            Student kojo = new Student(
//                    1L,
//                    "Kojo",
//                    "duncan",
//                    "kj@mail.com",
//                    76
//
//            );
////            Student eyo = new Student(
////                    "Eyo",
////                    LocalDate.of(1979, Month.AUGUST, 7),
////                    "eeyo@mail.com"
////
////            );
//            repository.save(kojo);
//
//        };
//    }
}
