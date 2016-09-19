package br.com.youbeer.webserverapp.service;

import java.util.List;

import br.com.youbeer.webserverapp.modelo.Admin;
import br.com.youbeer.webserverapp.modelo.Cerveja;
import br.com.youbeer.webserverapp.modelo.Estabelecimento;

/**
 * Interface para os servi�os de manipula��o ao banco.
 * 
 * @since 29/08/2016
 * @version 1.0
 */
public interface IYoubeerService {
	
	/**
	 * Verifica a exist�ncia do admin pelo username
	 * @param admin Objeto <tt>Admin</tt>.
	 * @return boolean true ou false
	 */
	public boolean isExisteAdmin(Admin admin);
	
	/**
	 * Obtem os dados de acesso do admin
	 * @param admin Objeto da classe Admin
	 * @return saida Objeto da classe Admin
	 */
	public Admin obterDadosAdmin(Admin admin);
	
	/**
	 * Obtem a lista de cervejas do banco
	 * @return saida Lista de Objetos da classe Cerveja
	 */
	public List<Cerveja> listarCervejas();
	
	/**
	 * Insere uma cerveja em um estabelecimento do banco
	 * @param cerveja Objeto <tt>Cerveja</tt>.
	 * @param estabelecimento Objeto <tt>Estabelecimento</tt>.
	 */
	public void inserirCervejaEstabelecimento(Estabelecimento estabelecimento, Cerveja cerveja);
	
	/**
	 * Remove uma cerveja em um estabelecimento do banco
	 * @param cerveja Objeto <tt>Cerveja</tt>.
	 * @param estabelecimento Objeto <tt>Estabelecimento</tt>.
	 */
	public void removerCervejaEstabelecimento(Estabelecimento estabelecimento, Cerveja cerveja);
	
	/**
	 * Altera os dados de uma cerveja em um estabelecimento do banco
	 * @param cerveja Objeto <tt>Cerveja</tt>.
	 * @param estabelecimento Objeto <tt>Estabelecimento</tt>.
	*/
	public void alterarCervejaEstabelecimento(Estabelecimento estabelecimento, Cerveja cerveja) ;
	
	/**
	 * Verifica a exist�ncia do estabelecimento
	 * @param admin Objeto <tt>Admin</tt>.
	 * @return boolean true ou false
	 */
	public boolean isExisteEstabelecimento(Admin admin);
	
	/**
	 * Insere o estabelecimento no banco
	 * @param estabelecimento Objeto <tt>Estabelecimento</tt> populado.
	 * @return c�digo do estabelecimento inserido <tt>int<int></tt> 
	 */
	public int inserirEstabelecimento(Estabelecimento estabelecimento);
	
	/**
	 * Remove estabelecimento do banco
	 * @param estabelecimento Objeto <tt>Estabelecimento</tt>.
	 */
	public void removerEstabelecimento(Estabelecimento estabelecimento);
	
	/**
	 * Altera os dados do estabelecimento no banco
	 * @param estabelecimento Objeto <tt>Estabelecimento</tt>.
	 */
	public void alterarInformacoesEstabelecimento(Estabelecimento estabelecimento);
	
	/**
	 * Retorna a lista de estabelecimento de acordo com o c�digo do admin
	 * @param session Objeto <tt>HttpSession</tt>.
	 * @return Lista de Objetos do tipo <tt> List<Estabelecimento></tt> 
	 */
	public List<Estabelecimento> listarEstabelecimentos(Admin admin);
	
	/**
	 * Retorna o estabelecimento de acordo com o c�digo de consulta
	 * @param codigoEstabelecimento <tt>int</tt>.
	 * @return estabelecimento de Objetos do tipo <tt> Estabelecimento<Estabelecimento></tt> 
	 */
	public Estabelecimento buscarPorCodigo(int codigoEstabelecimento);
	
	/**
	 * Grava o caminho da foto do estabelecimento inserido pelo usu�rio
	 * @param estabelecimento Objeto <tt>Estabelecimento</tt> populado.
	 * @param numeroFoto <tt>String</tt> do campo que ser� populado.
	 * @param caminhoFoto <tt>String</tt> com o caminho da imagem a ser salva.
	 */
	public void inserirFotosEstabelecimento(Estabelecimento estabelecimento, String campoNome, String caminhoFoto);
		
}
