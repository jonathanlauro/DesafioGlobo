package br.com.desafioglobo.desafioglobo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.desafioglobo.desafioglobo.model.UsuarioModel;

public interface UsuarioRepository extends MongoRepository<UsuarioModel, Long>{

	UsuarioModel findById(long id);
	UsuarioModel findByDocumento(String document);
}
