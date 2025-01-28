package io.github.jaoxavier.MATA55.rest.controller;

import io.github.jaoxavier.MATA55.domain.entity.Pessoa;
import io.github.jaoxavier.MATA55.rest.dto.PessoaTO;
import io.github.jaoxavier.MATA55.services.PessoaService;
import io.github.jaoxavier.MATA55.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/pessoas")
public class PessoaController
{
    @Autowired
    private MunicipioService municipioService;
    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public Pessoa createPessoa(@RequestBody PessoaTO pessoaTO)
    {
        return pessoaService.criarPessoa(pessoaTO);
    }

}
