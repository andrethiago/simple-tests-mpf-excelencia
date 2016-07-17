package br.mp.mpf.simpletests.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.mp.mpf.simpletests.model.Projeto;
import br.mp.mpf.simpletests.model.SuiteDeTeste;
import br.mp.mpf.simpletests.model.service.SuiteDeTesteService;

@Controller
@RequestMapping("/projetos/{id}/suites")
public class SuitesDeTesteController {

    @Autowired
    private SuiteDeTesteService suiteService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<SuiteDeTeste> suitesPorProjeto(@PathVariable(value = "id") Long idProjeto) {
	Projeto projeto = new Projeto();
	projeto.setId(idProjeto);
	return suiteService.consultarPorProjeto(projeto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public SuiteDeTeste porId(@PathVariable Long id) {
	return suiteService.consultarPorId(id);
    }

}
