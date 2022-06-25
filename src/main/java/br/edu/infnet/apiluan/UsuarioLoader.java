package br.edu.infnet.apiluan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.apiluan.model.domain.Usuario;
import br.edu.infnet.apiluan.model.domain.service.UsuarioService;

@Order(3)
@Component
public class UsuarioLoader implements ApplicationRunner {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		String[] logins = {"instituto", "infnet12901", "luan", "infnet"};

		Usuario usuario = null;
		
		for(String login : logins) {
			usuario = usuarioService.validar(login, "x12345678901");
			
			if(usuario != null) {
				System.out.printf("%d - %s - %s\n",
							usuario.getId(),
							usuario.getNome(),
							usuario.getLogin()
						);
				
				//usuarioService.excluir(usuario.getId());
			}
		}
		
	}
}
