package com.postblog.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postblog.demo.models.Post;
import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {

	
	Post findById(long id);
	List<Post> findByCategoria(String categoria);
	
}
