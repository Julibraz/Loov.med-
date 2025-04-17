package med.loov.api.controller;

import jakarta.validation.Valid;
import med.loov.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional //inicia uma transação automaticamente e garante commit ou rollback
    public void cadastrarPaciente(@RequestBody @Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {//Pageable serve para paginar as requsições, caso haja muitos dados
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaPaciente dados) {
        var paciente = repository.getReferenceById(dados.id()); //busca o id do paciente
        paciente.atualizaInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluiPaciente(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.excluiPaciente();
    }

}
