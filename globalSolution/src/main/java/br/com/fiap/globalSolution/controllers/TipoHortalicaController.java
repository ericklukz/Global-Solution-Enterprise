package br.com.fiap.globalSolution.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.globalSolution.exception.RestNotFoundException;
import br.com.fiap.globalSolution.models.TipoHortalica;
import br.com.fiap.globalSolution.repository.TipoHortalicaRepository;
import jakarta.validation.Valid;

import java.util.List;

@RestController
public class TipoHortalicaController {

    Logger log = LoggerFactory.getLogger(TipoHortalica.class);

    @Autowired
    TipoHortalicaRepository repository; 
    
    @GetMapping("/api/tipohortalicas")
    public List<TipoHortalica> index(@PageableDefault(sort = {"nome"})Pageable pageable){
        return repository.findAll();
    }

    @GetMapping("/api/tipohortalicas/{id}")
    public ResponseEntity<TipoHortalica> show(@PathVariable int id){
        log.info("buscando tipo de hortalica com id:" + id);
        var tipohortalicaEncontrado = getTipoHortalica(id);
        return ResponseEntity.ok(tipohortalicaEncontrado);
    }

    @PostMapping("/api/tipohortalicas")
    public ResponseEntity<TipoHortalica> create(@RequestBody @Valid TipoHortalica tipoHortalica){
        log.info("cadastrando um tipo de hortalica: " + tipoHortalica);

        repository.save(tipoHortalica);

        return ResponseEntity.status(HttpStatus.CREATED).body(tipoHortalica);
    }

    @PutMapping("/api/tipohortalicas/{id}")
    public ResponseEntity<TipoHortalica> update(@PathVariable Integer id, @RequestBody @Valid TipoHortalica tipoHortalica){
        log.info("atualizando um tipo de hortalica com id:" + id);
        getTipoHortalica(id);

        tipoHortalica.setId(id);
        repository.save(tipoHortalica);
        return ResponseEntity.ok(tipoHortalica);
    }

    @DeleteMapping("/api/tipohortalicas/{id}")
        public ResponseEntity<TipoHortalica> destroy(@PathVariable Integer id){
            log.info("apagando um tipo de hortalica com id:" + id);
            var tipoHortalica = getTipoHortalica(id);
            repository.delete(tipoHortalica);
            return ResponseEntity.noContent().build();
        }

    private TipoHortalica getTipoHortalica(int id) {
        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("despesa não encontrada"));
    }
}
