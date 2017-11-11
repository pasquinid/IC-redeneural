package br.edu.ufu.bcc.ic.model.vo;

public class Amostra {
	private double[] entrada;
	private double[] saida;
	
	public Amostra(double[] entrada, double[] saida) {
		this.entrada = entrada;
		this.saida = saida;
	}
	
	public double[] getEntrada() {
		return entrada;
	}
	
	public void setEntrada(double[] entrada) {
		this.entrada = entrada;
	}
	
	public double[] getSaida() {
		return saida;
	}
	
	public void setSaida(double[] saida) {
		this.saida = saida;
	}
	
}
