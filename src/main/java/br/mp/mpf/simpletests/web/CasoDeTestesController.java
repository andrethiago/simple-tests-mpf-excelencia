package br.mp.mpf.simpletests.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.mp.mpf.simpletests.infra.web.Resultado;
import br.mp.mpf.simpletests.model.CasoDeTeste;
import br.mp.mpf.simpletests.model.Projeto;
import br.mp.mpf.simpletests.model.TipoTeste;
import br.mp.mpf.simpletests.model.service.CasoDeTesteService;

@Controller
public class CasoDeTestesController {

    @Autowired
    private CasoDeTesteService casosTesteService;

    @RequestMapping(value = "/casos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Resultado listarTodos() {
	return new Resultado(casosTesteService.consultarTodos());
    }

    @RequestMapping(value = "/projetos/{id}/casos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Resultado casosPorProjeto(@PathVariable(value = "id") Long idProjeto) {
	Projeto projeto = new Projeto();
	projeto.setId(idProjeto);
	return new Resultado(casosTesteService.consultarPorProjeto(projeto));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Resultado porId(@PathVariable Long id) {
	return new Resultado(casosTesteService.consultarPorId(id));
    }

    @RequestMapping(value = "/casos", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Resultado incluir(@RequestBody CasoDeTeste casoDeTeste) {
	casosTesteService.incluir(casoDeTeste);
	return new Resultado(casoDeTeste, "Caso de Teste incluído com sucesso!");
    }

    @RequestMapping(value = "/casos/tipos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Resultado tiposDeTeste() {
	return new Resultado(TipoTeste.values());
    }

}
