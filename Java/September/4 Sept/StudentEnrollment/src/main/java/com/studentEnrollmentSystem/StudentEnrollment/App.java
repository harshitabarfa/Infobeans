package com.studentEnrollmentSystem.StudentEnrollment;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {
	private static SessionFactory sf;

	public static void main(String[] args) {

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n--- Student Enrollment System ---");
			System.out.println("1. Insert a new student");
			System.out.println("2. Fetch student by roll number");
			System.out.println("3. Update student’s year of study");
			System.out.println("4. Delete student by roll number");
			System.out.println("5. Exit");

			System.out.print("\nEnter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				insertStudent(sc);
				break;
			case 2:
				fetchStudent(sc);
				break;
			case 3:
				updateStudentYear(sc);
				break;
			case 4:
				deleteStudent(sc);
				break;
			case 5:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice!");
			}
		} while (choice != 5);

		sf.close();
		sc.close();
	}

	private static void insertStudent(Scanner sc) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Roll Number: ");
		String roll = sc.nextLine();

		System.out.print("Enter Name: ");
		String name = sc.nextLine();

		System.out.print("Enter Course: ");
		String course = sc.nextLine();

		System.out.print("Enter Email: ");
		String email = sc.nextLine();

		System.out.print("Enter Year of Study: ");
		int year = sc.nextInt();
		sc.nextLine();

		StudentEnrollment s = new StudentEnrollment(roll, name, course, email, year);
		session.persist(s);

		tx.commit();
		session.close();

		System.out.println("Student inserted successfully!");
	}

	private static void fetchStudent(Scanner sc) {
		Session session = sf.openSession();

		System.out.print("Enter Roll Number: ");
		String roll = sc.nextLine();

		StudentEnrollment s = session
				.createQuery("FROM StudentEnrollment WHERE rollNumber = :roll", StudentEnrollment.class)
				.setParameter("roll", roll).uniqueResult();

		if (s != null) {
			System.out.println("Student found: " + s);
		} else {
			System.out.println("Student not found!");
		}

		session.close();
	}

	private static void updateStudentYear(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Roll Number: ");
		String roll = sc.nextLine();

		System.out.print("Enter New Year of Study: ");
		int year = sc.nextInt();
		sc.nextLine();

		StudentEnrollment s = session
				.createQuery("FROM StudentEnrollment WHERE rollNumber = :roll", StudentEnrollment.class)
				.setParameter("roll", roll).uniqueResult();

		if (s != null) {
			s.setYearOfStudy(year);
			session.merge(s);
			System.out.println("Student of year updated successfully!");
		} else {
			System.out.println("Student not found!");
		}

		tx.commit();
		session.clear();
	}

	private static void deleteStudent(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Roll Number: ");
		String roll = sc.nextLine();

		StudentEnrollment s = session
				.createQuery("FROM StudentEnrollment WHERE rollNumber = :roll", StudentEnrollment.class)
				.setParameter("roll", roll).uniqueResult();

		if (s != null) {
			session.remove(s);
			tx.commit();

			System.out.println("Student delete successfully");
		} else {
			System.out.println("Student not found!");
		}
		session.close();
	}
}
