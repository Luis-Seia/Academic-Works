
/**
*
*@Avalicao: TPC2
*@disciplina: Programacao II - C
*
*@authors: 
*    -David Junior
*    -Luis Seia
*    -Tarcilenia
*/
package Funcionalidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.StringTokenizer;

import BaseDados.BaseDados;
import Produtos.Produto;

public abstract class Funcoes {


    public static void saltarLinhas(){
        System.out.println("\n\n\n\n\n\n\n");
    }

    public static Produto getProduto(String id){
        return BaseDados.map.get(id);
    }

    public static HashMap<String, Produto> lerProdutosFicheiro(){
            
        StringBuilder sb = new StringBuilder();

        //Leitura de ficheiros
        try{
            File f = new File(BaseDados.path);

            BufferedReader br = new BufferedReader(new FileReader(f));

            int linha = 0;
            while((linha = br.read()) != -1){
                sb.append((char)linha);
            }
            br.close();
        }catch(Exception e){
            System.out.print("ERRO AO LER O FICHEIRO: ");
            e.printStackTrace();
        }


        StringTokenizer st = new StringTokenizer(sb.toString(), "\n");

        HashMap<String,Produto> map = new HashMap<String, Produto>();
        while(st.hasMoreTokens()){
            String produtoString = st.nextToken();
            // <id1|Protese|Jewwl|2|2.0|false>    Exemplo de como um produto esta representado no ficheito .txt
            String id = produtoString.substring(1, produtoString.indexOf('|'));
            //-----------------------------------------------------------------------------
            produtoString = produtoString.replace(produtoString.substring(1, produtoString.indexOf('|')+1), "");
            String nome = produtoString.substring(1, produtoString.indexOf('|'));
            //-----------------------------------------------------------------------------
            produtoString = produtoString.replace(produtoString.substring(1, produtoString.indexOf('|')+1), "");
            String marca= produtoString.substring(1, produtoString.indexOf('|'));
            //-----------------------------------------------------------------------------
            produtoString = produtoString.replace(produtoString.substring(1, produtoString.indexOf('|')+1), "");
            String garant = produtoString.substring(1, produtoString.indexOf('|'));
            int garantia = Integer.parseInt(garant);
            //-----------------------------------------------------------------------------
            produtoString = produtoString.replace(produtoString.substring(1, produtoString.indexOf('|')+1), "");
            String prec = produtoString.substring(1, produtoString.indexOf('|'));
            double preco = Double.parseDouble(prec);
            //-----------------------------------------------------------------------------
            produtoString = produtoString.replace(produtoString.substring(1, produtoString.indexOf('|')+1), "");
            String perec = produtoString.substring(1, produtoString.indexOf('>'));
            boolean perecivel = Boolean.parseBoolean(perec);

            Produto produto = new Produto(nome, marca, garantia, preco, perecivel);
            map.put(id, produto);

        }
        return map;
    }



}
