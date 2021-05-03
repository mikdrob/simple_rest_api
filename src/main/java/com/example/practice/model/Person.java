package com.example.practice.model;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
public class Person implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    @Type(type = "org.hibernate.type.StringType")
    @NotBlank(message = "Name is mandatory")
    @Size(min=3, max=30, message = "Length of the field should not exceed 30 characters")
    private String name;
}

// @Max(value=, message = "Length of the field should not exceed 30 characters")