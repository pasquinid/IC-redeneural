package br.edu.ufu.bcc.ic.model.dao;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;

public class ArquivoConfiguracaoDAO implements ConfiguracaoDAO {
	private String caminho = "conf/redesneurais.conf";
	private Properties propriedades;
	
	public ArquivoConfiguracaoDAO(){
		this.propriedades = new Properties();
		try {
			FileInputStream arquivo = new FileInputStream(caminho);
			propriedades.load(arquivo);
		} catch (IOException e){
			this.propriedades.setProperty("taxa.aprendizagem", "0.2");
			this.propriedades.setProperty("funcao.ativacao.tipo", "linear");
			this.propriedades.setProperty("funcao.ativacao.parametro", "0.5");
			this.propriedades.setProperty("perceptron.vies", "1");
			this.propriedades.setProperty("erro.maximo", "0.2");
			salvar();
		}
		
	}
	
	public void salvar(){
		try {
			FileOutputStream arquivo = new FileOutputStream(caminho);
			this.propriedades.store(arquivo,"");
		} catch (IOException e){
			System.out.println ("Arquivo e/ou diretório de configuração não encontrado");
		}
	}
	
	public String get(String chave){
		return this.propriedades.getProperty(chave);
	}
	
	public void atualiza(String chave, String valor){
		this.propriedades.setProperty(chave, valor);
		this.salvar();
	}
	
	public void remover(String chave){
		this.propriedades.remove(chave);
		this.salvar();
	}
	
	public void inserir(String chave, String valor){
		this.propriedades.setProperty(chave, valor);
		this.salvar();
	}
}

