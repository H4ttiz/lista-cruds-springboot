package com.unicesumar.lista_cruds_springboot.produtos.controller;


import com.unicesumar.lista_cruds_springboot.produtos.model.ProdutoModel;
import com.unicesumar.lista_cruds_springboot.produtos.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
    @GetMapping
    public ResponseEntity<List<ProdutoModel>> listarTodos(){
        List<ProdutoModel> livros = produtoService.listarTodos();
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> buscarPorId(@PathVariable Long id){
        return produtoService.listarPorId(id)
                .map(produto -> new ResponseEntity<>(produto,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> criar(@RequestBody ProdutoModel novoProduto) {
        ProdutoModel criado = produtoService.criar(novoProduto);
        return new ResponseEntity<>(criado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
