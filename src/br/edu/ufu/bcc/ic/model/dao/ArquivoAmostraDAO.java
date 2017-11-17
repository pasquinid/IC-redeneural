package br.edu.ufu.bcc.ic.model.dao;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

import br.edu.ufu.bcc.ic.model.vo.Amostra;

public class ArquivoAmostraDAO implements AmostraDAO{
	private static String caminho = "dados/dados.txt";
        private static String testeCaminho = "dados/teste.txt";
	private Scanner scanner;
		
	@Override
	public Set<Amostra> getTodos(Boolean teste){
		try {
                        FileReader arquivo;
                        if(!teste)
                            arquivo = new FileReader(caminho);
                        else arquivo = new FileReader(testeCaminho);
			scanner = new Scanner(arquivo);
			scanner.useDelimiter(",|\\n");
			Set<Amostra> conjunto = new HashSet<Amostra>();
			while (scanner.hasNext()) {
				
				char letra = scanner.next().charAt(0);

				double[] saida = new double[26];
				saida[letra-65] = 1;
				
				double[] entrada = new double[16];
				for (int i = 0; i < 16; i++)
					entrada[i] = Double.parseDouble(scanner.next());
				
				Amostra amostra = new Amostra (entrada, saida);
				conjunto.add(amostra);
			}
			arquivo.close();
			return conjunto;
		} catch (IOException e) {
			return null;
		}
	}
	
	@Override
	public void atualizar(Amostra amostra) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void inserir(Amostra amostra) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void excluir(Amostra amostra) {
		// TODO Auto-generated method stub
	}
	

}
