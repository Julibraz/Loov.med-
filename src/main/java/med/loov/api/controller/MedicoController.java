package med.loov.api.controller;

import jakarta.validation.Valid;
import med.loov.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){ //Pageable serve para paginar as requsições, caso haja muitos dados
        return repository.findAllByAtivo(paginacao).map(DadosListagemMedico::new); //map transforma o objeto Medico em DadosListagemMedico
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaMedico dados) {
        var medico = repository.getReferenceById(dados.id()); //busca o id do medico
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }

}
