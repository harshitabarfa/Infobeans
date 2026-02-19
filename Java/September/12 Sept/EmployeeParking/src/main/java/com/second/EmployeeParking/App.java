package com.second.EmployeeParking;

import java.util.*;
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
			System.out.println("\n--- EMPLOYEE & PARKING SPOT MANAGEMENT SYSTEM ---");
			System.out.println("1. Add New Employee with Parking Spot");
			System.out.println("2. List All Employees with Parking Spots");
			System.out.println("3. Update Employee and Parking Spot");
			System.out.println("4. Delete Employee");
			System.out.println("5. Exit");

			System.out.println("\nEnter choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				insertEmployee(sc);
				break;

			case 2:
				listAllEmployee(sc);
				break;

			case 3:
				updateEmployee(sc);
				break;

			case 4:
				deleteEmployee(sc);
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

	private static void insertEmployee(Scanner sc) {
		try (Session session = sf.openSession()) {
			Transaction tx = session.beginTransaction();

			System.out.print("Enter Employee Name: ");
			String name = sc.nextLine();

			System.out.print("Enter Department: ");
			String dept = sc.nextLine();

			System.out.print("Enter Parking Spot Number: ");
			String spotNumber = sc.nextLine();

			System.out.print("Enter Parking Location: ");
			String location = sc.nextLine();

			Parking p = new Parking(spotNumber, location);
			Employee e = new Employee(name, dept, p);

			session.persist(e);
			tx.commit();

			System.out.println("Employee and Parking spot added successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void listAllEmployee(Scanner sc) {
		try (Session session = sf.openSession()) {
			List<Employee> list = session.createQuery("from Employee", Employee.class).getResultList();
			for (Employee e : list) {
				System.out.println(e);
				System.out.println("Parking spot: " + e.getPs());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void updateEmployee(Scanner sc) {
		try (Session session = sf.openSession()) {
			Transaction tx = session.beginTransaction();

			System.out.print("Enter Employee ID to update: ");
			int id = sc.nextInt();
			sc.nextLine();

			Employee e = session.get(Employee.class, id);

			if (e != null) {
				System.out.print("Enter new Employee Name: ");
				e.setName(sc.nextLine());

				System.out.print("Enter new Department: ");
				e.setDept(sc.nextLine());

				System.out.print("Enter new Parking Spot Number: ");
				e.getPs().setSpotNumber(sc.nextLine());

				System.out.print("Enter new Parking Location: ");
				e.getPs().setLocation(sc.nextLine());

				session.update(e);
				tx.commit();

				System.out.println("Employee and Parking spot updated successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void deleteEmployee(Scanner sc) {
		try (Session session = sf.openSession()) {
			Transaction tx = session.beginTransaction();

			System.out.print("Enter Employee ID to delete: ");
			int id = sc.nextInt();
			sc.nextLine();

			Employee e = session.get(Employee.class, id);

			if (e != null) {
				session.remove(e);
				tx.commit();
				System.out.println("Employee and Parking spot deleted successfully");
			} else {
				System.out.println("Employee not found!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
