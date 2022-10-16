package br.com.fiap.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/saldo")
public class ServicoResource {
	
	double saldo = 100.00;
	
	@GET //metodo get
	@Produces(MediaType.TEXT_PLAIN) //texto simples retornado
	public String getSaldo() {
		return "Seu saldo atual é: " + saldo;
	}
}
