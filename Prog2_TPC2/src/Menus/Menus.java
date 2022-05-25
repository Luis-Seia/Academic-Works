
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
package Menus;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import BaseDados.BaseDados;
import Funcionalidades.Funcoes;
import Produtos.Produto;

public abstract class Menus {
	
	static Scanner ler = new Scanner(System.in) ;
	
	public static void telaInicial() {

		Funcoes.saltarLinhas();
		System.out.println("\t---------------------------------------------------");
		System.out.println("\t           M E N U    P R I N C I P A L    ");
		System.out.println("\t---------------------------------------------------");
		System.out.println();
		System.out.println("\ta. Introduzir novo produto");
		System.out.println("\tb. Ver detalhes do produto");
		System.out.println("\tc. Alterar detalhes do produto");
		System.out.println("\td. Remover produtos");
		System.out.println("\te. Ver todos produtos");
		System.out.println("\tf. Sair");
		System.out.println("\t___________________________________________________");
		System.out.print("\tESCOLHA: ");
		
		try {
			char escolha = ler.next().charAt(0);
			ler.nextLine();
			

			switch(escolha){
				case 'a': 
					Funcoes.saltarLinhas();
					try {
						novoProduto();
					} catch (InputMismatchException e) {
						System.out.println("\n\tEntrada inválida! \n\tInsira o tipo de dado correto.");
					}
					break;

				case 'b':
					Funcoes.saltarLinhas();
					verDetalhesProduto();
					
					break;

				case 'c':
					Funcoes.saltarLinhas();
					try {
						alterarDetalhes();
					} catch (InputMismatchException e) {
						System.out.println("\n\tEntrada inválida! \n\tInsira o tipo de dado correto.");
					}
					break;

				case 'd':
					Funcoes.saltarLinhas();
					try {
						removerProdutos();
					} catch (InputMismatchException e) {
						System.out.println("\n\tEntrada inválida! \n\tInsira o tipo de dado correto.");
					}
					break;

				case 'e':
					Funcoes.saltarLinhas();
					verTodosProdutos();
					break;

				case 'f':
					Funcoes.saltarLinhas();
					telaSaida();
					break;

				default:
					System.out.println("\n\tEscolha inválida, insira \n\tum dos caracteres do menu.");
					telaInicial();
					break;
			}
		}catch (Exception e) {
			System.out.println("\tEntrada inválida, insira um caracater!");
			e.printStackTrace();
		}
		// finally {
			
		// }
	}


	public static void novoProduto() throws InputMismatchException{
		System.out.println("\t     N O V O S     P R O D U T O S     ");
		System.out.println("\t----------------------------------------");
		
		Produto novo_produto = new Produto();

	
		System.out.print("\tInsira o id do produto: ");
		String id = ler.nextLine();

		System.out.print("\tInsira o nome do produto: ");
		novo_produto.setNomeProduto(ler.nextLine());

		System.out.print("\tInsira a marca do produto: ");
		novo_produto.setMarca(ler.nextLine());

		System.out.print("\tInsira o preco do produto: ");
		novo_produto.setPreco(ler.nextDouble());
		
		System.out.print("\tInsira número de anos da garantia: ");
		novo_produto.setGarantia(ler.nextInt());
		
		System.out.print("\tO produto é perecível? (true/ false): ");
		novo_produto.setPerecivel(ler.nextBoolean());

		BaseDados.salvarProdutoMap(id, novo_produto);

		Funcoes.saltarLinhas();
		telaInicial();		 
	}

	public static void verDetalhesProduto(){
		System.out.println("\t        V E R    D E T A L H E S        ");
		System.out.println("\t----------------------------------------");
		System.out.print("\n\tInsira o id do produto: ");
		String id = ler.nextLine();

		HashMap<String, Produto> lista_produtos = Funcoes.lerProdutosFicheiro(); 
		
		Produto prod = (Produto) lista_produtos.get(id);
		if(prod != null){
			System.out.println(prod.verDetalhes());
		}else{
			System.out.println("\tProduto nao encontrado!");
		}
		Funcoes.saltarLinhas();
		telaInicial();
	}

	public static void alterarDetalhes() throws InputMismatchException{
		System.out.println("\t     A L T E R A C A O    D E    D E T A L H E S        ");
		System.out.println("\t--------------------------------------------------------");
		System.out.print("\n\tInsira o id do produto: ");
		String id = ler.nextLine();
		HashMap<String, Produto> lista_produtos = Funcoes.lerProdutosFicheiro(); 
		
		Produto prod = (Produto) lista_produtos.get(id);
		if(prod != null){
			System.out.println(prod.verDetalhes());
			System.out.print("\n\tNovo nome: ");
			prod.setNomeProduto(ler.nextLine());
			
			System.out.print("\tNova marca: ");
			prod.setMarca(ler.nextLine());
			
			System.out.print("\tNovo tempo de garantia: ");
			prod.setGarantia(ler.nextInt());
			
			System.out.print("\tNovo preco: ");
			prod.setPreco(ler.nextDouble());
			
			System.out.print("\tÉ perecível? (true/false): ");
			prod.setPerecivel(ler.nextBoolean());

			if(BaseDados.salvarProdutoPermanentemente(lista_produtos)){
				System.out.print("\tProduto alterado com sucesso!");
			}else{
				System.out.print("\tErro ao alterar produto!");
			}

		}else{
			System.out.println("\tProduto nao encontrado!");
		}
		telaInicial();
	}

	public static void removerProdutos() throws InputMismatchException{
		System.out.println("\t        R E M O C A O    D E    D E T A L H E S        ");
		System.out.println("\t--------------------------------------------------------");
		System.out.print("\n\tInsira o id do produto: ");
		String id = ler.nextLine();
		HashMap<String, Produto> lista_produtos = Funcoes.lerProdutosFicheiro(); 
		
		Produto prod = (Produto) lista_produtos.get(id);
		if(prod != null){
			lista_produtos.remove(id);
			if(BaseDados.salvarProdutoPermanentemente(lista_produtos)){
				System.out.print("\tProduto removido com sucesso!");
			}else{
				System.out.print("\tErro ao remover produto!");
			}
		}else{
			System.out.println("\tProduto nao encontrado!");
		}
		BaseDados.salvarProdutoPermanentemente(lista_produtos);
		telaInicial();
	}
	
	public static void verTodosProdutos(){
		System.out.println("\t     T O D O S    P R O D U T O S       ");
		System.out.println("\t----------------------------------------");
		HashMap<String, Produto> lista_produtos = Funcoes.lerProdutosFicheiro();

		Set<Map.Entry<String, Produto>> set = lista_produtos.entrySet();
		for(Map.Entry<String, Produto> prod : set){
			System.out.println(prod.getValue().verDetalhes());
		}
		telaInicial();
	}

	public static void telaSaida(){
		Funcoes.saltarLinhas();
		if(BaseDados.salvarProdutoPermanentemente()){
			System.out.print("\n\tInformacoes salvas com sucesso!");
		}else{
			System.out.print("\n\tErro ao salvar ficheiro!");
		}
		System.out.println("\n\t-----PROGRAMA TERMINADO!-----");

	} 
	
}
