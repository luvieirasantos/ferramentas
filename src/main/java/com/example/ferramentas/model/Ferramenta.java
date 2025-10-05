package com.example.ferramentas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "TDS_Sec_MVC_TB_Ferramentas")
public class Ferramenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String tipo;
    private String descricao;
    private double preco;
}

