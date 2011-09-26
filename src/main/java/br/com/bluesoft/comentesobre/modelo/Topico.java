package br.com.bluesoft.comentesobre.modelo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

import br.com.bluesoft.comentesobre.modelo.comun.AbstractEntidade;

@Entity
public class Topico extends AbstractEntidade {

	private static final long serialVersionUID = 3436080153759731609L;

	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String assunto;
	
	@OneToMany(mappedBy = "topico", fetch = FetchType.EAGER)
	private Collection<Comentario> comentarios = new ArrayList<Comentario>();
	
	public Topico() {
		
	}
	
	public Topico(String assunto) {
		
		if (assunto == null || assunto.trim() == "") {
			throw new IllegalArgumentException("Informe um assunto válido para o tópico.");
		}
		
		this.assunto = assunto;
	}
	
	public Topico(long id, String assunto) {
		this(assunto);
		setId(id);
	}
		
	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public Collection<Comentario> getComentarios() {
		
		if (comentarios == null) {
			this.comentarios = new ArrayList<Comentario>();
		}
		
		return comentarios;
	}

	public void setComentarios(Collection<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public void adiciona(Comentario comentario) {
		this.comentarios.add(comentario);
	}
	
	public int getTotalDeComentarios() {
		return comentarios.size();
	}

	@Override
	public String toString() {
		return "Tópico [assunto=" + assunto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assunto == null) ? 0 : assunto.hashCode());
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
		Topico other = (Topico) obj;
		if (assunto == null) {
			if (other.assunto != null)
				return false;
		} else if (!assunto.equals(other.assunto))
			return false;
		return true;
	}

}
