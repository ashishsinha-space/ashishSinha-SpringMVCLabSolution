package com.greatlearning.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.greatlearning.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	private SessionFactory sessionFactory;

	private Session session;

	public StudentDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

		try {

			session = sessionFactory.getCurrentSession();

		} catch (HibernateException e) {

			session = sessionFactory.openSession();

		}

	}

	@Override
	public List<Student> findAllStudent() {

		Transaction transaction = session.beginTransaction();

		List<Student> students = session.createQuery("from Student").list();

		transaction.commit();

		return students;

	}

	@Override
	public Student findById(int id) {

		Transaction transaction = session.beginTransaction();

		Student student = session.get(Student.class, id);

		transaction.commit();

		return student;

	}

	@Override
	public void save(Student student) {

		Transaction transaction = session.beginTransaction();

		session.save(student);

		transaction.commit();

	}

	@Override
	public void deleteById(int id) {

		Transaction transaction = session.beginTransaction();

		Student student = session.get(Student.class, id);

		session.delete(student);

		transaction.commit();

	}

}
