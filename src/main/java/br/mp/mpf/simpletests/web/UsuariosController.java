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
import br.mp.mpf.simpletests.model.Usuario;
import br.mp.mpf.simpletests.model.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Resultado usuarios() {
	return new Resultado(usuarioService.consultarTodos());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Resultado porId(@PathVariable Long id) {
	return new Resultado(usuarioService.consultarPorId(id));
    }

    // @RequestMapping(method = RequestMethod.PUT, consumes =
    // MediaType.APPLICATION_JSON_UTF8_VALUE)
    // @ResponseBody
    // public Map<String, Object> incluir(@RequestBody Usuario usuario) {
    // Map<String, Object> resultado = new HashMap<>();
    // try {
    // usuario = usuarioService.incluir(usuario);
    // resultado.put("success", true);
    // resultado.put("mensagem", "Usuário incluído com sucesso");
    // } catch (Exception e) {
    // e.printStackTrace();
    // resultado.put("success", false);
    // resultado.put("mensagem", e.getMessage());
    // }
    // return resultado;
    // }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Resultado incluir(@RequestBody Usuario usuario) {
	usuario = usuarioService.incluir(usuario);
	return new Resultado(usuario, "Usuário incluído com sucesso!");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Resultado excluir(@PathVariable Long id) {
	Usuario usuario = new Usuario();
	usuario.setId(id);
	usuarioService.excluir(usuario);

	return new Resultado("Usuário removido com sucesso.");
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Resultado alterar(@RequestBody Usuario usuario) {
	usuario = usuarioService.alterar(usuario);

	return new Resultado(usuario, "Usuário alterado com sucesso");
    }

    /*
     * @ResponseStatus(value = HttpStatus.NOT_FOUND, reason =
     * "Usuário não encontrado")
     *
     * @ExceptionHandler(value = EntidadeNaoEncontradaException.class) public
     * void usuarioNaoEncontrado() { // faz nada }
     */

}
