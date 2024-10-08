package org.example.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.example.example.dtos.DogDTO;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dog {
    @Id
    private int id;
        private String name;
        private String breed;
        private DogDTO.Gender gender;
        private int age;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
