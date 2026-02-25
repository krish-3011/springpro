package com.Springpro.Sprigpro.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "password",nullable = false)
    private  String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

}
