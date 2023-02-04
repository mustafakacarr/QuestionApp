package com.project.questionapp.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data //for auto getter ve setter implementation
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String username;
    String password;

}
