package com.example.algamoneyapi.resources;

import com.example.algamoneyapi.event.RecursoCriadoEvent;
import com.example.algamoneyapi.model.Categoria;
import com.example.algamoneyapi.model.Pessoa;
import com.example.algamoneyapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping
    public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        publisher.publishEvent(new RecursoCriadoEvent(this,response, pessoaSalva.getCodigo()));


        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);

    }
    @GetMapping("/{codigo}")
     public Pessoa buscarPeloCodigo(@PathVariable Long codigo, String pessoa) {
        return pessoaRepository.findById(codigo).orElse(null);
    }
}
