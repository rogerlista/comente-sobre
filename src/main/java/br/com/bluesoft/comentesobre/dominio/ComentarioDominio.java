package br.com.bluesoft.comentesobre.dominio;

import javax.persistence.EntityManager;

import br.com.bluesoft.comentesobre.dominio.comun.GenericDominio;
import br.com.bluesoft.comentesobre.modelo.Comentario;
import br.com.bluesoft.comentesobre.repositorio.ComentarioRepositorio;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class ComentarioDominio  extends GenericDominio<Comentario> implements ComentarioRepositorio {

	public ComentarioDominio(EntityManager manager) {
		super(manager);
	}
	 
}
