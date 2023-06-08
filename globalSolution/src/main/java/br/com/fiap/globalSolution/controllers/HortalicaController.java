package br.com.fiap.globalSolution.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.globalSolution.exception.RestNotFoundException;
import br.com.fiap.globalSolution.models.Hortalica;
import br.com.fiap.globalSolution.repository.HortalicaRepository;
import jakarta.validation.Valid;

@RestController
public class HortalicaController {

    Logger log = LoggerFactory.getLogger(Hortalica.class);

    @Autowired
    HortalicaRepository repository; 
    
    @GetMapping("/api/hortalicas/")
    public Page<Hortalica> index(@RequestParam(required = false) String nome,@PageableDefault(sort = {"nome"}) Pageable pageable){
        if(nome == null)
            return repository.findAll(pageable);
        
        return repository.findByNomeContaining(nome, pageable);
    }

    @GetMapping("/api/hortalicas/inicio")
    public Hortalica getHortalicaByMesInicio(@RequestParam(required = false) String mesInicio) {
        if (mesInicio == null)
        throw new IllegalArgumentException("O parâmetro 'mesInicio' é obrigatório.");

        return repository.findByMesInicio(mesInicio);
    }

    @GetMapping("/api/hortalicas/fim/")
    public Hortalica getHortalicaByMesFim(@RequestParam(required = false) String mesFim) {
        if (mesFim == null)
        throw new IllegalArgumentException("O parâmetro 'mesFim' é obrigatório.");

        return repository.findByMesFim(mesFim);
    }

    @GetMapping("/api/hortalicas/{id}")
    public ResponseEntity<Hortalica> show(@PathVariable int id){
        log.info("buscando hortalica com id:" + id);
        var hortalicaEncontrado = getHortalica(id);
        return ResponseEntity.ok(hortalicaEncontrado);
    }

    @PostMapping("/api/hortalicas")
    public ResponseEntity<Hortalica> create(@RequestBody @Valid Hortalica hortalica){
        log.info("cadastrando hortalica: " + hortalica);

        repository.save(hortalica);

        return ResponseEntity.status(HttpStatus.CREATED).body(hortalica);
    }

    @PutMapping("/api/hortalicas/{id}")
    public ResponseEntity<Hortalica> update(@PathVariable Integer id, @RequestBody @Valid Hortalica hortalica){
        log.info("atualizando hortalicas com id:" + id);
        getHortalica(id);

        hortalica.setId(id);
        repository.save(hortalica);
        return ResponseEntity.ok(hortalica);
    }

    @DeleteMapping("/api/hortalicas/{id}")
        public ResponseEntity<Hortalica> destroy(@PathVariable Integer id){
            log.info("apagando hortalica com id:" + id);
            var hortalica = getHortalica(id);
            repository.delete(hortalica);
            return ResponseEntity.noContent().build();
        }

    private Hortalica getHortalica(int id) {
        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Hortalica não encontrada"));
    }
}
