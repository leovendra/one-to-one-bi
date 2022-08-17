package com.ty.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Company;
import com.ty.dto.Gst;

public class TestSaveCompanyGst {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Company com = new Company();
		com.setName("Infosys");
		com.setAddress("Mysore");

		Company com2 = new Company();
		com.setName("Globasoft");
		com.setAddress("Pune");

		Gst gst = new Gst();
		gst.setGstNo("GSTIN98765678");
		gst.setIssuedDate(LocalDate.of(2019, 8, 11));

		Gst gst1 = new Gst();
		gst1.setGstNo("GSTIN12345431");
		gst1.setIssuedDate(LocalDate.of(2018, 12, 9));

		com.setGst(gst);
		com2.setGst(gst1);

		transaction.begin();

		manager.persist(gst1);
		manager.persist(gst);
		manager.persist(com);
		manager.persist(com2);
		transaction.commit();
		System.out.println("Complete !!!");

	}

}
