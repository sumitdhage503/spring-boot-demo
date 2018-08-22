package com.example.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.User;
import com.example.dao.UserDAO;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public String getNameById(int id) {

		/*Session session = this.sessionFactory.getCurrentSession();
		User user = (User)session.get(User.class, id);
		return user.getName();
*/
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("id", id));
		User user = (User)criteria.uniqueResult();
		return user.getName();
		
/*		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from com.example.bean.User as u");
		List<User> user = query.list();
		return "tes";
*/
		/*
		 * Transaction tx = null; Configuration configuration = new
		 * Configuration(); SessionFactory factory =
		 * configuration.buildSessionFactory(); Session session =
		 * factory.openSession(); Criteria cr =
		 * session.createCriteria(User.class); cr.add(Restrictions.eq("id",
		 * id)); return (String) cr.uniqueResult();
		 */ }
}
