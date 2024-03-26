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

import application.model.Compromisso;
import application.repository.CompromissoRepository;

@RestController
public class CompromissoController {
    @Autowired
    private CompromissoRepository comproRepo;

    @GetMapping("/compromissos")
    public List<Compromisso> getCompromissos() {
        return (List<Compromisso>) comproRepo.findAll();
    }

    @GetMapping("/compromissos/{id}")
    public Compromisso getCompromissos(@PathVariable Long id){
        return comproRepo.findById(id).get();
    }

    @PostMapping("/compromissos")
    public Compromisso postCompromissos(@RequestBody Compromisso compromisso){
        return comproRepo.save(compromisso);
    }

    @PutMapping("/compromissos/{id}")
    public Compromisso putCompromisso(@RequestBody Compromisso compromisso, @PathVariable Long id){
        Compromisso resposta = comproRepo.findById(id).get();
        resposta.setDescricao(resposta.getDescricao());
        resposta.setDataInicio(resposta.getDataInicio());
        resposta.setDataFim(resposta.getDataFim());
        resposta.setHoraInicio(resposta.getHoraInicio());
        resposta.setHoraFim(resposta.getHoraFim());

        return comproRepo.save(resposta);
    }

    @DeleteMapping("/compromissos/{id}")
    public void deleteCompromisso(@PathVariable Long id){
        comproRepo.deleteById(id);
    }
}
