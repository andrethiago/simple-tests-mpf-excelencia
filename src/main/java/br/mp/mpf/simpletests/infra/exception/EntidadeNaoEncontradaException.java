package br.mp.mpf.simpletests.infra.exception;

//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Objeto não encontrado")
public class EntidadeNaoEncontradaException extends RuntimeException {

    private static final long serialVersionUID = 5646248295953656217L;

    public EntidadeNaoEncontradaException(String msg) {
	super(msg);
    }

}
