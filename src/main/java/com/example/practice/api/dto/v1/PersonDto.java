package com.example.practice.api.dto.v1;
import lombok.Data;
import javax.persistence.*;

@Data
public class PersonDto {

    @Lob
    private String name;
}

