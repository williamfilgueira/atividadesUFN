package praticando03;

import javax.swing.JOptionPane;

public class App {

	public static void main(String[] args) {
		
		Colaborador colaborador = new Colaborador();
		FolhaDePagamento fPagamento = new FolhaDePagamento();
		
		System.out.println("=====================================");
		System.out.println("====== SALARIO COLABORADOR ==========");
		colaborador.setNome(JOptionPane.showInputDialog("Digite o nome do colaborador"));
		colaborador.setCargo(JOptionPane.showInputDialog("Digite o cargo do colaborador"));
		colaborador.setSetor(JOptionPane.showInputDialog("Digite o setor do colaborador"));
		colaborador.setSalario(JOptionPane.showInputDialog("Digite o salário do colaborador"));
		
		
		fPagamento.showFolhaDePagamento(colaborador);
		
	}

}
