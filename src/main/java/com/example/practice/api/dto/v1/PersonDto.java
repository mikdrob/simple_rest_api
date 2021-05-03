package com.example.practice.api.dto.v1;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
public class PersonDto {

    @Lob
    @Size(min=3, max=30, message = "Length of the field should not exceed 30 characters")
    private String name;
}

