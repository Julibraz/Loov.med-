package med.loov.api.controller;

import jakarta.validation.Valid;
import med.loov.api.paciente.DadosCadastroPaciente;
import med.loov.api.paciente.Paciente;
import med.loov.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

}
