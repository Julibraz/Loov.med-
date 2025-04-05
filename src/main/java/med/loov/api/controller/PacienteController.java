package med.loov.api.controller;

import jakarta.validation.Valid;
import med.loov.api.paciente.DadosCadastroPaciente;
import med.loov.api.paciente.DadosListagemPaciente;
import med.loov.api.paciente.Paciente;
import med.loov.api.paciente.PacienteRepository;
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
        return repository.findAll(paginacao).map(DadosListagemPaciente::new);
    }
}
