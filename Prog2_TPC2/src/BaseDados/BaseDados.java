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


package BaseDados;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Produtos.Produto;

public class BaseDados {


    public final static String path = "src\\BaseDados\\lista_produtos.txt";

    public static HashMap<String,Produto> map = new HashMap<String, Produto>();

    public static void salvarProdutoMap(String id, Produto produto){
        BaseDados.map.put(id, produto);
        System.out.println("\n\tInformacoes salvas temporariamente!");
    }


    public static boolean salvarProdutoPermanentemente(){
        
        boolean salvo = false;

        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        //Escrita em ficheiros
        try {

            fos = new FileOutputStream(path,true);
            //O argumento true serve para indicar que nao sobrescrever o conteudo do ficheiro
            bos = new  BufferedOutputStream(fos);

            Set<Map.Entry<String, Produto>> set = map.entrySet();
            for(Map.Entry<String, Produto> prod : set){
                
                String texto = "<" + prod.getKey() +"|"+ prod.getValue() +" \n";

                byte[] textoByte = texto.getBytes(StandardCharsets.UTF_8);
                bos.write(textoByte);
            }

            bos.flush();
            bos.close();
            fos.close();
            salvo = true;

        } catch (Exception e) {
            salvo = false;
            System.out.print("ERRO AO SALVAR: ");
            e.printStackTrace();
        }finally{
            
        }
        return salvo;
    }


    public static boolean salvarProdutoPermanentemente(HashMap<String, Produto> novo_map){
        
        boolean salvo = false;

        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        //Escrita em ficheiros
        try {

            fos = new FileOutputStream(path);
            //Agora vamos obrescrever o conteudo do ficheiro
            //Porque o nosso novo_map tem toda informacao anterior
            //e o produto com os detalhes alterados
            bos = new  BufferedOutputStream(fos);

            Set<Map.Entry<String, Produto>> novo_set = novo_map.entrySet();
            for(Map.Entry<String, Produto> prod : novo_set){
                
                String texto = "<" + prod.getKey() +"|"+ prod.getValue() +" \n";

                byte[] textoByte = texto.getBytes(StandardCharsets.UTF_8);
                bos.write(textoByte);
            }

            bos.flush();
            bos.close();
            fos.close();
            salvo = true;

        } catch (Exception e) {
            salvo = false;
            System.out.print("ERRO AO SALVAR: ");
            e.printStackTrace();
        }
        // finally{
            
        // }
        return salvo;
    }
    
}
