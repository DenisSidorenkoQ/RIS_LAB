package com.example.entity;

import lombok.Data;

import javax.persistence.*;

import javax.validation.Constraint;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "citizenship")
@Data
public class Citizenship {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    @Column(unique = true)
    private String name;
}
