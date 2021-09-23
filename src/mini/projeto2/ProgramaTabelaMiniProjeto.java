package mini.projeto2;

import java.util.Scanner;


public class ProgramaTabelaMiniProjeto {

	public static void escolha(Scanner leitor, String opcao, THashMiniProjeto tabela) throws Exception{
		switch (opcao) {
			case "1":
				System.out.println("Nome");
				String nome = lerString(leitor);
				System.out.println("ID");
				int id = lerInteiro(leitor);
				User u = new User(id, nome);
				tabela.adicionar(u);
			break;
			case "2":
				System.out.println("ID");
				id = lerInteiro(leitor);
				u = tabela.recuperar(id);
				System.out.println(u.getNome());
			break;
			case "3":
				System.out.println(tabela.qtd());
			break;
			case "4":
				tabela.print();
			break;
			case "5":
				tabela.crescer();
			break;
			case "s":
				System.out.println("Adeus.");
			break;
		}
	}
	
	private static String[] opcoes = {"1 - adicionar usu�rio", 
			"2 - recuperar usu�rio", 
			"3 - consultar quantidade", 
			"4 - imprimir a tabela",
			"5 - aumentar a tabela",
			"s - sair"};	
	
	private static String menu(Scanner leitor) {
		for(String s : opcoes) {
			System.out.println(s);
		}
		System.out.print("op��o: ");
		return leitor.nextLine().toLowerCase();
	}
	
	public static String lerString(Scanner leitor) {
		System.out.print("entrada: ");
		return leitor.nextLine().toLowerCase();
	}

	public static int lerInteiro(Scanner leitor) {
		System.out.print("entrada: ");
		return Integer.parseInt(leitor.nextLine());
	}

	public static void main(String[] args) {
		THashMiniProjeto tabela = new TabelaHash();
		Scanner leitor = new Scanner(System.in);	
		
		String opcao = menu(leitor);
		
		while (opcao.equals("s") == false) {
		
			try {
				escolha(leitor, opcao, tabela);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			opcao = menu(leitor);		
			
		}
		
		System.out.println("Fim de Programa");
		tabela.print();
		leitor.close();
	}
	
}