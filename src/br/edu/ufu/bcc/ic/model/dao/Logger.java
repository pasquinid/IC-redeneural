package br.edu.ufu.bcc.ic.model.dao;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
	private static final String caminho = "log/";
	private String nomeArquivo;
	
	public Logger(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo + ".log";
	}
	
	public void adicionar(String descricao) throws IOException {
		PrintWriter arquivo = new PrintWriter(new BufferedWriter(new FileWriter(Logger.caminho + this.nomeArquivo, true)));
		arquivo.println(descricao);
		arquivo.close();
	}
	
}