package com.ty.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Pan;
import com.ty.dto.Person;

public class TestSavePersonPan {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Person p1 = new Person();
		p1.setName("Ganesh");
		p1.setAge(25);

		Pan pan1 = new Pan();
		pan1.setFatherName("Rama");
		pan1.setPanNumber("DFAQW6749N");

		pan1.setPerson(p1);

		Person p2 = new Person();
		p2.setName("Kiran");
		p2.setAge(23);

		Pan pan2 = new Pan();
		pan2.setFatherName("Nagesh");
		pan2.setPanNumber("GUHWP3827N");
		pan2.setPerson(p2);

		transaction.begin();

		manager.persist(pan1);
		manager.persist(pan2);
		manager.persist(p1);
		manager.persist(p2);
		transaction.commit();

		System.out.println("Done !!!");
	}

}
