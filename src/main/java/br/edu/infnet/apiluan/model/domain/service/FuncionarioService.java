package br.edu.infnet.apiluan.model.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apiluan.model.domain.Funcionario;
import br.edu.infnet.apiluan.model.domain.repository.FuncionarioRepository;
@Service
public class FuncionarioService {
		
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public List<Funcionario> obterLista(Integer idEstabelecimento){
		return funcionarioRepository.obterLista(idEstabelecimento);
	}
	
	public List<Funcionario> obterLista(){
		return (List<Funcionario>) funcionarioRepository.findAll();
	}
	
	public void incluir(Funcionario funcionario) {

		funcionarioRepository.save(funcionario);
	}
	public void excluir(Integer idFuncionario) {
		funcionarioRepository.deleteById(idFuncionario);
	}
}
