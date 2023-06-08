package br.com.fiap.globalSolution.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.globalSolution.models.Hortalica;

public interface HortalicaRepository extends JpaRepository<Hortalica,Integer>{

    @Query("SELECT h FROM Hortalica h WHERE h.nome LIKE %:nome%")
    Page<Hortalica> findByNomeContaining(@Param("nome") String nome,Pageable pageable);

    @Query("SELECT h FROM Hortalica h WHERE h.mesInicio = :mesInicio")
    Hortalica findByMesInicio(@Param("mesInicio") String mesInicio);

    @Query("SELECT h FROM Hortalica h WHERE h.mesFim = :mesFim")
    Hortalica findByMesFim(@Param("mesFim") String mesFim);
    
}
