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
import br.mp.mpf.simpletests.model.Release;
import br.mp.mpf.simpletests.model.service.ReleaseService;

@Controller
@RequestMapping("/projetos/{id}/releases")
public class ReleasesController {

    @Autowired
    private ReleaseService releaseService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Release> releasePorProjeto(@PathVariable(value = "id") Long idProjeto) {
	Projeto projeto = new Projeto();
	projeto.setId(idProjeto);
	return releaseService.consultarPorProjeto(projeto);
    }

}
