package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.ProdutoDAO;
import br.com.fiap.to.ProdutoTO;

public class ProdutoBO {
	
	// Aqui fica as regras de negócios, por exemplo se produto possui desconto
	
	
	private ProdutoDAO pd;
	//Metodo que retorna uma lista
	public List<ProdutoTO> listar(){
		pd = new ProdutoDAO(); //Toda vez que dar new(instanciar) o ProdutoDAO, o construtor da classe dele será chamado
		return pd.select(); //Após o construtor de DAO criar os itens, aqui retornará a lista pelo metodo select() criado na classe
	}
	
	
	//Metodo retorna apenas 1 item e não uma lista
	public ProdutoTO listar(int id) {
		pd = new ProdutoDAO();
		return pd.select(id);
	}
	
	
	//cadastrar produto
	public boolean cadastrar(ProdutoTO pto) {
		pd = new ProdutoDAO();
		//REGRAS DE NEGOCIOS
		return pd.insert(pto);
	}
	


}
