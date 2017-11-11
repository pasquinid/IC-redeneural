package br.edu.ufu.bcc.ic.model.vo;

public class FuncaoAtivacaoLinear extends FuncaoAtivacao {
	
	public FuncaoAtivacaoLinear(double alfa) {
		super(alfa);
	}
	
	@Override
	public double calcular(double rede) {
		return this.getParametro() * rede;
	}

}
