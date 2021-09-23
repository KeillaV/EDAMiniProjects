package mini.projeto2;

import java.util.ArrayList;

public class TabelaHash implements THashMiniProjeto {

	// Tabela hash usando método da divisão, com tratamento de colisões por endereçamento fechado com árvore
	private ArvoreBB[] tabela;
	private int qtd;
	
	public TabelaHash() {
		tabela = new ArvoreBB[11];
	}
	
	public int hash(int id) {
		int indice = id % tabela.length;
		return indice;
	}

	public boolean isCheia() {
		return false;
	}

	public void adicionar(User u) throws Exception {
		int indice = hash(u.getId());
		
		if (tabela[indice] == null) {
			tabela[indice] = new ArvoreBB();
		}
		
		tabela[indice].adicionar(u);
		qtd++;
	}

	public User recuperar(int id) throws Exception {
		int indice = hash(id);
		User usuario = null;
		
		if (tabela[indice] != null) {
			usuario = tabela[indice].recuperar(id);
		}
		
		if (usuario == null) {
			throw new Exception("Usuário não encontrado!");
		}
		
		return usuario;
	}

	public void print() {
		int tamanho = tabela.length;
		
		for (int i = 0; i < tamanho; i++) {
			ArvoreBB arvore = tabela[i];
			System.out.print("(" + i + ") -> ");
			
			if (arvore != null) {
				System.out.print("RAIZ -> ");
				arvore.preOrdem();
				System.out.println("FIM");
			} else {
				System.out.println("VAZIO");
			}
		}
	}

	public void crescer() throws Exception {
		ArvoreBB[] tabelaAntiga = tabela;
		tabela = new ArvoreBB[tabela.length * 2];
		
		for (ArvoreBB arvore: tabelaAntiga) {
			if (arvore != null) {
				ArrayList<User> usuarios = arvore.converterParaLista();
				
				for (User usuario: usuarios) {
					adicionar(usuario);
				}
			}
		}
	}

	public int qtd() {
		return qtd;
	}	
}
