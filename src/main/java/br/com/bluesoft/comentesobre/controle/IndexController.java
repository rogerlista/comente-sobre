package br.com.bluesoft.comentesobre.controle;

import java.util.Collection;

import br.com.bluesoft.comentesobre.modelo.Topico;
import br.com.bluesoft.comentesobre.repositorio.TopicoRepositorio;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class IndexController {

	private final Result result;
	private final TopicoRepositorio repositorio;

	public IndexController(Result result, TopicoRepositorio repositorio) {
		this.result = result;
		this.repositorio = repositorio;
	}
	
	@Path("/")
	@Get
	public void index() {
		Collection<Topico> topicoList = repositorio.buscaTodos();
		result.include("topicoList", topicoList);
	}
	
	@Get("/404")
	public void erro404() {
		result.forwardTo("/404.jsp");
	}
	
	@Get("/500")
	public void error500() {
		result.forwardTo("/500.jsp");
	}

}
