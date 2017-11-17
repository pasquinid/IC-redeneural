import java.util.List;

import br.edu.ufu.bcc.ic.model.bo.Treinamento;
import br.edu.ufu.bcc.ic.model.vo.Neuronio;
import br.edu.ufu.bcc.ic.view.ResultadoView;

public class Principal {
	public static void main(String[] args) {
		try {
			Treinamento t = new Treinamento();
			t.executar();
                        System.out.println("____Processo de treinamento___");
			List<Neuronio> lista = t.getNeuronios();
			ResultadoView resultadoView = new ResultadoView(lista);
			resultadoView.exibir();
			System.out.println("Erro de treinamento: " + t.getErro());
                        System.out.println("____Processo de Teste___");
                        t.executarTeste();
                        List<Neuronio> lista2 = t.getNeuronios();
			ResultadoView resultadoView2 = new ResultadoView(lista2);
			resultadoView2.exibir();
			System.out.println("Erro de teste: " + t.getErro());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
