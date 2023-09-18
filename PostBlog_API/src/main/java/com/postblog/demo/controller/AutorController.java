package com.postblog.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postblog.demo.models.Autor;
import com.postblog.demo.models.Post;
import com.postblog.demo.repository.AutorRepository;

@RestController
@RequestMapping(value = "/blogapi")
public class AutorController {

	@Autowired
	AutorRepository autorRepository;
	
	@GetMapping("/autores")
	public List<Autor> listaAutores() {
		return autorRepository.findAll();
	}
	
	@GetMapping("/autor/{id}")
	public Optional<Autor> listaAutorUnico (@PathVariable(value = "id") long id) {
		return autorRepository.findById(id);
	}
	
	@PostMapping("/autor/criar")
	public Autor criaAutor (@RequestBody Autor autor) {
		return autorRepository.save(autor);
	}
	
	@DeleteMapping("/autor/deletar")
	public void deletaAutor(@RequestBody Autor autor) {
		autorRepository.delete(autor);
	}
	
	@PutMapping("/autor/atualizar")
	public Autor atualizaAutor(@RequestBody Autor autor) {
		return autorRepository.save(autor);
	}
	
}
