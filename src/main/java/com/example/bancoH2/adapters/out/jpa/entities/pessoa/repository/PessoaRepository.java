package com.example.bancoH2.adapters.out.jpa.entities.pessoa.repository;

import com.example.bancoH2.adapters.out.jpa.entities.pessoa.entity.PessoaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
    // Métodos de consulta personalizados, se necessário


    @Query(value = "SELECT * FROM tb_pessoa",
            countQuery="SELECT * FROM tb_pessoa",
            nativeQuery = true)
    Page<PessoaEntity> findAll(PageRequest pagerequest);


    @Query(value = "SELECT * FROM tb_pessoa WHERE cpf = ?1",
            countQuery="SELECT * FROM tb_pessoa WHERE cpf = ?1",
            nativeQuery = true)
    Page<PessoaEntity> findByCpf(PageRequest pagerequest, String filterCpf);

    @Query(value = "SELECT * FROM tb_pessoa WHERE nome = ?1",
            countQuery="SELECT * FROM tb_pessoa WHERE nome = ?1",
            nativeQuery = true)
    Page<PessoaEntity> findByNome(PageRequest pagerequest, String filterNome);

    @Query(value = "SELECT * FROM tb_pessoa WHERE nome = ?1 AND cpf = ?2",
            countQuery="SELECT * FROM tb_pessoa WHERE nome = ?1 AND cpf = ?2",
            nativeQuery = true)
    Page<PessoaEntity> findByNomeAndCpf(String filterNome, String filterCpf, PageRequest pagerequest);
}
