package br.com.bluesoft.comentesobre.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TopicoTest {

	private String assunto;
	private Topico topico;
	
	@Before
	public void inicializacao() {
		this.assunto = "Metodologias";
		this.topico = new Topico(this.assunto);
	}
	
	@Test
	public void deveriaExistirUmTopicoComUmDeterminadoAssuntoValido() {
		assertEquals("Deveria haver um tópico com assunto: ", this.assunto, this.topico.getAssunto());
	}
	
	@Test
	public void deveriaAdicionarUmComentarioValidoAUmTopicoExistente() {
		// Dado
		String email = "jucabala@jucabala.com.br";
		String texto = "Há vários tipos de metodologias.";
		
		// Quando
		this.topico.adiciona(new Comentario(this.topico, email, texto));

		// Então
		assertEquals("deve haver um tópico com comentário: ", 1, this.topico.getTotalDeComentarios());
	}
	
	@Test
	public void deveriaAdicionarTresComentariosValidosAUmTopicoExistente() {
		// Dado
		String email = "jucabala@jucabala.com.br";
		String texto = "Há vários tipos de metodologias.";
		
		Comentario comentario = new Comentario(this.topico, email, texto);
		
		// Quando
		this.topico.adiciona(comentario);
		this.topico.adiciona(comentario);
		this.topico.adiciona(comentario);
		
		// Então
		assertEquals("deve haver um tópico com comentários: ", 3, this.topico.getTotalDeComentarios());
	}

	@Test
	public void deveriaLancarUmaIllegalArgumentExceptionParaTopicoComAssuntoIgualANull() {
		
		try {
			new Topico(null);
			fail("Deveria ter lançado uma IllegalArgumentException para assunto null.");
		} catch (IllegalArgumentException falha) {
			assertEquals("Informe um assunto válido para o tópico.", falha.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarUmaIllegalArgumentExceptionParaTopicoComAssuntoEmBranco() {
		
		try {
			new Topico("");
			fail("Deveria ter lançado uma IllegalArgumentException para assunto em branco.");
		} catch (IllegalArgumentException falha) {
			assertEquals("Informe um assunto válido para o tópico.", falha.getMessage());
		}
	}
	
}
