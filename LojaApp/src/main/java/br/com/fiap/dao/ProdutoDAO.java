package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.to.ProdutoTO;

public class ProdutoDAO {

	// objetivo do dado é estabelecer regras, funções e objetivos
	// Talvez acesso ao banco de dados?
	public static List<ProdutoTO> listaProduto;

	public ProdutoDAO() {
		if (listaProduto == null) {
			listaProduto = new ArrayList<ProdutoTO>();
			
			ProdutoTO pto = new ProdutoTO();
			pto.setCodigo(1);
			pto.setPreco(27.99);
			pto.setQuantidade(10);
			pto.setTitulo("Grampeador");
			listaProduto.add(pto);
			// mais 4 produtos
			
			pto = new ProdutoTO();
			pto.setCodigo(2);
			pto.setPreco(50.00);
			pto.setQuantidade(5);
			pto.setTitulo("Mochila");
			listaProduto.add(pto);
			
			pto = new ProdutoTO();
			pto.setCodigo(3);
			pto.setPreco(5.99);
			pto.setQuantidade(30);
			pto.setTitulo("Tesoura");
			listaProduto.add(pto);
			
			pto = new ProdutoTO();
			pto.setCodigo(4);
			pto.setPreco(10.99);
			pto.setQuantidade(100);
			pto.setTitulo("Caneta TOP");
			listaProduto.add(pto);
			
			pto = new ProdutoTO();
			pto.setCodigo(5);
			pto.setPreco(37.99);
			pto.setQuantidade(3);
			pto.setTitulo("Lapiseira Premium");
			listaProduto.add(pto);
		}
	}
	
	//get-all
	public List<ProdutoTO> select() {
		return listaProduto;
	}
	
	//get-id
	public ProdutoTO select(int id) {
		for (int i = 0; i < listaProduto.size(); i++) {
			if (listaProduto.get(i).getCodigo() == id) {
				return listaProduto.get(i);
			}
		}
		return null;
	}
	
	public boolean insert(ProdutoTO pto) {
		
		//GERANDO O CÓDIGO DO PRODUTO
		pto.setCodigo(listaProduto.size()+1);
		
		//INSERINDO O PRODUTO NA BASE E RECEBENDO
		//UM TRUE OU FALSE
		return listaProduto.add(pto);
	}
	
}

