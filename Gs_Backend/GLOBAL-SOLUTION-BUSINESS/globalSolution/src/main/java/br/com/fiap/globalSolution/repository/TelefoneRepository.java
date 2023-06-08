package br.com.fiap.globalSolution.repository;

import br.com.fiap.globalSolution.models.Telefone;
import br.com.fiap.globalSolution.models.Usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone,Integer>{

    Page<Telefone> findByUsuario(Usuario usuario,Pageable pageable);
    
}