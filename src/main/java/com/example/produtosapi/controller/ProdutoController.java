package com.example.produtosapi.controller;

import com.example.produtosapi.model.Produto;
import com.example.produtosapi.repository.ProdutoRepositoy;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepositoy produtoRepositoy;

    public ProdutoController(ProdutoRepositoy produtoRepositoy) {
        this.produtoRepositoy = produtoRepositoy;
    }

    @PostMapping
    public Produto salvar (@RequestBody Produto produto){
        System.out.println("Produto recebido" + produto);

       var id = UUID.randomUUID().toString(); //UUID Serve para gerar um id randomizado, .ToString fazendo a conversão para ser igual no BD
       produto.setId(id); //Setando id de produto

       produtoRepositoy.save(produto);
       return produto;
    }

   @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id") String id){

  //    Optional<Produto> produto = produtoRepositoy.findById(id);
  //    return produto.isPresent() ? produto.get() : null;

       return produtoRepositoy.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") String id){

        produtoRepositoy.deleteById(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable("id") String id,
                          @RequestBody Produto produto){
        produto.setId(id);
        produtoRepositoy.save(produto);

    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome){
        return produtoRepositoy.findByNome(nome);

    }
}
