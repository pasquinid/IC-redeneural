package br.edu.ufu.bcc.ic.model.dao;

import java.util.Set;

import br.edu.ufu.bcc.ic.model.vo.Amostra;


public interface AmostraDAO {
	public Set<Amostra> getTodos(Boolean teste);
	public void atualizar(Amostra amostra);
	public void inserir (Amostra amostra);
	public void excluir (Amostra amostra);
}
