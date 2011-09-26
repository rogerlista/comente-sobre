package br.com.bluesoft.comentesobre.modelo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.validator.Email;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

import br.com.bluesoft.comentesobre.modelo.comun.AbstractEntidade;

@Entity
public class Comentario extends AbstractEntidade {

	private static final long serialVersionUID = -3191943032179948076L;
	
	@Email
	@NotNull
	@NotEmpty
	private String email;
	
	@NotNull
	@NotEmpty
	private String texto;

	@ManyToOne
	private Topico topico;
	
	public Comentario() {
		
	}
	
	public Comentario(Topico topico, String email, String texto) {
		
		if (topico == null) {
			throw new IllegalArgumentException("Informe um tópico válido para o comentário.");
		}
		
		if (email == null || email.trim() == "") {
			throw new IllegalArgumentException("Informe um e-mail válido para o comentário.");
		}
		
		if (texto == null || texto.trim() == "") {
			throw new IllegalArgumentException("Informe um comentário válido.");
		}
		
		this.topico = topico;
		this.email = email;
		this.texto = texto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Topico getTopico() {
		return topico;
	}
	
	public void setTopico(Topico topico) {
		this.topico = topico;
	}

	@Override
	public String toString() {
		return "Comentario [topico=" + topico + ", email=" + email + ", texto="	+ texto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		result = prime * result + ((topico == null) ? 0 : topico.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		if (topico == null) {
			if (other.topico != null)
				return false;
		} else if (!topico.equals(other.topico))
			return false;
		return true;
	}

}
