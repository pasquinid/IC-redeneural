package br.edu.ufu.bcc.ic.view;

import java.util.Arrays;

import br.edu.ufu.bcc.ic.model.vo.Neuronio;

public class NeuronioView {
	private Neuronio neuronio;
	private String descricao;
	
	public NeuronioView(String descricao, Neuronio neuronio) {
		this.neuronio = neuronio;
		this.descricao = descricao;
	}
	
	public void setNeuronio(Neuronio neuronio) {
		this.neuronio = neuronio;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void exibir() {
		System.out.println(this.descricao + ": " + Arrays.toString(this.neuronio.getPesos()));
	}
}
