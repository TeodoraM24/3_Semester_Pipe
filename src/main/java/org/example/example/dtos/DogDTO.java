package org.example.example.dtos;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DogDTO {
    private int id;
    private String name;
    private String breed;
    private Gender gender;
    private int age;


    public enum Gender {
        MALE, FEMALE
    }
}
