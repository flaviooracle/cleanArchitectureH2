package com.example.bancoH2.core.ports.out;

import com.example.bancoH2.adapters.in.web.dto.pessoa.PessoaDtoRequest;
import com.example.bancoH2.core.models.pessoa.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface PessoaPort {

    Pessoa CadastrarPessoa(Pessoa pessoaModel);
    Page<Pessoa> ConsultaTodasPessoas(PageRequest pagerequest, String orderBy, String filterNome, String filterCpf);
    Pessoa ConsultarPessoaPorID(Long idPessoa);
    Pessoa AtualizarPessoa(Long idPessoa, PessoaDtoRequest pessoaDtoRequest);

}
