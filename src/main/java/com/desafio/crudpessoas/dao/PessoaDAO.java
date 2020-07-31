package com.desafio.crudpessoas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.desafio.crudpessoas.domain.Pessoa;
import com.desafio.crudpessoas.util.HibernateUtil;

public class PessoaDAO {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session;
	private List<Pessoa> listPessoas;

	public List<Pessoa> getPessoas() {
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			listPessoas = (List<Pessoa>) session.createCriteria(Pessoa.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.close();
		return listPessoas;
	}

	public Pessoa addPessoa(Pessoa pessoa) {

		session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.save(pessoa);
			session.flush();
			System.out.println("Pessoa Criada com id: " + pessoa.getId());
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.close();
		return pessoa;
	}

	public void deletePessoa(Pessoa pessoa) {

		session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.delete(pessoa);
			session.flush();
			System.out.println("Pessoa Criada com id: " + pessoa.getId());
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.close();

	}

	public Pessoa updatePessoa(Pessoa pessoa) {

		session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.save(pessoa);
			session.flush();
			System.out.println("Pessoa Criada com id: " + pessoa.getId());
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return pessoa;
	}

}
