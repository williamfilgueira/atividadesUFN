package interfaceVeiculo;

public class Veiculo {

	private int ID;
	private String marca;
	private String modelo;
	private String placa;
	private String ano_fabricacao;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getAno_fabricacao() {
		return ano_fabricacao;
	}

	public void setAno_fabricacao(String ano_fabricacao) {
		this.ano_fabricacao = ano_fabricacao;
	}
}
