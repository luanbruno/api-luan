package br.edu.infnet.apiluan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.apiluan.model.domain.Estabelecimento;
import br.edu.infnet.apiluan.model.domain.Funcionario;
import br.edu.infnet.apiluan.model.domain.service.FuncionarioService;
import br.edu.infnet.apiluan.model.domain.service.UsuarioService;

@Component
@Order(2)
public class FuncionarioLoader implements ApplicationRunner {
	@Autowired
	private FuncionarioService funcionarioService;
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		String[] cpfs = {"12345678901", "23456789012", "12345678901", "34567890123"};
		
		Funcionario funcionario = null;

		Estabelecimento estabelecimento = (Estabelecimento)usuarioService.validar("infnet", "123456");
		
		for(String cpf : cpfs) {				
			funcionario = new Funcionario();
			funcionario.setCpf(cpf);
			funcionario.setEmail(cpf+"@aluno.com");
			funcionario.setEstabelecimento(estabelecimento);
			funcionario.setLogin("inf"+cpf);
			funcionario.setNome("Instituto Infnet "+cpf);
			funcionario.setSenha("x"+cpf);		
			funcionario.setTelefone("(21) 98754-6255");
			
			try {
				funcionarioService.incluir(funcionario);			
				System.out.println("Processo de inclusao de funcionario.");			
			} catch (Exception e) {
				System.out.println("["+e.getMessage()+"]");
				System.out.println("[ERRO] Impossivel realizar a inclusao do funcionario " + funcionario.getNome());			
			}
		}		
	
	}
}