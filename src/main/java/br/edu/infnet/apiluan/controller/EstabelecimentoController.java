package br.edu.infnet.apiluan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apiluan.model.domain.Estabelecimento;
import br.edu.infnet.apiluan.model.domain.service.EstabelecimentoService;

@RestController
@RequestMapping("/api/estabelecimento")
public class EstabelecimentoController {

	@Autowired
	private EstabelecimentoService estabelecimentoService;
	
	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Estabelecimento estabelecimento) {
		estabelecimentoService.incluir(estabelecimento);
	}
	@GetMapping(value = "/listar")
    public List<Estabelecimento> obterLista() {
        return estabelecimentoService.obterLista();
    }
	
	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		estabelecimentoService.excluir(id);
	}
	
	@GetMapping("/{idEstabelecimento}")
	public Estabelecimento obterPorId(@PathVariable Integer idEstabelecimento) {
		return this.estabelecimentoService.obterPorId(idEstabelecimento);
	}
	
}
