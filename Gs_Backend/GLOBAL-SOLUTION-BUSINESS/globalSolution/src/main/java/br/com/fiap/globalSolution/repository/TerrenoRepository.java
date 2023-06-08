package br.com.fiap.globalSolution.repository;

import br.com.fiap.globalSolution.models.Terreno;
import br.com.fiap.globalSolution.models.Usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerrenoRepository extends JpaRepository<Terreno,Integer>{

    Page<Terreno> findByUsuario(Usuario usuario,Pageable pageable);
    
}