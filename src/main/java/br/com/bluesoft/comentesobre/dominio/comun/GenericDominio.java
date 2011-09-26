package br.com.bluesoft.comentesobre.dominio.comun;

import java.util.Collection;
import java.lang.reflect.ParameterizedType;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import br.com.bluesoft.comentesobre.modelo.comun.AbstractEntidade;
import br.com.bluesoft.comentesobre.repositorio.comun.GenericRepositorio;

public abstract class GenericDominio<T extends AbstractEntidade> implements GenericRepositorio<T> {

	protected final EntityManager manager;
	protected final Class<T> clazz;
	
	protected GenericDominio(EntityManager manager) {
		this.manager = manager;
		
		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		
		this.clazz = clazz;
	}
	
	public T salva(T entidade) {
		return manager.merge(entidade);
	}
	
	public void remove(T entidade) {
		manager.remove(manager.getReference(clazz, entidade.getId()));
	}
	
	public T buscaPorId(Long id) {
		return manager.find(clazz, id);
	}
	
	public Collection<T> buscaTodos() {
		Query query = manager.createQuery("from " + clazz.getName());
		
		@SuppressWarnings("unchecked")
		Collection<T> resultList = query.getResultList();
		
		return resultList;
	}
}
