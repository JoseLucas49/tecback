package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Ator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AtorRepository extends JpaRepository<Ator, Long> {
    @Query("SELECT a FROM Ator Where a.nome Like %:nome%")
    List<Ator> procurarPorNome(@Param("nome") String nome);

    @Query("SELECT a FORM Ator a WHERE a,id Like %:nome%")
    List<Ator> buscarPorIdade(@Param("Id") Long id);

    Optional<Object> findByNome(String nome);
}
