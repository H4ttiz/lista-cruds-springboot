package com.unicesumar.lista_cruds_springboot.livro.controller;

import com.unicesumar.lista_cruds_springboot.livro.model.LivroModel;
import com.unicesumar.lista_cruds_springboot.livro.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }
    @GetMapping
    public ResponseEntity<List<LivroModel>> listarTodos(){
        List<LivroModel> livros = livroService.listarTodos();
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroModel> buscarPorId(@PathVariable Long id){
        return livroService.listarPorId(id)
                .map(livro -> new ResponseEntity<>(livro,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping
    public ResponseEntity<LivroModel> criar(@RequestBody LivroModel novoLivro) {
        LivroModel criado = livroService.criar(novoLivro);
        return new ResponseEntity<>(criado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        livroService.deletarLivro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
