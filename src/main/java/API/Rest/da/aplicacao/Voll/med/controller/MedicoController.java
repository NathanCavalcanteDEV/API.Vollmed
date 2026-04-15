package API.Rest.da.aplicacao.Voll.med.controller;


import API.Rest.da.aplicacao.Voll.med.medico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// criando as requests e chamando pelas anotações
@RestController
@RequestMapping ("medicos")

public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    //chamando o json no insominia
    //@RequestBody é pra puxar do corpo da requisição
    // DadosCadastroMedicos é um DTO padrao utlizados em api para representar os dados que chegam e devolvem da api
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicos dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);

        }

    @PutMapping
    @Transactional
    public void autualizar (@RequestBody @Valid DadosAtualizacaoMedicos dados) {
    var medico = repository.getReferenceById(dados.id());
    medico.atualizarInformacoes(dados);

        }
    @DeleteMapping ("/{id}")
    @Transactional
    public void excluir (@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();


    }



    }




