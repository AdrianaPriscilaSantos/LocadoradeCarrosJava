package locadora;


import java.util.List;
import java.util.Random;


public class AnalisaDados {
		
	//strings para comparar os dias da semana
	static String SEG = "seg";
	static String TER = "ter";
	static String QUA = "qua";
	static String QUI = "qui";
	static String SEX = "sex";
	static String SAB = "sab";
	static String DOM = "dom";
    
    //variaveis das taxas
	static int SOUTHCAR = 0;
	static int WESTCAR = 0;
	static int NORTHCAR = 0;
     
	public static void main(String[] args) {
		Arquivo arquivo = new Arquivo();
		List<Locadora> locadoras= arquivo.ler();  
		
		verificaTipoDoCliente(locadoras);
	}
	
		
	public static void verificaTipoDoCliente(List<Locadora> locadoras){
		//verifica se o cliente � fidelidade - PREMIUM ou regular - NORMAL
		// e tamb�m verifica qual o dia da semana a ser alugado
		
		for(Locadora c : locadoras){ 
			System.out.println("_______");
			System.out.println("INPUT:" );
			System.out.println(c.tipoCliente()+":"+c.qtdPassageiros()+":"+c.datadiaLocacao());
			System.out.println("OUTPUT");
			
    	if ((c.tipoCliente().equalsIgnoreCase("Premium"))) { // PREMIUM
    		if(c.datadiaLocacao().contains(SEG)||c.datadiaLocacao().contains(TER)||c.datadiaLocacao().contains(QUA)
        	||c.datadiaLocacao().contains(QUI)||c.datadiaLocacao().contains(SEX)) {
    			verificaMaisBaratoPremiumSemanal(c);
        	}
        	else if (c.datadiaLocacao().contains(SAB)||c.datadiaLocacao().contains(DOM)){
        		verificaMaisBaratoPremiumFds(c);
        	}
        	else {
        	System.out.println("Dia da semana invalido."); 
        	}
    	}
    	else if ((c.tipoCliente().equalsIgnoreCase("Normal"))) { //Normal
    		if(c.datadiaLocacao().contains(SEG)||c.datadiaLocacao().contains(TER)||c.datadiaLocacao().contains(QUA)
        	||c.datadiaLocacao().contains(QUI)||c.datadiaLocacao().contains(SEX)) {
    			verificaMaisBaratoNormalSemanal(c);
            }
        	else if (c.datadiaLocacao().contains(SAB)||c.datadiaLocacao().contains(DOM)){
        		verificaMaisBaratoNormalFds(c);
        	}
        	else {
        		System.out.println("Dia da semana invalido."); 
        	} 	
        }
        else {
           	System.out.println("Tipo do cliente informado invalido."); 
        }
		}       
    }
    
