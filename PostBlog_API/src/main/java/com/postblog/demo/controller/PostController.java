package com.postblog.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postblog.demo.models.Post;
import com.postblog.demo.repository.PostRepository;

@RestController
@RequestMapping(value = "/blogapi")
public class PostController {

	@Autowired
	PostRepository postRepository;
	
	@GetMapping("/postagens")
	public List<Post> listaPosts() {
		return postRepository.findAll();
	}
	
	@GetMapping("/postagem/{id}")
	public Post listaPostUnico (@PathVariable(value = "id") long id) {
		return postRepository.findById(id);
	}
	
	@PostMapping("/publicar")
	public Post publicaPost(@RequestBody Post post) {
		return postRepository.save(post);
	}
	
	@DeleteMapping("/deletar")
	public void deletaPost(@RequestBody Post post) {
		postRepository.delete(post);
	}
	
	@PutMapping("/atualizar")
	public Post atualizaPost(@RequestBody Post post) {
		return postRepository.save(post);
	}
	
	@GetMapping("/postagem/categoria/{categoria}")
	public List<Post> listaPostCategoria(@PathVariable(value = "categoria") String categoria) {
		return postRepository.findByCategoria(categoria);
	}
}
	
