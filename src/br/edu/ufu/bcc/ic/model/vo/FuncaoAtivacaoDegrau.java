package br.edu.ufu.bcc.ic.model.vo;

public class FuncaoAtivacaoDegrau extends FuncaoAtivacao {
	
	public FuncaoAtivacaoDegrau (double limite) {
		super(limite);
	}
	
	@Override
	public double calcular(double rede) {
		if ( rede >= this.getParametro() )
			return 1;
		else return 0;
	}

}
