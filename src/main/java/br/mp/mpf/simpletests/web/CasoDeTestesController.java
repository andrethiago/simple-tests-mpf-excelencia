package br.mp.mpf.simpletests.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.mp.mpf.simpletests.model.CasoDeTeste;
import br.mp.mpf.simpletests.model.Projeto;
import br.mp.mpf.simpletests.model.service.CasoDeTesteService;

@Controller
@RequestMapping("/projetos/{id}/casos")
public class CasoDeTestesController {

    @Autowired
    private CasoDeTesteService casosTesteService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<CasoDeTeste> suitesPorProjeto(@PathVariable(value = "id") Long idProjeto) {
	Projeto projeto = new Projeto();
	projeto.setId(idProjeto);
	return casosTesteService.consultarPorProjeto(projeto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public CasoDeTeste porId(@PathVariable Long id) {
	return casosTesteService.consultarPorId(id);
    }

}
