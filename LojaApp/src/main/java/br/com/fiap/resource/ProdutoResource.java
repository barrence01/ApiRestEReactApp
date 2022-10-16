package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.ProdutoBO;
import br.com.fiap.to.ProdutoTO;

// O path da p�gina ser� <endere�o>/rest/produto
// Devido ao web.xml j� colocar como padr�o "/rest" e pode ser mudado
@Path("/produto")
public class ProdutoResource {
	
	//instanciar uma vers�o do produtoBO
	ProdutoBO pb = new ProdutoBO();
	
	//get-all
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProdutoTO> listarProdutos() {
		return pb.listar();
	}
	
	//get-id
	@GET
	@Path("/{id}") //Ao colocar entre chaves, captura o valor na url /produto/{valor} e o utiliza como parametro para a fun��o abaixo
	@Produces(MediaType.APPLICATION_JSON)
	public ProdutoTO listarProdutos(@PathParam(value = "id") int id) { //captura o valor nas chaves e o atribui a vari�vel "int id"
		return pb.listar(id);
	}
	
	
	//CADASTRAR PRODUTO
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(ProdutoTO produto, @Context UriInfo uriInfo) {
		
		//GERANDO O C�DIGO DO PRODUTO
		pb.cadastrar(produto);
		
		//CONSTRUIR A URI DE RETORNO
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		
		//PARSEANDO E CONCATENANDO O C�DIGO DO PRODUTO COM A URL
		builder.path(Integer.toString(produto.getCodigo()));
		
		//RETORNANDO A URL E TESTANDO A SOLICITA��O E REALIZANDO O POST.
		return Response.created(builder.build()).build();
	}
	
//	@GET //metodo get
//	@Produces(MediaType.TEXT_PLAIN) //texto simples retornado
//	public String buscar() {
//		return "Ol� Mundo!";
//	}
}
