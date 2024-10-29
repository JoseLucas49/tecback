package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.dto.GeneroDTO;
import br.com.fujideia.iesp.tecback.service.GeneroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/generos")
@RequiredArgsConstructor
@Slf4j
public class GeneroController {

    private final GeneroService generoService;

    @GetMapping
    public List<GeneroDTO> listarTodos() {
        log.info("Chamara a lista de todos os generos");
        return generoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneroDTO> buscarPorId(@PathVariable long id) {
        log.info("Chamando buscarPorId no GeneroController com base no nome: {}", id);
        Optional<GeneroDTO> genero = GeneroService.buscarPorId(id);
        return genero.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GeneroDTO> criarGenero(@RequestBody GeneroDTO generoDTO) {
        log.info("Chamando criarGenero no GeneroController com dados: {}", generoDTO);
        GeneroDTO novoGenero = generoService.criarGenero(generoDTO);
        return ResponseEntity.ok(novoGenero);

        @PutMapping("/{id}")
        public ResponseEntity<GeneroDTO> atualizarGenero(@PathVariable Long id, @RequestBody GeneroDTO Detalhes) {
            Optional<GeneroDTO> generoAtualizado = generoService.atualizarGenero(id, Detalhes);
            return generoAtualizado.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<GeneroDTO> deletarGenero(@PathVariable long id) {
        boolean deletado = generoService.deletarGenero(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}