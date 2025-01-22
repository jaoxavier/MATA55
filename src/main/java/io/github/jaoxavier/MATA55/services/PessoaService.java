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
            List<Socios> socios = gerarSocios(dto);

            Juridica juridica = geraPessoaJuridica(dto);
            juridica.setSocios(socios);
            juridica.getEnderecos().add(endereco);

            return pessoaRepository.save(juridica);
        }

        Fisica fisica = geraPessoaFisica(dto);
        fisica.getEnderecos().add(endereco);

        return pessoaRepository.save(fisica);
    }


    private Fisica geraPessoaFisica(PessoaTO dto) {
        Fisica fisica = new Fisica();
        fisica.setNome(dto.getNome());
        fisica.setDataCadastro(LocalDateTime.now());
        fisica.setStatus(true);
        fisica.setContato(dto.getContatos());

        fisica.setNomeSocial(dto.getNome_social_ou_fantasia());
        fisica.setCpf(dto.getCpf_cnpj());
        fisica.setEstadoCivil(dto.getEstadoCivil());
        fisica.setDataNascimento(dto.getData_nascimento_ou_criacao());
        fisica.setProfissao(dto.getProfissao());
        fisica.setEscolaridade(dto.getEscolaridade());
        fisica.setRenda(dto.getRenda());
        fisica.setFiliacao(dto.getFiliacao());
        fisica.setNaturalidade(dto.getNaturalidade());

        return fisica;
    }

    private Juridica geraPessoaJuridica(PessoaTO dto) {
        Juridica juridica = new Juridica();

        juridica.setNome(dto.getNome());
        juridica.setDataCadastro(LocalDateTime.now());
        juridica.setStatus(true);


        juridica.setNomeFantasia(dto.getNome_social_ou_fantasia());
        juridica.setCnpj(dto.getCpf_cnpj());
        juridica.setDataAbertura(dto.getData_nascimento_ou_criacao());
        juridica.setCnae(dto.getCnae());
        juridica.setInscricaoEstadual(dto.getInscricao_estadual());
        juridica.setLucrativo(dto.isLucrativo());
        juridica.setTipoTributario(dto.getTipoTributario());
        juridica.setFaturamento(dto.getFaturamento());

        return juridica;
    }

    private List<Socios> gerarSocios(PessoaTO dto) {
        if (dto.getSocios().isEmpty())
        {
            return List.of();
        }

        List<Socios> socios = new ArrayList<>();

        for (SociosTO socio : dto.getSocios())
        {
            Pessoa pessoa = buscarPessoaPeloId(socio.getPessoa_id());
            Socios socioTemp = new Socios();
            socioTemp.setPessoa(pessoa);
            socioTemp.setCota(socio.getCota());
            socios.add(socioTemp);
        }

        return socios;
    }


    public Pessoa buscarPessoaPeloId(Integer id)
    {
        return this.pessoaRepository.findById(id).orElseThrow(
                () -> new PessoaNaoEncontradaException("Não foi possível encontra pessoa com esse ID")
        );
    }
}
