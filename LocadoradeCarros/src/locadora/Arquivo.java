package locadora;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {
    List <Locadora> locadoras = new ArrayList <Locadora>();
	Locadora p;
		
	public List ler() { //le os dados do arquivo
		File dir = new File("C:\\Arquivos");
        File arq = new File(dir, "LocadoraCarro.txt");
        String linha = "";
        List <String> result = new ArrayList<String>(); 
        
        try {
        	FileReader fileReader = new FileReader(arq);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            linha = bufferedReader.readLine(); // Le a primeira linha
            while (linha!=null){
            	result.add(linha);
            	 	linha = bufferedReader.readLine(); // Le a segunda ate a ultima linha
            }
           
            fileReader.close();
            bufferedReader.close();
            for (String s : result) {
            		//System.out.println(s);
	                String[] cliente = s.split(":"); //metodo split da classe String para separar as partes entre dois pontos, guardando resultado no array cliente.
	
	                //Objeto p e setando em seus atributos as posicoes correspondentes do array
	                p = new Locadora();
	                p.settipoCliente(cliente[0]);
	                p.setqtdPassageiros(Integer.parseInt(cliente[1]));
	                p.setDataDiaLocacao(cliente[2]);
	                locadoras.add(p);
            }
            
    	} catch (IOException e) {
        	e.printStackTrace();
        }
		return locadoras;
       
    } 
}
