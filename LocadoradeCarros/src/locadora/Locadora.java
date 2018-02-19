package locadora;

public class Locadora {
	private  String dataeDiaLocacao;
	private  String tipoCliente;
	private  int qtdPassageiros;
		    
	    public String datadiaLocacao () {
	        return dataeDiaLocacao;
	    }
	    public void setDataDiaLocacao (String dataeDiaLocacao) {
	        this.dataeDiaLocacao = dataeDiaLocacao;
	    }
	    
	   	    
	    public int qtdPassageiros() {
	        return qtdPassageiros;
	    }

	    public void setqtdPassageiros(int qtdPassageiros) {
	        this.qtdPassageiros = qtdPassageiros;
	    }
	    
	    public String tipoCliente() {
	        return tipoCliente;
	    }

	    public void settipoCliente(String tipoCliente) {
	        this.tipoCliente = tipoCliente;
	    }
	    
	    


}
