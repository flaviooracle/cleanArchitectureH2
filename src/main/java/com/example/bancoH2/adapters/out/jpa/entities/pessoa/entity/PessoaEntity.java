package com.example.bancoH2.adapters.out.jpa.entities.pessoa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_pessoa")
@Entity
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pessoaId;

    @Column(name="nome", length = 30)
    //@NotEmpty(message = "Nome não pode ser nulo")
    private String nome;

    //@NotEmpty
    @Column(name="idade")
    private Long idade;

    //@CPF(message = "Informe um CPF valido")
    //@NotEmpty(message="CPF não pode ser nulo")
    @Column(name="cpf", length=11)
    private String cpf;

    @Column(name="create_at")
    private LocalDateTime createAt;
}