	public static void verificaMaisBarato(int SOUTHCAR, int WESTCAR, int NORTHCAR, Locadora c){ //condicoes para verificar qual taxa e menor
		
		if ((c.qtdPassageiros()==1)||(c.qtdPassageiros()==2)){
    		if ((SOUTHCAR<WESTCAR)&&(SOUTHCAR<NORTHCAR)){
    			sorteiaCompacto();
    			System.out.println(" : Southcar ");
    		}
    		else if ((WESTCAR<SOUTHCAR)&&(WESTCAR<NORTHCAR)){
    			sorteiaEsportivo();
    			System.out.println(": Westcar ");
    		}
    		else if ((NORTHCAR<SOUTHCAR)&&(NORTHCAR<WESTCAR)){
    			sorteiaSuv();
    			System.out.println(": Northcar");
    		}	    		
    		else if ((SOUTHCAR==WESTCAR)&&(SOUTHCAR<NORTHCAR)){
    			sorteiaCompacto();
    			System.out.println(" : Southcar ");
    			System.out.println(" ou ");
    			sorteiaEsportivo();
    			System.out.println(" : WestCar");
    		}
    		else if ((SOUTHCAR==NORTHCAR)&&(SOUTHCAR<WESTCAR)){
    			sorteiaCompacto();
    			System.out.println(" : Southcar ");
    			System.out.println(" ou ");
    			sorteiaSuv();
    			System.out.println("ou Northcar");
    		}
    		else if ((WESTCAR==NORTHCAR)&&(WESTCAR<SOUTHCAR)){
    			sorteiaEsportivo();
    			System.out.println(" : WestCar");
    			System.out.println(" ou ");
    			sorteiaSuv();
    			System.out.println("ou Northcar");
    		}
		}
    	else if ((c.qtdPassageiros()==3)||(c.qtdPassageiros()==4)){
    		if ((WESTCAR<NORTHCAR)){
    			sorteiaEsportivo();
    			System.out.println(" : WestCar");
    		}
    		else if (NORTHCAR<WESTCAR){
    			sorteiaSuv();
    			System.out.println("Northcar");
    		}
    		else {
    			sorteiaEsportivo();
    			System.out.println(" : WestCar");
    			System.out.println(" ou ");
    			sorteiaSuv();
    			System.out.println(" : Northcar");
    		}
    	}
    	else if ((c.qtdPassageiros()>4)&&(c.qtdPassageiros()<8)){
    		sorteiaSuv();
    		System.out.println(" : Northcar");    
    	}
    	else{
    		System.out.println("Quantidade de passageiros informada nao esta entre 1 e 7"); 	
    	}
		
	}
	public static void verificaMaisBaratoPremiumSemanal(Locadora c){
		int SOUTHCAR = 150;
		int WESTCAR = 150;
		int NORTHCAR = 580;
		verificaMaisBarato(SOUTHCAR,WESTCAR,NORTHCAR, c);
	}
	public static void verificaMaisBaratoPremiumFds(Locadora c){
		SOUTHCAR = 90;
		WESTCAR = 90;
		NORTHCAR = 590;
		verificaMaisBarato(SOUTHCAR,WESTCAR,NORTHCAR, c);
		 
	 }
	public static void verificaMaisBaratoNormalSemanal(Locadora c){
		SOUTHCAR = 210;
		WESTCAR = 530;
		NORTHCAR = 630;
		verificaMaisBarato(SOUTHCAR,WESTCAR,NORTHCAR, c);
		 
	 }
	public static void verificaMaisBaratoNormalFds( Locadora c){
		SOUTHCAR = 200;
		WESTCAR = 200;
		NORTHCAR = 600;
		verificaMaisBarato(SOUTHCAR,WESTCAR,NORTHCAR, c);
		 
	 }
	public static void sorteiaEsportivo() {
		 String carrosEsportivos[] = { "Renault Sandero", "Suzuki Swift Sport", "Peugeot 208GT", "Fiat Bravo T-Jet", "Citroen DS3", "Fiat 500 Abarth", "Volkswagen Jetta Highline", "Volkswagen Fusca", "Audi A1 Sportback Ambition", "Volkswagen Golf GTI" };
	     Random random = new Random();
	     String CarroEsportivo = carrosEsportivos[random.nextInt(carrosEsportivos.length)];
	     System.out.print(CarroEsportivo);
	}

	public static void sorteiaCompacto() {
		String carrosCompactos[] = {"Fiat Palio Fire", "Chery New QQ", "Fiat Mobi", "Volkswagem Up", "Volkswagen Gol", "Renault Clio", "Chery Celer", "Nissan March", "Chevrolet Onix", "Fiat Uno"  };
	    Random random = new Random();
	    String CarroCompacto = carrosCompactos[random.nextInt(carrosCompactos.length)];
	    System.out.print(CarroCompacto);
	}

	public static void sorteiaSuv() {
		String carrosSuvs[] = {"Honda HR-V", "Jeep Compass", "Jeep Renegade", "Hyundai Creta", "Ford EcoSport", "Nissan Kicks", "Renault Duster", "Toyota SW4", "Honda WR-V", "Chevrolet Tracker"};
	    Random random = new Random();
	    String CarroSuv = carrosSuvs[random.nextInt(carrosSuvs.length)];
	    System.out.print(CarroSuv);
	}
    	    	
    	    	
    	    	 		
}
    	    			
    	    			

    
