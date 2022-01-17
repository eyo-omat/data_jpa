package com.eyo.data_jpa.repository;

import com.eyo.data_jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    List<Student> findByFirstNameAndLastName(String fName, String lName);

    @Query("select s from Student s where s.email = ?1")
    Optional<Student> findByEmail(String email);

    @Query("select s.firstName from Student s where s.email = ?1")
    String getStudentFirstNameByEmail(String email);

    //Native Query
    @Query(
            value = "select * from student s where s.email = ?1",
            nativeQuery = true
    )
    Student getStudentByEmail(String email);

    //Native Named Param
    @Query(
            value = "select * from student s where s.email = :email",
            nativeQuery = true
    )
    Student getStudentByEmailNameParams(@Param("email") String email);

    @Modifying
    @Transactional
    @Query(
            value = "update student set first_name = :firstName where email = :email",
            nativeQuery = true
    )
    int updateStudentNameByEmail(String firstName, String email);
}
