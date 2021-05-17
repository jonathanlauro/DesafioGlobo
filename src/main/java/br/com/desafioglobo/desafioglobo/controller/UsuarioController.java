package br.com.desafioglobo.desafioglobo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioglobo.desafioglobo.domain.model.Usuario;
import br.com.desafioglobo.desafioglobo.model.UsuarioModel;
import br.com.desafioglobo.desafioglobo.repository.UsuarioRepository;
import br.com.desafioglobo.desafioglobo.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<UsuarioModel> listaUsuarios(){
		return usuarioService.findAll();
	}
	@GetMapping("/{documento}")
	public ResponseEntity<?> listaUnicoUser(@PathVariable(name = "documento") String doc){
		try {
			return new ResponseEntity<UsuarioModel>( usuarioService.findByDocument(doc), HttpStatus.OK);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
		}
		
	}
	@PostMapping
	public ResponseEntity<?> criaUsuarios(@RequestBody Usuario usuario){
		try {
			
			usuarioService.criar(usuario);
			return ResponseEntity.status(HttpStatus.OK).body("Usuario Cadastrado.");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar usuario." + e);
		}
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable(name = "id") Long id){
		try {
			usuarioRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso.");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao deletar usuario." + e);
		}
		
	}
	
	
}
