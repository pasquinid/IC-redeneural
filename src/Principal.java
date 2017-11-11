import java.util.List;

import br.edu.ufu.bcc.ic.model.bo.Treinamento;
import br.edu.ufu.bcc.ic.model.vo.Neuronio;
import br.edu.ufu.bcc.ic.view.ResultadoView;

public class Principal {
	public static void main(String[] args) {
		try {
			Treinamento t = new Treinamento();
			t.executar();
			List<Neuronio> lista = t.getNeuronios();
			ResultadoView resultadoView = new ResultadoView(lista);
			resultadoView.exibir();
			System.out.println("Erro: " + t.getErro());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
