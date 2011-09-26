package br.com.bluesoft.comentesobre.dominio;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.Collections;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.bluesoft.comentesobre.modelo.Topico;

public class TopicoDominioTest {
	
	private static final long ID_VALIDO = 10L;

	private Topico topico;
	private TopicoDominio dominio;
	
	@Mock private EntityManager manager;
	@Mock private Query query;

	@Before
	public void inicializacao() {
		MockitoAnnotations.initMocks(this);
		dominio = new TopicoDominio(manager);
	}
	
	@Test
	public void deveriaBuscarTodos() {
		
		dadoQueTenhoUmTopico("Metodologias");
		
		// Quando
		manager.merge(topico);
		
		// Então
		when(manager.createQuery("from " + Topico.class.getName())).thenReturn(query);
		when(query.getResultList()).thenReturn(Collections.singletonList(topico));
	}
	
	@Test
	public void deveriaBuscarPorId() {
		
		dadoQueTenhoUmTopico("Metodologias");
		
		// Quando
		dominio.buscaPorId(topico.getId());
		when(manager.find(Topico.class, topico.getId())).thenReturn(topico);
		
		// Então
		verify(manager).find(Topico.class, topico.getId());
	}
	
	@Test
	public void deveriaRemover() {
		
		dadoQueTenhoUmTopico("Metodologias");
		
		// Quando
		dominio.remove(topico);
		
		// Então
		topico = verify(manager).getReference(Topico.class, topico.getId());
		verify(manager).remove(topico);
	}
	
	@Test
	public void deveriaSalvar() {
		
		dadoQueTenhoUmTopico("Metodologias");
		
		// Quando
		dominio.salva(topico);
		when(dominio.salva(topico)).thenReturn(topico);
		
		// Então
		topico = verify(manager).merge(topico);
	}

	private void dadoQueTenhoUmTopico(String assunto) {
		topico = new Topico(ID_VALIDO, assunto);
	}
	
}
