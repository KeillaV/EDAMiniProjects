package mini.projeto2;

import java.util.ArrayList;

public class ArvoreBB {

	private ArvoreNo raiz;
	
	public void adicionar(User k) throws ElementoDuplicadoException {
		if (isVazia()) {
			raiz = new ArvoreNo(k);
		} else {
			adicionar(raiz, k);
		}
	}

	private void adicionar(ArvoreNo raizSub, User k) throws ElementoDuplicadoException {
		if (raizSub.getUsuario().getId() == k.getId()) {
			throw new ElementoDuplicadoException();
			
		} else if (k.getId() < raizSub.getUsuario().getId()) {
			
			if (raizSub.getEsquerda() == null) {
				raizSub.setEsquerda(new ArvoreNo(k));
			} else {
				adicionar(raizSub.getEsquerda(), k);
			}
			
		} else {
			
			if (raizSub.getDireita() == null) {
				raizSub.setDireita(new ArvoreNo(k));
			} else {
				adicionar(raizSub.getDireita(), k);
			}
		}
	}
	
	public boolean isVazia() {
		return (raiz == null);
	}
	
	public User recuperar(int id) {
		ArvoreNo auxiliar = raiz;
		
		while (auxiliar != null) {
			if (auxiliar.getUsuario().getId() == id) {
				return auxiliar.getUsuario();
				
			} else if (id < auxiliar.getUsuario().getId()) {
				auxiliar = auxiliar.getEsquerda();
			} else {
				auxiliar = auxiliar.getDireita();
			}
		}
		
		return null;
	}

	public int quantidadeDeNos() {
		if (!isVazia()) {
			return quantidadeDeNos(raiz);
		}
		
		return 0;
	}
	
	private int quantidadeDeNos(ArvoreNo raizSub) {
		if (raizSub == null) {
			return 0;
		} else {
			return 1 + quantidadeDeNos(raizSub.getEsquerda()) + quantidadeDeNos(raizSub.getDireita());
		}
	}
	
	public void preOrdem() {
		preOrdem(raiz);
	}
	
	private void preOrdem(ArvoreNo raizSub) {
		if (raizSub == null) {
			return;
		} 
		
		User usuario = raizSub.getUsuario();
		
		System.out.print(usuario.getNome() + " (ID " + usuario.getId() + ") -> ");
		preOrdem(raizSub.getEsquerda());
		preOrdem(raizSub.getDireita());
	}
	
	public ArrayList<User> converterParaLista() {
		ArrayList<User> usuarios = new ArrayList<User>();
		
		return converterParaLista(raiz, usuarios);
	}
	
	private ArrayList<User> converterParaLista(ArvoreNo raizSub, ArrayList<User> usuarios) {
		if (raizSub == null) {
			return usuarios;
		}
		
		User usuario = raizSub.getUsuario();
		usuarios.add(usuario);
		
		converterParaLista(raizSub.getEsquerda(), usuarios);
		converterParaLista(raizSub.getDireita(), usuarios);
		
		return usuarios;
	}
}
