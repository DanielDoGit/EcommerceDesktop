package ecommerce.modelo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import ecommerce.modelo.persistence.HibernateUtil;

@SuppressWarnings("unchecked")
public abstract class Dao<E> {
	
	private Class<E> clazz;
	
	protected Dao(Class<E> clazz) {
		this.clazz = clazz;
	}
	
	private void cadastrar(E object) {
		HibernateUtil.getSession().save(object);
	}
	
	private void editar(E object) {
		HibernateUtil.getSession().update(object);
	}
	
	private void excluir(Integer id) {
		E  objeto = buscarPorCodigo(id);
		HibernateUtil.getSession().delete(objeto);
	}
	
	private E buscarPorCodigo(Integer id) {
		return (E) HibernateUtil.getSession().get(clazz, id);
	}
	
	private List<E> buscarTodos() {
		return HibernateUtil.getSession().createCriteria(clazz).list();
	}
	
	private List<E> buscarPorSimilaridade(String args, String atributo){
		Criteria criteria = HibernateUtil.getSession().createCriteria(clazz);
		criteria.add(Restrictions.ilike(atributo, args, MatchMode.ANYWHERE));
		return criteria.list();
	}
	
}
