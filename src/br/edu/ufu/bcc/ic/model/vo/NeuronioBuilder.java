package br.edu.ufu.bcc.ic.model.vo;

import java.util.Random;

import br.edu.ufu.bcc.ic.model.dao.ArquivoConfiguracaoDAO;
import br.edu.ufu.bcc.ic.model.dao.ConfiguracaoDAO;

public class NeuronioBuilder {
	private double[] pesos;
	private FuncaoAtivacao funcaoAtivacao;
	private double taxaAprendizagem;
	private ConfiguracaoDAO dao = new ArquivoConfiguracaoDAO();
	
	private double getVies() {
		try {
			double vies = Double.parseDouble(dao.get("perceptron.vies"));
			return vies;
		} catch (NullPointerException | NumberFormatException e ) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void buildPesos() {
		double vies = getVies();
		int tamanho = Integer.parseInt(dao.get("tamanho.amostra"));
		this.pesos = new double[tamanho];
		this.pesos[0] = vies;
		Random random = new Random();
		for (int i = 1; i < pesos.length; i++)
			this.pesos[i] = random.nextDouble();
	}
		
	public void buildPesos(double[] pesos) {
		this.pesos = pesos;
	}
	
	public void buildFuncaoAtivacao() {
		String tipo = dao.get("funcao.ativacao.tipo");
		double parametro = Double.parseDouble(dao.get("funcao.ativacao.parametro"));

		if ( tipo.equals("linear") )
			this.funcaoAtivacao = new FuncaoAtivacaoLinear(parametro);
		else if ( tipo.equals("degrau"))
			this.funcaoAtivacao = new FuncaoAtivacaoDegrau(parametro);
		else if ( tipo.equals("sigmoidal") )
			this.funcaoAtivacao = new FuncaoAtivacaoSigmoidal(parametro);
	}
	
	public void buildTaxaAprendizagem() {
		this.taxaAprendizagem = Double.parseDouble(this.dao.get("taxa.aprendizagem"));
	}
	
	public Neuronio getNeuronio() {
		return new Neuronio(this.pesos, this.funcaoAtivacao, this.taxaAprendizagem);
	}
}
