package mini.projeto2;

public interface THashMiniProjeto {

	/**
	 * calcula o hash da chave inteira id, utilizando o m�todo da divis�o
	 * @param id chave identificadora do objeto
	 * @return o �ndice mapeado
	 */
	public int hash(int id);
	
	/**
	 * m�todo para averiguar se h� espa�os vazios na tabela (a tabela pode conter um atributo para contar a quantidade de elementos)
	 * @return verdadeiro se n�o houver espa�os onde possam ser inseridos novos elementos
	 */
	public boolean isCheia();
	
	/**
	 * adiciona o usu�rio passado por par�metro da tabela hash
	 * @param u usu�rio que ser� salvo na tabela
	 * @throws Exception lan�a uma exce��o quando n�o houver espa�os dispon�veis
	 */
	public void adicionar(User u) throws Exception;

	/**
	 * o m�todo retorna o usu�rio com id igual ao recebido como par�metro de entrada
	 * @param id id do usu�rio que se deseja recuperar
	 * @return retorna o objeto usu�rio com o id igual ao recebido como par�metro
	 * @throws Exception lan�a uma exce��o caso o usu�rio n�o seja encontrada
	 */
	public User recuperar(int id) throws Exception;
	
	/**
	 * esse m�todo deve imprimir os �ndices da tabela hash
	 * ex. 
	 * [0] - vazio
	 * [1] - Jo�o (ID 1) (para tabelas com endere�amento aberto)
	 * [2] - INICIO -> Ana (ID 2) -> Maria (ID 4) (para tabelas com endere�amento fechado).
	 * [3] - RAIZ -> Jos� (ID 3), Jonathas (ID 6) (percurso pr�ordem para �rvores). 
	 */
	public void print();
	
	/**
	 * fun��o que dobra o tamanho da tabela hash e realoca todos os elementos existentes em seus novos �ndices
	 */
	public void crescer() throws Exception;
	
	/**
	 * @return retorna a quantidade de elementos guardada atualmente na tabela
	 */
	public int qtd();
	
}