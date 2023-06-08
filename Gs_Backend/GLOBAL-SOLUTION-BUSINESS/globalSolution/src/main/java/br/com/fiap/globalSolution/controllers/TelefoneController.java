package br.com.fiap.globalSolution.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import br.com.fiap.globalSolution.models.Telefone;
import br.com.fiap.globalSolution.models.Usuario;
import br.com.fiap.globalSolution.repository.TelefoneRepository;
import br.com.fiap.globalSolution.repository.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
public class TelefoneController {

    Logger log = LoggerFactory.getLogger(Telefone.class);

    @Autowired
    TelefoneRepository telefoneRepository;

    @Autowired
    UsuarioRepository usuarioRepository;
    
    @GetMapping("/api/telefones/")
    public Page<Telefone> show(@RequestParam(required = true) int idUsuario, @PageableDefault(sort = {"id"},direction = Sort.Direction.DESC)Pageable pageable){
        var  usuarioEncontrado = getUsuario(idUsuario);
        log.info("buscando telefone do usuário:" +  usuarioEncontrado.getNome());

        return telefoneRepository.findByUsuario(usuarioEncontrado, pageable);
    }

    @PostMapping("/api/telefones")
    public ResponseEntity<Telefone> create(@RequestBody @Valid Telefone telefone){
        log.info("cadastrando telefone: " + telefone);
        telefoneRepository.save(telefone);
        return ResponseEntity.status(HttpStatus.CREATED).body(telefone);
    }

    @PutMapping("/api/telefones/{id}")
    public ResponseEntity<Telefone> update(@PathVariable Integer id, @Valid @RequestBody Telefone telefone){
        log.info("atualizando telefone com id:" + id);

        telefone.setId(id);
        getTelefone(id);
        telefoneRepository.save(telefone);

        return ResponseEntity.status(HttpStatus.OK).body(telefone);
    }

    @DeleteMapping("/api/telefones/{id}")
        public ResponseEntity<Telefone> destroy(@PathVariable Integer id){
            log.info("apagando telefone com id:" + id);
            var telefone = getTelefone(id);
            telefoneRepository.delete(telefone);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

    private Telefone getTelefone(Integer id) {
        return telefoneRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Telefone não encontrado"));
    }

    private Usuario getUsuario(int id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Usuario não encontrada"));
    }
}