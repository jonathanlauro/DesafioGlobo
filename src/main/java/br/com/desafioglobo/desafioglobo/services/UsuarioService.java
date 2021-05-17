package br.com.desafioglobo.desafioglobo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.desafioglobo.desafioglobo.domain.model.Cep;
import br.com.desafioglobo.desafioglobo.domain.model.Usuario;
import br.com.desafioglobo.desafioglobo.model.UsuarioModel;
import br.com.desafioglobo.desafioglobo.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<UsuarioModel> findAll(){
		return usuarioRepository.findAll();
	}
	
	public void criar(Usuario usuario) throws Exception {
		if(validaCEP(usuario.getCep())) {
			throw new Exception("Informe um CEP válido");
		}
		
		String url = "http://viacep.com.br/ws/"+usuario.getCep()+"/json/";
		RestTemplate restTemplate = new RestTemplate();
		Cep cepResponse = restTemplate.getForObject(url,Cep.class);
		
		if(cepResponse.isErro()) {
			throw new Exception("Informe um CEP válido");
		}
		
		Random gerador = new Random();
		
		UsuarioModel user = new UsuarioModel();

		user.setNome(usuario.getNome());
		user.setDocumento(usuario.getDocumento());
		user.setCidade(cepResponse.getLocalidade());
		user.setEstado(cepResponse.getUf());
		user.setBairro(cepResponse.getBairro());
		user.setId((long) gerador.nextInt(1500));
		user.setIdade(calcIdade(usuario.getDataNascimento().getYear()));
		
		
		usuarioRepository.save(user);
	}
	
	
	private boolean validaCEP(String cep) {
		if(cep.equals("00000000") || cep.equals("11111111") ||
				cep.equals("22222222") || cep.equals("33333333") ||	
				cep.equals("44444444") || cep.equals("55555555") ||
				cep.equals("66666666") || cep.equals("77777777") ||
				cep.equals("88888888") || cep.equals("99999999") ||
				cep.length() == 8
				) {
			return false;
		}else {
			return true;
		}
	}
	 private int calcIdade(int a) {
		 LocalDate anoatual = LocalDate.now();
		int ano = anoatual.getYear();
		 return ano - a;
	 }
	 
	 public UsuarioModel findByDocument(String doc) throws Exception {
		 UsuarioModel user = usuarioRepository.findByDocumento(doc);
		 
		 if(user == null) {
			 throw new Exception("Usuario não encontrado");
		 }
		 
		 return user;
	 }
}
