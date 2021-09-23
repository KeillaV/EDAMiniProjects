package mini.projeto;


public class No {
	
	private String dado;
	private No sucessor;
	private No antecessor;
	
	public No(String dado) {
		this.dado = dado;
	}

	public String getDado() {
		return dado;
	}

	public void setDado(String dado) {
		this.dado = dado;
	}

	public No getSucessor() {
		return sucessor;
	}

	public void setSucessor(No sucessor) {
		this.sucessor = sucessor;
	}

	public No getAntecessor() {
		return antecessor;
	}

	public void setAntecessor(No antecessor) {
		this.antecessor = antecessor;
	}
	
	
}
