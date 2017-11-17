package br.edu.ufu.bcc.ic.model.bo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.edu.ufu.bcc.ic.model.vo.Neuronio;
import br.edu.ufu.bcc.ic.model.dao.AmostraDAO;
import br.edu.ufu.bcc.ic.model.dao.ArquivoAmostraDAO;
import br.edu.ufu.bcc.ic.model.dao.ArquivoConfiguracaoDAO;
import br.edu.ufu.bcc.ic.model.dao.ConfiguracaoDAO;
import br.edu.ufu.bcc.ic.model.vo.Amostra;
import br.edu.ufu.bcc.ic.model.vo.NeuronioBuilder;

public class Treinamento {
	private AmostraDAO amostraDAO = new ArquivoAmostraDAO();
	private ConfiguracaoDAO configuracaoDAO = new ArquivoConfiguracaoDAO();
	private List<Neuronio> neuronios = new ArrayList<Neuronio>();	
	private Set<Amostra> conjuntoAmostraTreinamento;
        private Set<Amostra> conjuntoAmostraTeste;
	private double erroMaximo;
	private double erro;
	
	public Treinamento() {
		this.conjuntoAmostraTreinamento = amostraDAO.getTodos(false);
                this.conjuntoAmostraTeste = amostraDAO.getTodos(true);
		NeuronioBuilder neuronioBuilder = new NeuronioBuilder();
		for (int i = 0; i < 26; i++) {
			neuronioBuilder.buildPesos();
			neuronioBuilder.buildFuncaoAtivacao();
			neuronioBuilder.buildTaxaAprendizagem();
			this.neuronios.add(neuronioBuilder.getNeuronio());
		}
		this.erroMaximo = Double.parseDouble(configuracaoDAO.get("erro.maximo"));
	}
	
	public void executar() throws IOException {
		int quantidadeErros;
		for (int j = 0; j < 1000; j++) {
			quantidadeErros  = 0;
			for (Amostra amostra : conjuntoAmostraTreinamento) {
				double[] entrada = amostra.getEntrada();
				double[] saida = amostra.getSaida();
				for (int i = 0; i < neuronios.size(); i++) {
					Neuronio neuronio = neuronios.get(i);					
					neuronio.configurar(entrada, saida[i]);
					neuronio.processar();
					neuronio.ajustar();			
				}
				
				boolean existeErroAmostra = false;
				for (Neuronio neuronio : neuronios)
					if (neuronio.houveErro()) {
						existeErroAmostra = true;
						break;
					}
				if (existeErroAmostra)
					quantidadeErros++;
			}
			this.erro = ((double) quantidadeErros/conjuntoAmostraTreinamento.size());
		}	
	}
	
        public void executarTeste() throws IOException {
		int quantidadeErros;
		quantidadeErros  = 0;
		for (Amostra amostra : conjuntoAmostraTeste) {
                    double[] entrada = amostra.getEntrada();
                    double[] saida = amostra.getSaida();
                    for (int i = 0; i < neuronios.size(); i++) {
                            Neuronio neuronio = neuronios.get(i);					
                            neuronio.configurar(entrada, saida[i]);
                            neuronio.processar();			
                    }
				
		boolean existeErroAmostra = false;
		for (Neuronio neuronio : neuronios)
			if (neuronio.houveErro()) {
                            existeErroAmostra = true;
                            break;
			}
		if (existeErroAmostra)
                    quantidadeErros++;
		}
		this.erro = ((double) quantidadeErros/conjuntoAmostraTreinamento.size());	
	}
        
        
	public List<Neuronio> getNeuronios(){
		return this.neuronios;
	}
	
	public double getErro() {
		return erro;
	}
}