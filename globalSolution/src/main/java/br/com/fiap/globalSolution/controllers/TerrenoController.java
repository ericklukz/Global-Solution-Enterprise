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
import br.com.fiap.globalSolution.models.Terreno;
import br.com.fiap.globalSolution.models.Usuario;
import br.com.fiap.globalSolution.repository.TerrenoRepository;
import br.com.fiap.globalSolution.repository.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
public class TerrenoController {

    Logger log = LoggerFactory.getLogger(Terreno.class);

    @Autowired
    TerrenoRepository terrenoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/api/terrenos/")
    public Page<Terreno> show(@RequestParam(required = true) int idUsuario,@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable){
        var usuarioEncontrado = getUsuario(idUsuario);
        log.info("buscando terrenos para o usuário: " + usuarioEncontrado.getNome());
        return terrenoRepository.findByUsuario(usuarioEncontrado,pageable);
    }

    @PostMapping("/api/terrenos")
    public ResponseEntity<Terreno> create(@RequestBody @Valid Terreno terreno){
        log.info("cadastrando terrenos: " + terreno);
        terrenoRepository.save(terreno);
        return ResponseEntity.status(HttpStatus.CREATED).body(terreno);
    }

    @PutMapping("/api/terrenos/{id}")
    public ResponseEntity<Terreno> update(@PathVariable Integer id, @Valid @RequestBody Terreno terreno){
        log.info("atualizando terreno com id:" + id);
        getTerreno(id);
        terreno.setId(id);
        terrenoRepository.save(terreno);

        return ResponseEntity.status(HttpStatus.OK).body(terreno);
    }

    @DeleteMapping("/api/terrenos/{id}")
        public ResponseEntity<Terreno> destroy(@PathVariable Integer id){
            log.info("apagando terreno com id:" + id);
            var terreno = getTerreno(id);
            terrenoRepository.delete(terreno);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        private Terreno getTerreno(Integer id) {
            return terrenoRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Terreno não encontrado"));
        }

        private Usuario getUsuario(int id) {
            return usuarioRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Usuario não encontrada"));
        }
}