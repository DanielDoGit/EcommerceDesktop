package ecommerce.modelo.persistence;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ecommerce.common.SistemaUtil;
import ecommerce.uteis.ColetaPropriedades;


public abstract class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static void iniciarHibernate(ColetaPropriedades coleta) {
		try {
			Configuration conf = new Configuration();
			conf.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
			conf.setProperty("hibernate.connection.url", coleta.getUrl() + coleta.getNomeDoBanco());
			conf.setProperty("hibernate.connection.username", coleta.getUsuario());
			conf.setProperty("hibernate.connection.password", coleta.getSenha());
			conf.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
			conf.setProperty("hibernate.current_session_context_class", "thread");
			conf.setProperty("hibernate.show_sql", "true");
			conf.setProperty("hibernate.format_sql","true");
			sessionFactory = conf.buildSessionFactory();
		} catch (MappingException e) {
			JOptionPane.showMessageDialog(null, e);
			SistemaUtil.gravarLog(e);
		} catch (HibernateException e) {
			JOptionPane.showMessageDialog(null, e);
			SistemaUtil.gravarLog(e);
		}

	}
	
	public static Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public static void begin() {
		if (!getSession().getTransaction().isActive()) {
			getSession().beginTransaction();
		}
	}

	public static void commit() {
		if (getSession().getTransaction().isActive() && !getSession().getTransaction().wasCommitted()) {
			getSession().getTransaction().commit();
		}
	}

	public static void rollback() {
		if (getSession().getTransaction().isActive() && !getSession().getTransaction().wasRolledBack()) {
			getSession().getTransaction().rollback();
		}
	}


}
