package com.spr.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.spr.dto.Product;

@Repository
public class ProductDaoImple implements ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void add(Product product) {
		hibernateTemplate.execute(new HibernateCallback<List<Product>>() {
			@Override
			public List<Product> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				session.save(product);
				t.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
	}

	@Override
	public void remove(int productId) {
		hibernateTemplate.execute(new HibernateCallback<List<Product>>() {
			@Override
			public List<Product> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				session.delete(new Product(productId));
				t.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
		
	}

	@Override
	public void edit(Product product) {
		hibernateTemplate.execute(new HibernateCallback<List<Product>>() {
			@Override
			public List<Product> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				session.update(product);
				t.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});

		
	}

	@Override
	public Product selectById(int productId) {
		Product p = hibernateTemplate.execute(new HibernateCallback<Product>() {
			@Override
			public Product doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Product product = (Product)session.get(Product.class, productId);
				t.commit();
				session.flush();
				session.close();
				return product;
			}
			
		});

		return p;
	}

	@Override
	public List<Product> selectAll() {
		List<Product> li = hibernateTemplate.execute(new HibernateCallback<List<Product>>() {
			@Override
			public List<Product> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from Product");
				List<Product> li = q.list();
				t.commit();
				session.flush();
				session.close();
				return li;
			}
			
		});

		return li;
	}

}
