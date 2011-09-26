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

import br.com.bluesoft.comentesobre.modelo.Comentario;
import br.com.bluesoft.comentesobre.modelo.Topico;

public class ComentarioDominioTest {

	private static final long ID_VALIDO = 10L;
	
	private Comentario comentario;
	private ComentarioDominio dominio;

	@Mock private EntityManager manager;
	@Mock private Query query;
	
	@Before
	public void inicializacao() {
		MockitoAnnotations.initMocks(this);
		dominio = new ComentarioDominio(manager);
	}
	
	@Test
	public void deveriaBuscarTodos() {
		
		dadoQueTenhoUmComentarioParaUmTopico();
		
		// Quando
		manager.merge(comentario);
		
		// Então
		when(manager.createQuery("form " + Comentario.class.getName())).thenReturn(query);
		when(query.getResultList()).thenReturn(Collections.singletonList(comentario));
	}
	
	@Test
	public void deveriaBuscarPorId() {
		
		dadoQueTenhoUmComentarioParaUmTopico();
		
		// Quando
		dominio.buscaPorId(comentario.getId());
		when(manager.find(Comentario.class, comentario.getId())).thenReturn(comentario);
		
		// Então
		verify(manager).find(Comentario.class, comentario.getId());
	}
	
	@Test
	public void deveriaRemover() {
		
		dadoQueTenhoUmComentarioParaUmTopico();
		
		// Quando
		dominio.remove(comentario);
		
		// Então
		comentario = verify(manager).getReference(Comentario.class, comentario.getId());
		verify(manager).remove(comentario);
	}
	
	@Test
	public void deveriaSalvar() {
		
		dadoQueTenhoUmComentarioParaUmTopico();
		
		// Quando
		dominio.salva(comentario);
		when(dominio.salva(comentario)).thenReturn(comentario);
		
		// Então
		comentario = verify(manager).merge(comentario);
	}

	private void dadoQueTenhoUmComentarioParaUmTopico() {
		String email = "jucabala@jucabala.com.br";
		String texto = "Nada a comentar desse comentário.";
		
		Topico topico = new Topico(ID_VALIDO, "Metodologia");
		comentario = new Comentario(topico, email, texto);
	}
}
