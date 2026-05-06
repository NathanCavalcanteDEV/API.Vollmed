package API.Rest.da.aplicacao.Voll.med.controller;

import API.Rest.da.aplicacao.Voll.med.paciente.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(page = 0, size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void remover(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.inativar();

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoPaciente dados) {
        var paciente = repository.getReferenceById(id);
        paciente.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }
}

