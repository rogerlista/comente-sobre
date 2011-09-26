package br.com.bluesoft.comentesobre.controle;

import java.util.Collection;

import br.com.bluesoft.comentesobre.exception.CommonException;
import br.com.bluesoft.comentesobre.modelo.Comentario;
import br.com.bluesoft.comentesobre.modelo.Topico;
import br.com.bluesoft.comentesobre.repositorio.ComentarioRepositorio;
import br.com.bluesoft.comentesobre.repositorio.TopicoRepositorio;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

@Resource
public class ComentarioController {

	private final Result result;
	private final Validator validador;
	private final TopicoRepositorio topicoRepositorio;
	private final ComentarioRepositorio comentarioRepositorio;
	
	public ComentarioController(Result result, TopicoRepositorio topicoRepositorio,
								ComentarioRepositorio comentarioRepositorio, Validator validador) {
		this.result = result;
		this.validador = validador;
		this.topicoRepositorio = topicoRepositorio;
		this.comentarioRepositorio = comentarioRepositorio;
	}
	
	@Get("/comentario")
	public void novo(Topico topico) {
		Collection<Comentario> comentarioList = topicoRepositorio.buscaPorId(topico.getId()).getComentarios();
		result.include("comentarioList", comentarioList);
	}
	
	@Post("/comentario")
	public void adiciona(Comentario comentario) {
		Topico topico = topicoRepositorio.buscaPorId(comentario.getTopico().getId());
		topico.adiciona(comentario);
		
		validador.validate(topico);
		validador.validate(comentario);
		validador.onErrorRedirectTo(IndexController.class).index();
		
		try {
			comentario = comentarioRepositorio.salva(comentario);
			result.include("topicoAtual", comentario.getTopico()).redirectTo(this).novo(topico);
		} catch (CommonException falha) {
			result.include("error", falha.getMessage()).redirectTo(this).novo(topico);
		}
	}
	
}
