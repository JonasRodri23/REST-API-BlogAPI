package com.postblog.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postblog.demo.models.Autor;
import java.util.Optional;



public interface AutorRepository extends JpaRepository<Autor, Long> {

	Optional<Autor> findById(Long id); 
}
