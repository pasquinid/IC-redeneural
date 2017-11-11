package br.edu.ufu.bcc.ic.model.vo;

public class FuncaoAtivacaoSigmoidal extends FuncaoAtivacao {
	
	public FuncaoAtivacaoSigmoidal(double suavidade) {
		super(suavidade);
	}
	
	@Override
	public double calcular(double rede) {
		return (1 / (1 + Math.exp(-rede/this.getParametro())));
	}

}
