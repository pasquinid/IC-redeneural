package br.edu.ufu.bcc.ic.view;

import java.util.List;

import br.edu.ufu.bcc.ic.model.vo.Neuronio;

public class ResultadoView {
	private List<Neuronio> lista;
	
	public ResultadoView(List<Neuronio> lista) {
		this.lista = lista;
	}
	public void exibir() {
		System.out.println("=========================");
		System.out.println("  Resultado");
		System.out.println("=========================");
		NeuronioView neuronioView = new NeuronioView("", null);
		for (int i = 0; i < lista.size(); i++) {
			char letra = (char) ('A'+i);
			neuronioView.setDescricao("Neurônio " + letra);
			neuronioView.setNeuronio(lista.get(i));
			neuronioView.exibir();
		}
			
	}
}
