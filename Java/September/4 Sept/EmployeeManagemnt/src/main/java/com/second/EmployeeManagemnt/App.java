package com.second.EmployeeManagemnt;

import java.sql.Date;
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
		System.out.println("Hello World!");

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n--- Employee Payroll Management System ---");
			System.out.println("1. Insert a new employee");
			System.out.println("2. Fetch employee by id");
			System.out.println("3. Update employee salary by id");
			System.out.println("4. Deactivate employee by id");
			System.out.println("5. Delete employee by id");
			System.out.println("6. Exit");

			System.out.print("\nEnter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				insertEmployee(sc);
				break;
			case 2:
				fetchEmployee(sc);
				break;
			case 3:
				updateSalary(sc);
				break;
			case 4:
				deactivateEmployee(sc);
				break;
			case 5:
				deleteEmployee(sc);
				break;
			case 6:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice!");
			}
		} while (choice != 6);

		sf.close();
		sc.close();
	}

	private static void insertEmployee(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter employee code: ");
		String code = sc.nextLine();

		System.out.print("Enter name: ");
		String name = sc.nextLine();

		System.out.print("Enter department: ");
		String dept = sc.nextLine();

		System.out.print("Enter salary: ");
		double salary = sc.nextDouble();
		sc.nextLine();

		Date joiningDate = new Date(System.currentTimeMillis());

		System.out.print("Enter status (Press enter for default active): ");
		String status = sc.nextLine();
		if (status.isEmpty()) {
			status = "Active";
		}

		EmployeeManagemnet e = new EmployeeManagemnet(code, name, dept, salary, status, joiningDate);
		session.persist(e);

		tx.commit();
		session.close();

		System.out.println("Employee inserted successfully!");
	}

	private static void fetchEmployee(Scanner sc) {
		Session session = sf.openSession();

		System.out.print("Enter employee id: ");
		int id = sc.nextInt();
		sc.nextLine();

		EmployeeManagemnet e = session.get(EmployeeManagemnet.class, id);

		if (e != null) {
			System.out.println("Employee found: " + e);
		} else {
			System.out.println("Employee not found!");
		}
	}

	private static void updateSalary(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter employee id: ");
		int id = sc.nextInt();
		sc.nextLine();

		EmployeeManagemnet e = session.get(EmployeeManagemnet.class, id);

		if (e != null) {
			System.out.print("Enter new salary: ");
			double newSalary = sc.nextDouble();
			sc.nextLine();

			e.setSalary(newSalary);
			session.merge(e);
			tx.commit();

			System.out.println("Salary updated!");
		} else {
			System.out.println("Employee not found!");
		}
		session.close();
	}

	private static void deactivateEmployee(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter employee id: ");
		int id = sc.nextInt();
		sc.nextLine();

		EmployeeManagemnet e = session.get(EmployeeManagemnet.class, id);

		if (e != null) {
			e.setStatus("Inactive");

			session.merge(e);
			tx.commit();

			System.out.println("Employee deactivated!");
		} else {
			System.out.println("Employee not found!");
		}
		session.close();
	}

	private static void deleteEmployee(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter employee id: ");
		int id = sc.nextInt();
		sc.nextLine();

		EmployeeManagemnet e = session.get(EmployeeManagemnet.class, id);

		if (e != null) {
			session.remove(e);
			tx.commit();

			System.out.println("Employee deleted!");
		} else {
			System.out.println("Employee not found!");
		}
		session.close();
	}
}
