package br.com.bluesoft.comentesobre.controle;

import java.util.Collection;

import br.com.bluesoft.comentesobre.exception.CommonException;
import br.com.bluesoft.comentesobre.modelo.Topico;
import br.com.bluesoft.comentesobre.repositorio.TopicoRepositorio;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

@Resource
public class TopicoController {

	private final Result result;
	private final Validator validador;
	private final TopicoRepositorio repositorio;

	public TopicoController(Result result, TopicoRepositorio repositorio, Validator validador) {
		this.result = result;
		this.repositorio = repositorio;
		this.validador = validador;
	}
	
	@Get("/topico")
	public void listagem() {
		Collection<Topico> topicoList = repositorio.buscaTodos();
		result.include("topicoList", topicoList);
	}
	
	@Post("/topico")
	public void salva(Topico topico) {
		validador.validate(topico);
		validador.onErrorRedirectTo(IndexController.class).index();
		
		try {
			topico = repositorio.salva(topico);
			result.include("topicoAtual", topico).redirectTo(ComentarioController.class).novo(topico);
		} catch (CommonException falha) {
			result.include("error", falha.getMessage()).redirectTo(IndexController.class).index();
		}
	}
	
	@Get("/topico/{id}")
	public void novoComentario(Long id) {
		Topico topico = repositorio.buscaPorId(id);
		result.include("topicoAtual", topico).redirectTo(ComentarioController.class).novo(topico);
	}
	
}
