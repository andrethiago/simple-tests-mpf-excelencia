package br.mp.mpf.simpletests.infra.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.mp.mpf.simpletests.infra.web.Resultado;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Resultado defaultErrorHandler(HttpServletRequest req, HttpServletResponse response, Exception e)
	    throws Exception {

	e.printStackTrace();

	// If the exception is annotated with @ResponseStatus rethrow it and let
	// the framework handle it - like the OrderNotFoundException example
	// at the start of this post.
	// AnnotationUtils is a Spring Framework utility class.
	if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
	    throw e;

	// Otherwise setup and send the user de error info
	ErrorInfo erro = new ErrorInfo(404, e.getMessage());
	Resultado resultado = new Resultado();
	resultado.addErro(erro);

	response.setStatus(404);

	return resultado;
    }

}
