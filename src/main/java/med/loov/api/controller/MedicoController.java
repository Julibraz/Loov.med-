package med.loov.api.controller;

import jakarta.validation.Valid;
import med.loov.api.medico.DadosCadastroMedico;
import med.loov.api.medico.Medico;
import med.loov.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    //FAZ UMA REQUISIÇÃO DO TIPO POST, QUE RECEBE INFORMAÇÕES PARA SEREM CADASTRADAS
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){ //@requestbody, puxa as informações do corpo do json da requisição
        repository.save(new Medico(dados));
    }

}
