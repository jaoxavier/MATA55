package io.github.jaoxavier.MATA55.domain.entity;

import io.github.jaoxavier.MATA55.rest.dto.PessoaTO;
import io.github.jaoxavier.MATA55.services.EnderecoService;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity // Define que é uma entidade que será criada no Banco de Dados em Memória
@Setter
@Getter // Cria os Getter's e Setter's automaticamente, porém os que precisarem de regras de negócio, serão criados manualmente
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Define que tudo ficará em uma só tabela
@DiscriminatorColumn(
        name = "tipo",
        discriminatorType = DiscriminatorType.STRING
) // Define como será descrito pelas outras entidades
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Definimos o ID único e como será gerado, por ser um banco em memória, usamos AUTO que ele criará automaticamente, se formos usar Banco de Dados real, será IDENTITY
    private Integer id;

    private String nome;

    @OneToMany(
            mappedBy = "pessoa",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Contato> contato = new ArrayList<>();

    private LocalDateTime dataCadastro;

    private boolean status;

    @OneToMany(
            mappedBy = "pessoa",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Endereco> enderecos = new ArrayList<>();

    public abstract String validarDocumento(String documento);

    public abstract Pessoa criar(PessoaTO pessoa);
}
