package br.com.bluesoft.comentesobre.dominio;

import javax.persistence.EntityManager;

import br.com.bluesoft.comentesobre.dominio.comun.GenericDominio;
import br.com.bluesoft.comentesobre.modelo.Topico;
import br.com.bluesoft.comentesobre.repositorio.TopicoRepositorio;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class TopicoDominio extends GenericDominio<Topico> implements TopicoRepositorio {

	public TopicoDominio(EntityManager manager) {
		super(manager);
	}

}
