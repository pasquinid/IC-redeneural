package br.edu.ufu.bcc.ic.model.vo;

import java.util.Arrays;

public class Neuronio {
	private double[] pesos;
	private double[] entrada;
	private double saidaObtida;
	private double saidaDesejada;
	private double rede;
	private double erro;
	private FuncaoAtivacao funcaoAtivacao;
	private double taxaAprendizagem;
	
	public Neuronio(double[] pesos, FuncaoAtivacao funcaoAtivacao, double taxaAprendizagem) {
		this.pesos = pesos;
		this.funcaoAtivacao = funcaoAtivacao;
		this.taxaAprendizagem = taxaAprendizagem;
	}
	
	public void verificaEntrada(double[] entrada) {
		if ( entrada == null )
			throw new IllegalArgumentException("Entrada Vazia");
		if ( entrada.length != this.pesos.length )
			throw new IllegalArgumentException("Vetor de entrada " + Arrays.toString(entrada) + " de tamanho diferente do vetor de pesos " + Arrays.toString(pesos) + "\n");
	}
	
	public void configurar(double[] entrada, double saidaDesejada) {
		verificaEntrada(entrada);
		this.entrada = entrada;
		this.saidaDesejada = saidaDesejada;
	}
	
	public void processar() {
		this.rede = 0.0;
		this.erro = 0.0;
		for (int i = 0; i < pesos.length; i++)
			this.rede += this.pesos[i] * entrada [i];
		this.saidaObtida = this.funcaoAtivacao.calcular(rede);
		this.erro = this.saidaDesejada - this.saidaObtida;
	}
	
	public boolean houveErro() {
		return this.erro == 0.0 ? false : true;
	}
	
	public void ajustar() {
		for (int i = 0; i < this.pesos.length; i++)
			this.pesos[i] = this.pesos[i] + ( this.taxaAprendizagem * this.erro * this.entrada[i]);
	}
	
	public double[] getPesos() {
		return pesos;
	}
	
	public void setPesos(double[] pesos) {
		this.pesos = pesos;
	}
	
	public double[] getEntrada() {
		return entrada;
	}
	
	public void setEntrada(double[] entrada) {
		this.entrada = entrada;
	}
	
	public double getSaidaObtida() {
		return saidaObtida;
	}
	
	public void setSaidaObtida(double saidaObtida) {
		this.saidaObtida = saidaObtida;
	}
	
	public double getSaidaDesejada() {
		return saidaDesejada;
	}
	
	public void setSaidaDesejada(double saidaDesejada) {
		this.saidaDesejada = saidaDesejada;
	}
	
	public double getRede() {
		return rede;
	}
	
	public void setRede(double rede) {
		this.rede = rede;
	}
	
}
