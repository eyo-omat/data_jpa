package com.eyo.data_jpa.model;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "student", uniqueConstraints = {@UniqueConstraint(name = "student_email_unique", columnNames = "email")})
@Entity(name = "Student")
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_sequence"

    )
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
    @NonNull
    private String firstName;

    @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
    @NonNull
    private String lastName;

    @Column(name = "email", nullable = false, columnDefinition = "TEXT")
    @NonNull
    private String email;

    @Column(name = "age", nullable = false)
    @NonNull
    private Integer age;

    @Column(name = "guardian_name", nullable = false, columnDefinition = "TEXT")
    @NonNull
    private String guardianName;

    @Column(name = "guardian_email", nullable = false, columnDefinition = "TEXT")
    @NonNull
    private String guardianEmail;

    @Column(name = "guardian_mobile", nullable = false, columnDefinition = "TEXT")
    @NonNull
    private String guardianMobile;
}
