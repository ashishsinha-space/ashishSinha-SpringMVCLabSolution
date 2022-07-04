package com.greatlearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.dao.StudentDao;
import com.greatlearning.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDaoImpl;

	@Override
	public List<Student> findAllStudent() {
		// TODO Auto-generated method stub
		return studentDaoImpl.findAllStudent();
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return studentDaoImpl.findById(id);
	}

	@Override
	public void save(Student student) {

		studentDaoImpl.save(student);

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

		studentDaoImpl.deleteById(id);

	}

}
