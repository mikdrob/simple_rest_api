package com.example.practice.api.dto.v1;

import com.example.practice.service.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
public class Person implements Serializable, BaseEntity<Person> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    @Type(type = "org.hibernate.type.StringType")
    @NotBlank(message = "Name is mandatory")
    @Size(min=3, max=30)
    private String name;
}
