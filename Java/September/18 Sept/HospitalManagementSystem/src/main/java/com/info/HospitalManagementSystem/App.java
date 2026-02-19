package com.info.HospitalManagementSystem;

import jakarta.persistence.*;
import java.util.*;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyUnit");
		EntityManager em = factory.createEntityManager();

		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n---Hospital Management System---");
			System.out.println("1. Add Patient");
			System.out.println("2. View Patient by ID");
			System.out.println("3. Update Patient");
			System.out.println("4. Delete Patient");
			System.out.println("0. Exit");

			System.out.print("\nEnter choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				addPatient(em, sc);
				break;
			case 2:
				viewPatient(em, sc);
				break;
			case 3:
				updatePatient(em, sc);
				break;
			case 4:
				deletePatient(em, sc);
				break;
			case 5:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Invalid choice!");
			}
		} while (choice != 0);
		em.close();
		factory.close();
		sc.close();
	}

	private static void addPatient(EntityManager em, Scanner sc) {
		System.out.print("Enter name: ");
		String name = sc.next();

		System.out.print("Enter age: ");
		int age = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter disease: ");
		String disease = sc.next();

		System.out.print("Enter admission date (yyyy-mm-dd): ");
		String d = sc.next();
		java.sql.Date date = java.sql.Date.valueOf(d);

		Patient p = new Patient();
		p.setName(name);
		p.setAge(age);
		p.setDisease(disease);
		p.setAdmissionDate(date);

		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		System.out.println("Patient added successfully!");
	}

	private static void viewPatient(EntityManager em, Scanner sc) {
		System.out.print("Enter patient ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		Patient p = em.find(Patient.class, id);
		if (p != null) {
			System.out.println(p);
		} else {
			System.out.println("Patient not found!");
		}
	}

	private static void updatePatient(EntityManager em, Scanner sc) {
		System.out.print("Enter patient ID to update: ");
		int id = sc.nextInt();
		sc.nextLine();

		Patient p = em.find(Patient.class, id);
		if (p != null) {
			System.out.print("Enter new name: ");
			String name = sc.next();

			System.out.print("Enter new age: ");
			int age = sc.nextInt();
			sc.nextLine();

			System.out.print("Enter new disease: ");
			String disease = sc.next();

			System.out.print("Enter new admission date (yyyy-mm-dd): ");
			String dateStr = sc.next();
			java.sql.Date date = java.sql.Date.valueOf(dateStr);

			p.setName(name);
			p.setAge(age);
			p.setDisease(disease);
			p.setAdmissionDate(date);

			em.getTransaction().begin();
			em.merge(p);
			em.getTransaction().commit();
			System.out.println("Patient updated successfully!");
		} else {
			System.out.println("Patient not found!");
		}
	}

	private static void deletePatient(EntityManager em, Scanner sc) {
		System.out.print("Enter patient ID to delete: ");
		int id = sc.nextInt();
		sc.nextLine();
		Patient p = em.find(Patient.class, id);
		if (p != null) {
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
			System.out.println("Patient deleted!");
		} else {
			System.out.println("Patient not found!");
		}
	}
}
