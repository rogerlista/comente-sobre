package br.com.bluesoft.comentesobre.modelo.comun;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntidade implements Serializable {

	private static final long serialVersionUID = -1425203242888488156L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
