package br.edu.ufu.bcc.ic.model.vo;

public abstract class FuncaoAtivacao {
	private double parametro;
	
	public FuncaoAtivacao(double parametro) {
		this.setParametro(parametro);
	}
	
	public double getParametro() {
		return parametro;
	}
	public void setParametro(double parametro) {
		this.parametro = parametro;
	}
	
	public abstract double calcular(double rede);
}
