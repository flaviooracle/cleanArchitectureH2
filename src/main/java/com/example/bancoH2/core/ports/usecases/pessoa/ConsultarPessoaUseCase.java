package com.example.bancoH2.core.ports.usecases.pessoa;

import com.example.bancoH2.core.models.pessoa.Pessoa;
import com.example.bancoH2.core.ports.UseCase;
import com.example.bancoH2.core.ports.out.PessoaPort;
import com.example.bancoH2.core.ports.out.IConsultaPessoaUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@UseCase
@Component
public class ConsultarPessoaUseCase implements IConsultaPessoaUseCase {

    private final PessoaPort pessoaPort;

    public ConsultarPessoaUseCase(PessoaPort pessoaPort) {
        this.pessoaPort = pessoaPort;
    }


    @Override
    public Pessoa ConsultarPessoaUseCase(Long idPessoa) {
        return pessoaPort.ConsultarPessoaPorID(idPessoa);
    }

    public Page<Pessoa> ConsultarTodasPessoas(Pageable pageable, String orderBy, String filterNome, String filterCpf){

        // poderia utilizar o PageRequest nesse momento, e era só substituir como paramentro
        // só que já trago pronto da ontroller o pageable
        var direction = getDirection(orderBy);

        PageRequest pagerequest = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(),direction,"create_at");

        return pessoaPort.ConsultaTodasPessoas(pagerequest, orderBy, filterNome, filterCpf);
    }

    private Sort.Direction getDirection(String orderBy) {
        var direction = Sort.Direction.DESC;
        if(orderBy.equalsIgnoreCase("Asc")){
            direction = Sort.Direction.ASC;
        }
        return direction;
    }

}
