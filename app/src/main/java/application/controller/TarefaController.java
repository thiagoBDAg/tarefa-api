package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import application.model.Tarefa;
import application.repository.TarefaRepository;

@RestController
public class TarefaController {
    @Autowired
    private TarefaRepository tarefaRepo;
    
    @GetMapping("/tarefas")
    public List<Tarefa> getTarefas(){
        return (List<Tarefa>) tarefaRepo.findAll();
    }

    @GetMapping("/tarefas/{id}")
    public Tarefa getTarefa(@PathVariable Long id){
        return tarefaRepo.findById(id).get();
    }

    @PostMapping("/tarefas")
    public Tarefa postTarefa(@RequestBody Tarefa tarefa){
        return tarefaRepo.save(tarefa);
    }

    @PutMapping("/tarefas/{id}")
    public Tarefa putTarefas(@RequestBody Tarefa tarefa, @PathVariable Long id){
        Tarefa resposta = tarefaRepo.findById(id).get();
        resposta.setDescricao(tarefa.getDescricao());
        resposta.setConcluido(tarefa.isConcluido());

        return tarefaRepo.save(resposta);
    }

    @DeleteMapping("/tarefas/{id}")
    public void deleteTarefas(@PathVariable Long id){
        tarefaRepo.deleteById(id);
    }
}
