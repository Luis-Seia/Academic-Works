
/**
*
*@Avalicao: TPC2
*@disciplina: Programacao II - C
*
*@authors: 
*    -David Junior
*    -Luis Seia
*    -Tarcilenia
*
*@turma: LECC 21
*
*
*/
package Produtos;
public class Produto {

	private String nomeProduto;
	private String marca;
	private int garantia; 	//Numero de anos que esta sob garantia
	private double preco;
	private boolean perecivel;
	
	public Produto() {}

	public Produto(String nomeProduto, String marca, int garantia, double preco, boolean perecivel) {
		this.nomeProduto = nomeProduto;
		this.marca = marca;
		this.garantia = garantia;
		this.preco = preco;
		this.perecivel = perecivel;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getGarantia() {
		return garantia;
	}
	public void setGarantia(int garantia) {
		this.garantia = garantia;
	}
	// public String getId() {
	// 	return id;
	// }
	// public void setId(String id) {
	// 	this.id = id;
	// }
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public boolean isPerecivel() {
		return perecivel;
	}
	public void setPerecivel(boolean perecivel) {
		this.perecivel = perecivel;
	}


	@Override
	public String toString() {
		return nomeProduto + "|" + marca + "|" + garantia + "|" + preco + "|" + perecivel + ">";
	}

	public String verDetalhes() {
		return "\n\tNome do Produto: " + nomeProduto 
			+ "\n\t\t-Marca: " + marca 
			+ "\n\t\t-Garantia: " + garantia 
			+ "\n\t\t-Preco: " + preco 
			+ "\n\t\t-perecivel: " + perecivel;
	}
	
}
