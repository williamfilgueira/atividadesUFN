package praticando03;

public class FolhaDePagamento {
	private double salarioMinimo = 1100;
	private double salarioAtual;
	
	public void showFolhaDePagamento(Colaborador colaborador) {
		System.out.println("Nome:"+colaborador.getNome());
		System.out.println("Cargo:"+colaborador.getCargo());
		System.out.println("Setor:"+colaborador.getSetor());
		System.out.println("Salário:"+colaborador.getSalario());
		salarioAtual = Double.parseDouble(colaborador.getSalario());
		System.out.println("==================================");
		System.out.println("Salário atual"+colaborador.getSalario());
		System.out.println("Salário minímo:"+ salarioMinimo);
		System.out.println("Comparação com o minímo:" + comparacaoSalario());
		
	}
	
	public double comparacaoSalario() {
		double comparacao;
		comparacao = salarioAtual / salarioMinimo;
		return comparacao;
	}
	
}
