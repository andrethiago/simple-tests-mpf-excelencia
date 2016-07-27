package br.mp.mpf.simpletests.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.mp.mpf.simpletests.infra.web.Resultado;
import br.mp.mpf.simpletests.model.Projeto;
import br.mp.mpf.simpletests.model.service.ProjetoService;

@Controller
@RequestMapping("/projetos")
public class ProjetosController {

    @Autowired
    private ProjetoService projetoService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Resultado projetos() {
	return new Resultado(projetoService.consultarTodos());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Resultado porId(@PathVariable Long id) {
	return new Resultado(projetoService.consultarPorId(id));
    }

    @RequestMapping(params = { "nome" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Resultado porNome(@RequestParam("nome") String nome) {
	return new Resultado(projetoService.consultarPorNome(nome));
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Resultado incluir(@RequestBody Projeto projeto) {
	projetoService.incluir(projeto);
	return new Resultado(projeto, "Projeto incluído com sucesso!");
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Resultado alterar(@RequestBody Projeto projeto) {
	projetoService.alterar(projeto);
	return new Resultado(projeto, "Projeto alterado com sucesso!");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Resultado excluir(@PathVariable Long id) {
	Projeto projeto = new Projeto();
	projeto.setId(id);
	projetoService.excluir(projeto);

	return new Resultado("Projeto removido com sucesso.");
    }

}
