package br.com.bluesoft.comentesobre.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class ComentarioTest {

	private Topico topico;
	private String email;
	private String texto;
	
	@Before
	public void inicializacao() {
		this.topico = new Topico("Metodologias");
		this.email = "jucabala@jucabala.com.br";
		this.texto = "Meu comentário se resume a um comentário.";
	}
	
	@Test
	public void deveriaExistirUmComentarioValidoParaUmTopicoExistente() {
		// Dado
		
		// Quando
		Comentario comentario = new Comentario(this.topico, this.email, this.texto);
		
		// Então
		assertEquals("deve haver um tópico: ", this.topico.getAssunto(), comentario.getTopico().getAssunto());
		assertEquals("deve haver um e-mail: ", this.email, comentario.getEmail());
		assertEquals("deve haver um comentário: ", this.texto, comentario.getTexto());
	}
	
	@Test
	public void deveriaLancarUmaIllegalArgumentExceptionParaTopicoIgualANull() {
		
		try {
			new Comentario(null, this.email, this.texto);
			fail("Deveria ter lançado uma IllegalArgumentException para tópico null.");
		} catch (IllegalArgumentException falha) {
			assertEquals("Informe um tópico válido para o comentário.", falha.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarUmaIllegalArgumenteExceptionParaEMailIgualANull() {
		
		try {
			new Comentario(this.topico, null, "Este comentário não é válido.");
			fail("Deveria ter lançado uma IllegalArgumentException para e-mail null.");
		} catch (IllegalArgumentException falha) {
			assertEquals("Informe um e-mail válido para o comentário.", falha.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarUmaIllegalArgumentExceptionParaEMailEmBranco() {
		
		try {
			new Comentario(this.topico, "", "Não quero fazer nenhum comentário.");
			fail("Deveria ter lançado uma IllegalArgumentException para e-mail em branco.");
		} catch (IllegalArgumentException falha) {
			assertEquals("Informe um e-mail válido para o comentário.", falha.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarUmaIllegalArgumentExceptionParaTextoIgualANull() {
		
		try {
			new Comentario(this.topico, "juca@bala.com.br", null);
			fail("Deveria ter lançado uma IllegalArgumentException para texto null.");
		} catch (IllegalArgumentException falha) {
			assertEquals("Informe um comentário válido.", falha.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarUmaIllegalArgumentExceptionParaTextoEmBranco() {
		
		try {
			new Comentario(this.topico, "juca@bala.com.br", "");
			fail("Deveria ter lançado uma IllegalArgumenteException para texto em branco.");
		} catch (IllegalArgumentException falha) {
			assertEquals("Informe um comentário válido.", falha.getMessage());
		}
	}
}
