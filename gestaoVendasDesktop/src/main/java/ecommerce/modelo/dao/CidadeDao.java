package ecommerce.modelo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import ecommerce.modelo.beans.Cidade;
import ecommerce.modelo.persistence.HibernateUtil;

@SuppressWarnings("unchecked")
public class CidadeDao extends Dao<Cidade>{
	
	public CidadeDao() {
		super(Cidade.class);
	}

	public List<Cidade> recuperarCidadeUf(String args) {
		Criteria criteria = HibernateUtil.getSession().createCriteria(Cidade.class);
		criteria.add(Restrictions.ilike("uf", args,MatchMode.ANYWHERE));
		return criteria.list();
	}

}
