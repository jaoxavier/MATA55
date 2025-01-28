package io.github.jaoxavier.MATA55.services;

import io.github.jaoxavier.MATA55.domain.entity.*;
import io.github.jaoxavier.MATA55.domain.repository.PessoaRepository;
import io.github.jaoxavier.MATA55.exception.ContatosNaoPodemEstarVazioException;
import io.github.jaoxavier.MATA55.exception.PessoaNaoEncontradaException;
import io.github.jaoxavier.MATA55.rest.dto.ContatoTO;
import io.github.jaoxavier.MATA55.rest.dto.FiliacaoTO;
import io.github.jaoxavier.MATA55.rest.dto.PessoaTO;
import io.github.jaoxavier.MATA55.rest.dto.SociosTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoService enderecoService;

    public Pessoa criarPessoa(PessoaTO dto)
    {
        Endereco endereco = new Endereco();
        endereco.criar(dto.getEnderecoTO());

        Contato contato = new Contato();
        contato.gerarContato(dto.getContatos());

        if (dto.getComum().isTipoPessoaJuridica())
        {
            Socios socios = new Socios();
            socios.gerarSociedade(dto.getSocios());

            Juridica juridica = new Juridica();
            juridica.criar(dto);

            return pessoaRepository.save(juridica);
        }

        //TODO FAZER AS ASSOCIAÇÕES

        Fisica fisica = new Fisica();
        fisica.criar(dto);
        return pessoaRepository.save(fisica);
    }

    public Pessoa buscarPessoaPeloId(Integer id)
    {
        return this.pessoaRepository.findById(id).orElseThrow(
                () -> new PessoaNaoEncontradaException("Não foi possível encontra pessoa com esse ID")
        );
    }
}
