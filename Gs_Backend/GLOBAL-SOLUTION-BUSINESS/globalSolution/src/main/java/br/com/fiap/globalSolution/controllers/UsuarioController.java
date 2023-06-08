package br.com.fiap.globalSolution.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.fiap.globalSolution.exception.RestNotFoundException;
import br.com.fiap.globalSolution.models.Credencial;
import br.com.fiap.globalSolution.models.Usuario;
import br.com.fiap.globalSolution.repository.UsuarioRepository;
import br.com.fiap.globalSolution.service.TokenService;
import jakarta.validation.Valid;

// update

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
public class UsuarioController {

    Logger log = LoggerFactory.getLogger(Usuario.class);

    @Autowired
    UsuarioRepository repository; 

    @Autowired
    TokenService tokenService;
    
    //implementaçõs de Security

    @Autowired
    AuthenticationManager manager;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/api/usuarios/login")
    public ResponseEntity<Object> login(@RequestBody @Valid Credencial credencial){
        manager.authenticate(credencial.toAuthentication());

        var token = tokenService.generateToken(credencial);
        return ResponseEntity.ok(token);
    }

    //end
    
    @GetMapping("/api/usuarios")
    public Page<Usuario> index(@PageableDefault(size= 100,sort = {"nome"}) Pageable pageable){
        return repository.findAll(pageable);
    }

    @GetMapping("/api/usuarios/{id}")
    public ResponseEntity<Usuario> show(@PathVariable int id){
        log.info("buscando usuario com id:" + id);
        var usuarioEncontrado = getUsuario(id);
        return ResponseEntity.ok(usuarioEncontrado);
    }

    @PostMapping("/api/usuarios")
    public ResponseEntity<Usuario> create(@RequestBody @Valid Usuario usuario){
        log.info("cadastrando usuario: " + usuario);
        usuario.setSenha(encoder.encode(usuario.getSenha()));

        repository.save(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PutMapping("/api/usuarios/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody @Valid Usuario usuario){
        log.info("atualizando usuario com id:" + id);
        getUsuario(id);

        usuario.setId(id);
        repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/api/usuarios/{id}")
        public ResponseEntity<Usuario> destroy(@PathVariable Integer id){
            log.info("apagando usuario com id:" + id);
            var usuario = getUsuario(id);
            repository.delete(usuario);
            return ResponseEntity.noContent().build();
        }

    private Usuario getUsuario(int id) {
        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Usuario não encontrada"));
    }
}
