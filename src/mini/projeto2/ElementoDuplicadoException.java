package mini.projeto2;

public class ElementoDuplicadoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ElementoDuplicadoException() {
		super("O elemento informado j� est� inserido na lista!");
	}

}
