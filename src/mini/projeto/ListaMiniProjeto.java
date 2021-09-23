package mini.projeto;

public class ListaMiniProjeto implements TListaMiniProjeto {

	// Lista duplamente encadeada + ordenada 
	private No inicio;
	private No fim;
	
	public void add(String s) throws Exception {
		No elemento = new No(s);
		
		if (inicio == null) {
			inicio = elemento;
			fim = elemento;
			
		} else if (s.compareToIgnoreCase(inicio.getDado()) < 0) {
			No auxiliar = inicio;
			inicio = elemento;
			elemento.setSucessor(auxiliar);
			auxiliar.setAntecessor(elemento);
			
			
		} else if (s.compareToIgnoreCase(fim.getDado()) > 0) {
			No auxiliar = fim;
			fim = elemento;
			elemento.setAntecessor(auxiliar);
			auxiliar.setSucessor(elemento);
			
		} else {
			No anterior = inicio;
			No auxiliar = inicio.getSucessor();
			boolean isInserido = false;
			
			while (auxiliar != null) {
				
				if (s.compareToIgnoreCase(anterior.getDado()) > 0 && s.compareToIgnoreCase(auxiliar.getDado()) < 0) {
					isInserido = true;
					break;
				}
				
				anterior = auxiliar;
				auxiliar = auxiliar.getSucessor();
				
			}
			
			if (isInserido) {
				anterior.setSucessor(elemento);
				elemento.setAntecessor(anterior);
				
				auxiliar.setAntecessor(elemento);
				elemento.setSucessor(auxiliar);
				
			} else {
				throw new Exception("Elementos repetidos não são permitidos!");
			}
			
		}
	}

	public String removeIndex(int i) throws Exception {
		if (i < 0 || i >= size()) {
			throw new Exception("Índice inválido!");
		}
		
		No lixo = null;
		
		if (i == 0) {
			lixo = inicio;
			inicio = lixo.getSucessor();
		
			inicio.setAntecessor(null);
			lixo.setSucessor(null);
			
		} else if (i == size() - 1) {
			lixo = fim;
			fim = lixo.getAntecessor();
			
			fim.setSucessor(null);
			lixo.setAntecessor(null);
			
		} else {
			No auxiliar = inicio;
			
			for (int j = 0; j < i; j++) {
				auxiliar = auxiliar.getSucessor();
			}
			
			lixo = auxiliar;
			
			lixo.getAntecessor().setSucessor(lixo.getSucessor());
			lixo.setAntecessor(null);
			
			lixo.getSucessor().setAntecessor(lixo.getAntecessor());
			lixo.setSucessor(null);
		}
		
		
		return lixo.getDado();
	}

	

	public String previous(String s) throws Exception {
		boolean pertenceALista = false;
		
		No elemento = null;
		
		if (s.compareTo(inicio.getDado()) == 0) {
			throw new Exception("O primeiro elemento da lista não possui antecessor!");
			
		} else if (s.compareToIgnoreCase(fim.getDado()) == 0) {
			elemento = fim;
			pertenceALista = true;
			
		} else {
			No auxiliar = inicio;
			
			while (auxiliar != null) {
				if (s.compareToIgnoreCase(auxiliar.getDado()) == 0) {
					elemento = auxiliar;
					pertenceALista = true;
				}
				
				auxiliar = auxiliar.getSucessor();
			}
		}
		
		if (!pertenceALista) {
			throw new Exception("O elemento informado não pertence à lista!");
		}
		
		return elemento.getAntecessor().getDado();
	}

	public String elemen(int i) throws Exception {
		if (i < 0 || i >= size()) {
			throw new Exception("Índice inválido!");
		}
		
		No elemento = null;
		
		if (i == 0) {
			elemento = inicio;
		} else if (i == size() - 1) {
			elemento = fim;
			
		} else {
			No auxiliar = inicio;
			for (int j = 0; j < i; j++) {
				auxiliar = auxiliar.getSucessor();
			}
			
			elemento = auxiliar;
		}
		
		return elemento.getDado();
	}


	public int size() {
		int qtd = 0;
		No auxiliar = inicio;
		
		while (auxiliar != null) {
			qtd++;
			auxiliar = auxiliar.getSucessor();
		}
		
		return qtd;
	}

	public String maior() {
		return fim.getDado();
	}
	
	
	// Segunda parte: 
	
	public void add(String s, int i) throws Exception {
		throw new UnsupportedOperationException("Essa operação não é permitida para listas ordenadas");
	}
	
	public void removeElem(String s) throws Exception {
		No lixo = null;
		
		if (s.compareToIgnoreCase(inicio.getDado()) == 0) {
			lixo = inicio;
			inicio = lixo.getSucessor();
			
			inicio.setAntecessor(null);
			lixo.setSucessor(null);
			
		} else if (s.compareToIgnoreCase(fim.getDado()) == 0) {
			lixo = fim;
			fim = lixo.getAntecessor();
			
			fim.setSucessor(null);
			lixo.setAntecessor(null);
		} else {
			No auxiliar = inicio;
			
			while (auxiliar != null) {
				if (s.compareToIgnoreCase(auxiliar.getDado()) == 0) {
					break;
				}
				auxiliar = auxiliar.getSucessor();
			}
			
			lixo = auxiliar;
			
			if (lixo != null) {
				lixo.getAntecessor().setSucessor(lixo.getSucessor());
				lixo.getSucessor().setAntecessor(lixo.getAntecessor());
				
				lixo.setAntecessor(null);
				lixo.setSucessor(null);
			} else {
				throw new Exception("O elemento informado não pertence à lista!");
			}
		}
	}
	
	public int index(String s) throws Exception {
		int indice = 0;
		
		if (s.compareToIgnoreCase(fim.getDado()) == 0) {
			indice = size() - 1;
		} else {
			No auxiliar = inicio;
			boolean pertenceALista = false;
			
			while (auxiliar != null) {
				if (s.compareToIgnoreCase(auxiliar.getDado()) == 0) {
					pertenceALista = true;
					break;
				}
				
				indice += 1;
				auxiliar = auxiliar.getSucessor();
			}
			
			if (!pertenceALista) {
				throw new Exception("O elemento informado não pertence à lista!");
			}
		}
		
		return indice;
	}

	public String first() {
		return inicio.getDado();
	}
	
	public String last() {
		return fim.getDado();
	}
	
	public void print() {
		No auxiliar = inicio;
		
		System.out.print("Início -> ");
		while (auxiliar != null) {
			System.out.print(auxiliar.getDado() + " -> ");
			auxiliar = auxiliar.getSucessor();
		}
		
		System.out.println("Fim");
	}
}
