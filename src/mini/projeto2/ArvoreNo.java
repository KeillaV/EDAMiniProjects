package mini.projeto2;

public class ArvoreNo {
	
	private User usuario;
	private ArvoreNo esquerda;
	private ArvoreNo direita;
	
	public ArvoreNo(User dado) {
		this.usuario = dado;	
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User dado) {
		this.usuario = dado;
	}

	public ArvoreNo getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(ArvoreNo esquerda) {
		this.esquerda = esquerda;
	}

	public ArvoreNo getDireita() {
		return direita;
	}

	public void setDireita(ArvoreNo direita) {
		this.direita = direita;
	}
	
}
