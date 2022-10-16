package br.com.fiap.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/dados")
public class PessoaResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String[][] listar() {
	
		String[][] nomes = new String[5][3]; //Matriz de 5 linhas e 3 colunas
		
		//Primeira coluna = nome | Segunda coluna = CPF | Terceira coluna = email
		nomes[0][0] = "Alê";
		nomes[0][1] = "123.132.123-69";
		nomes[0][2] = "email@email.com";
		
		nomes[1][0] = "Avalmir";
		nomes[1][1] = "123.132.123-69";
		nomes[1][2] = "email@email.com";
		
		nomes[2][0] = "marcelo";
		nomes[2][1] = "123.132.123-69";
		nomes[2][2] = "email@email.com";
		
		nomes[3][0] = "cauan";
		nomes[3][1] = "123.132.123-69";
		nomes[3][2] = "email@email.com";
		
		nomes[4][0] = "will";
		nomes[4][1] = "123.132.123-69";
		nomes[4][2] = "email@email.com";
		
		return nomes;
		
	}
}
