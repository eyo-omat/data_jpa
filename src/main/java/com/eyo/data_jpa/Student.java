package com.eyo.data_jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity(name = "Student")
public class Student {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
}
