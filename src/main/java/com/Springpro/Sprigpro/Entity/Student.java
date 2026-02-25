package com.Springpro.Sprigpro.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "Studnet_DB")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;


    @Column(name = "Mark")
    private Integer mark;

    @Column(name = "NAME")
    private String name;

}
