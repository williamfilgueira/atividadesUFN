package praticando03;

public class FolhaDePagamento {
	private double salarioMinimo = 1100;
	private double salarioAtual;
	
	public void showFolhaDePagamento(Colaborador colaborador) {
		System.out.println("Nome:"+colaborador.getNome());
		System.out.println("Cargo:"+colaborador.getCargo());
		System.out.println("Setor:"+colaborador.getSetor());
		System.out.println("Sal�rio:"+colaborador.getSalario());
		salarioAtual = Double.parseDouble(colaborador.getSalario());
		System.out.println("==================================");
		System.out.println("Sal�rio atual"+colaborador.getSalario());
		System.out.println("Sal�rio min�mo:"+ salarioMinimo);
		System.out.println("Compara��o com o min�mo:" + comparacaoSalario());
		
	}
	
	public double comparacaoSalario() {
		double comparacao;
		comparacao = salarioAtual / salarioMinimo;
		return comparacao;
	}
	
}
