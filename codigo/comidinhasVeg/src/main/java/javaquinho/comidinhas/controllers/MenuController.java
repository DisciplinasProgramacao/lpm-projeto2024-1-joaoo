package javaquinho.comidinhas.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javaquinho.comidinhas.models.Menu;
import javaquinho.comidinhas.models.Produto;
import javaquinho.comidinhas.repositories.MenuRepository;
import javaquinho.comidinhas.repositories.ProdutoRepository;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired private MenuRepository repository;
    @Autowired private ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    public List<Menu> getAllByRestauranteId(){
        return repository.findAll();
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Menu> getProduto(@RequestParam Long id){
        Optional<Menu> produto = repository.findByProdutoId(id);

        return produto.isPresent() ? ResponseEntity.ok(produto.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Menu> adicionarProduto(@RequestBody Menu menu) {
        Menu obj = repository.save(menu);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    
}