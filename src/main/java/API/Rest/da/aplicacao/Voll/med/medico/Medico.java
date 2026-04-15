package API.Rest.da.aplicacao.Voll.med.medico;

import API.Rest.da.aplicacao.Voll.med.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Table(name = "medicos"): define o nome da tabela no banco como medicos. Sem essa anotação, a tabela teria o mesmo nome da classe (Medico).
@Table(name = "medicos")
//@Entity: marca a classe como uma entidade gerenciada pelo JPA, ou seja, serão persistidos dados dela no banco.
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")

public class Medico {
/*@Id: indica que esse campo é a chave primária da tabela — o identificador único de cada registro.
    @GeneratedValue(strategy = GenerationType.IDENTITY): diz que o valor do id é gerado automaticamente pelo banco de dados, como um auto-incremento. */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
/*@Enumerated(EnumType.STRING): essa anotação serve para mapear um enum (tipo enumerado) para o banco de dados.
Isso indica que o valor será gravado como texto (uma string) no banco (por exemplo, "CARDIOLOGIA", "DERMATOLOGIA").
Sem isso, o JPA gravaria o enum como número (ordinal), o que costuma ser menos legível e seguro.*/

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
/*@Embedded: indica que o objeto Endereco não é uma entidade própria, mas seus campos serão "embedados" na tabela medicos.
Ou seja, os atributos de Endereco serão salvos como colunas dentro da tabela medicos, junto com nome, email, etc.
 Para isso funcionar, a classe Endereco precisa estar anotada com @Embeddable — aí o JPA sabe que ela é um componente a ser embutido.*/
    @Embedded
    private Endereco endereco;

    private Boolean ativo;


    public Medico(DadosCadastroMedicos dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.crm = dados.crm();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());



    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoMedicos dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.telefone() != null){
            this.telefone = dados.telefone();

        }
    if (dados.endereco() != null){
        this.endereco.atualizarInformacoes(dados.endereco());
    }



    }

    public void excluir() {

        this.ativo = false;
    }
}
