package br.com.bluesoft.comentesobre.repositorio.comun;

import java.util.Collection;

import br.com.bluesoft.comentesobre.exception.CommonException;
import br.com.bluesoft.comentesobre.modelo.comun.AbstractEntidade;

public interface GenericRepositorio<T extends AbstractEntidade> {

	Collection<T> buscaTodos();
	
	T buscaPorId(Long id);
	
	void remove(T entity);
	
	T salva(T entity) throws CommonException;
}
