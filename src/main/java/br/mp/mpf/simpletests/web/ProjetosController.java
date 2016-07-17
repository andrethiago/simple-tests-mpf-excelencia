package br.mp.mpf.simpletests.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.mp.mpf.simpletests.model.Projeto;
import br.mp.mpf.simpletests.model.service.ProjetoService;

@Controller
@RequestMapping("/projetos")
public class ProjetosController {

    @Autowired
    private ProjetoService projetoService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Projeto> projetos() {
	return projetoService.consultarTodos();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Projeto porId(@PathVariable Long id) {
	return projetoService.consultarPorId(id);
    }

    @RequestMapping(params = { "nome" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Projeto> porNome(@RequestParam("nome") String nome) {
	return projetoService.consultarPorNome(nome);
    }

}
