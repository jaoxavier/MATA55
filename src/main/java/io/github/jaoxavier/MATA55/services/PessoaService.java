package io.github.jaoxavier.MATA55.services;

import io.github.jaoxavier.MATA55.domain.entity.*;
import io.github.jaoxavier.MATA55.domain.repository.PessoaRepository;
import io.github.jaoxavier.MATA55.exception.PessoaNaoEncontradaException;
import io.github.jaoxavier.MATA55.rest.dto.ContatoTO;
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
        Endereco endereco = enderecoService.criarEndereco(dto.getEnderecoTO());


        if (dto.isTipoPessoaJuridica()) // PJ
        {
            Juridica juridica = new Juridica();
            juridica.setNome(dto.getNome());
            juridica.setDataCadastro(LocalDateTime.now());
            juridica.setStatus(true);

            for (ContatoTO contato : dto.getContatos())
            {
                Contato ctt = new Contato();
                ctt.setEmail(contato.getEmail());
                ctt.setTelefone(contato.getTelefone());
                juridica.getContato().add(ctt);
            }


            juridica.setNomeFantasia(dto.getNome_social_ou_fantasia());
            juridica.setCnpj(dto.getCpf_cnpj());
            juridica.setDataAbertura(dto.getData_nascimento_ou_criacao());
            juridica.setCnae(dto.getCnae());
            juridica.setInscricaoEstadual(dto.getInscricao_estadual());
            juridica.setLucrativo(dto.isLucrativo());
            juridica.setTipoTributario(dto.getTipoTributario());
            juridica.setFaturamento(dto.getFaturamento());

            for (SociosTO socio : dto.getSocios())
            {
                Pessoa pessoa = buscarPessoaPeloId(socio.getPessoa_id());
                Socios socios = new Socios();
                socios.setPessoa(pessoa);
                socios.setCota(socio.getCota());
                juridica.getSocios().add(socios);
            }

            juridica.getEnderecos().add(endereco);

            return pessoaRepository.save(juridica);
        }

        Fisica fisica = new Fisica();
        fisica.setNome(dto.getNome());
        fisica.setDataCadastro(LocalDateTime.now());
        fisica.setStatus(true);

        for (ContatoTO contato : dto.getContatos())
        {
            Contato ctt = new Contato();
            ctt.setEmail(contato.getEmail());
            ctt.setTelefone(contato.getTelefone());
            fisica.getContato().add(ctt);
        }

        fisica.setNomeSocial(dto.getNome_social_ou_fantasia());
        fisica.setCpf(dto.getCpf_cnpj());
        fisica.setEstadoCivil(dto.getEstadoCivil());
        fisica.setDataNascimento(dto.getData_nascimento_ou_criacao());
        fisica.setProfissao(dto.getProfissao());
        fisica.setEscolaridade(dto.getEscolaridade());
        fisica.setRenda(dto.getRenda());
        fisica.setMae(dto.getMae());
        fisica.setPai(dto.getPai());
        fisica.setNaturalidade(dto.getNaturalidade());

        fisica.getEnderecos().add(endereco);

        return pessoaRepository.save(fisica);
    }

    public Pessoa buscarPessoaPeloId(Integer id)
    {
        return this.pessoaRepository.findById(id).orElseThrow(
                () -> new PessoaNaoEncontradaException("Não foi possível encontra pessoa com esse ID")
        );
    }
}
