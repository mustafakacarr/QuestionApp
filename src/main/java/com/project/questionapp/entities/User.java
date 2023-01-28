package com.project.questionapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data //for auto getter ve setter implementation
public class User {
    @Id
    long id;
    String username;
    String password;

}
