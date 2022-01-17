package com.eyo.data_jpa.model;

import lombok.*;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Builder
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardian_name", nullable = false, columnDefinition = "TEXT")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email", nullable = false, columnDefinition = "TEXT")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardian_mobile", nullable = false, columnDefinition = "TEXT")
        )
})
public class Guardian {

    private String name;

    private String email;

    private String mobile;
}
