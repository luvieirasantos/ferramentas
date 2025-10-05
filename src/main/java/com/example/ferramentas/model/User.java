package com.example.ferramentas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "TDS_Users_Ferramentas")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String role; // e.g., USER, ADMIN
}

