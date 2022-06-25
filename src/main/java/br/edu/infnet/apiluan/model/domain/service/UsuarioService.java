package br.edu.infnet.apiluan.model.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apiluan.model.domain.Usuario;
import br.edu.infnet.apiluan.model.domain.repository.UsuarioRepository;
@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario validar(String login, String senha) {
		return usuarioRepository.validar(login, senha);
	}
	
	public void excluir(Integer id) {
		usuarioRepository.deleteById(id);
	}

	public List<Usuario> obterLista() {
		return (List<Usuario>)usuarioRepository.findAll();
	}
}
