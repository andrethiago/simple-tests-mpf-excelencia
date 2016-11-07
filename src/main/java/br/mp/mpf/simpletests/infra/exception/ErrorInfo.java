package br.mp.mpf.simpletests.infra.exception;

public class ErrorInfo {

    private int errorCode;

    private String mensagem;

    public ErrorInfo(int errorCode, String mensagem) {
	super();
	this.errorCode = errorCode;
	this.mensagem = mensagem;
    }

    public int getErrorCode() {
	return errorCode;
    }

    public String getMensagem() {
	return mensagem;
    }

}
