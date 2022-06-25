package br.edu.infnet.apiluan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.apiluan.model.domain.Estabelecimento;
import br.edu.infnet.apiluan.model.domain.service.EstabelecimentoService;

@Component
@Order(1)
public class EstabelecimentoLoader implements ApplicationRunner {
	
	@Autowired
	private EstabelecimentoService estabelecimentoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Estabelecimento estabelecimento = null;
		try {
			estabelecimento = new Estabelecimento();
			estabelecimento.setCnpj("00.673.757/0001-46");
			estabelecimento.setEdTech(true);
			estabelecimento.setEndereco("R. São José, 90 - Centro, Rio de Janeiro - RJ, 20010-020");
			estabelecimento.setLogin("infnet");
			estabelecimento.setNome("Instituto Infnet");
			estabelecimento.setSenha("x12345678901");		
			
			estabelecimentoService.incluir(estabelecimento);

			System.out.println("Processo de inclusso de estabelecimento.");			
		} catch (Exception e) {
			System.out.println("[ERRO] Impossivel realizar a inclusao do estabelecimento " + estabelecimento.getNome());			
		}
		
	}
}
