package br.com.bluesoft.comentesobre.controller;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.com.bluesoft.comentesobre.controle.IndexController;
import br.com.bluesoft.comentesobre.modelo.Topico;
import br.com.bluesoft.comentesobre.repositorio.TopicoRepositorio;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;

public class IndexControllerTest {

	private IndexController controle;
	
	@Spy private Result result = new MockResult();
	
	@Mock private TopicoRepositorio repositorio;

	@Before
	public void inicializacao() {
		MockitoAnnotations.initMocks(this);
		controle = new IndexController(result, repositorio);
	}
	
	@Test
	public void deveriaExibirOsTopicosExistentes() {
		// Dado
		
		// Quando
		controle.index();
		
		// Então
		verify(repositorio).buscaTodos();
		verify(result).include("topicoList", new ArrayList<Topico>());
	}
	
}
