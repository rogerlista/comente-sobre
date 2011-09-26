package br.com.bluesoft.comentesobre.controller;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.com.bluesoft.comentesobre.controle.TopicoController;
import br.com.bluesoft.comentesobre.modelo.Topico;
import br.com.bluesoft.comentesobre.repositorio.TopicoRepositorio;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;

public class TopicoControllerTest {

	private static final Long ID_VALIDO = 10L;
	
	private TopicoController controle;
	
	@Spy private Result result = new MockResult();
	@Spy private Validator validador = new MockValidator();
	
	@Mock private TopicoRepositorio repositorio;

	@Before
	public void inicializacao() {
		MockitoAnnotations.initMocks(this);
		controle = new TopicoController(result, repositorio, validador);
	}
	
	@Test
	public void deveriaCriarUmNovoTopico() throws Exception {
		// Dado
		Topico topico = new Topico(ID_VALIDO, "Metodologias");
		
		// Quando
		controle.salva(topico);
		
		// Então
		topico = verify(repositorio).salva(topico);
		verify(result).include("topicoAtual", topico);
	}
	
	@Test
	public void deveriaExibirAListagemDeTopicos() {
		// Dado
		
		// Quando
		controle.listagem();
		
		// Então
		verify(repositorio).buscaTodos();
		verify(result).include("topicoList", new ArrayList<Topico>());
	}
	
	@Test
	public void deveriaAdicionarNovoComentarioAUmTopicoExistente() {
		// Dado
		Topico topico = new Topico(ID_VALIDO, "Metodologia");
		
		// Quando
		controle.novoComentario(topico.getId());
		
		// Então
		Topico retornado = verify(repositorio).buscaPorId(topico.getId());
		verify(result).include("topicoAtual", retornado);
	}
	
}
