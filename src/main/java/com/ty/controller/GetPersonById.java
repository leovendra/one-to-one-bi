package com.ty.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Person;

public class GetPersonById {

	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner(System.in);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();

		System.out.println("Enter Person Id : ");
		int id = sc.nextInt();

		Person p = manager.find(Person.class, id);

		if (p != null) {
			System.out.println(p.getName());
			
			System.out.println("----------------");
			Thread.sleep(2000);
			
			System.out.println(p.getPan().getPanNumber());
		} else {
			System.out.println("Person Not Found !!!");
		}
	}

}
