package com.info.EmployeeAddress;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class App {
	private static SessionFactory sf;

	public static void main(String[] args) {
		System.out.println("Hello World!");

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n---Employee Management---");
			System.out.println("1. Add Employee with Address");
			System.out.println("2. View All Employees");
			System.out.println("3. Update Employee Department");
			System.out.println("4. Delete Employee");
			System.out.println("5. Find Employee by City (HQL)");
			System.out.println("6. Find Address by Employee Name (HQL)");
			System.out.println("0. Exit");

			System.out.print("\nEnter choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				addEmployee(sc);
				break;

			case 2:
				viewAllEmployee(sc);
				break;

			case 3:
				updateEmployee(sc);
				break;

			case 4:
				deleteEmployee(sc);
				break;

			case 5:
				findEmployeeByCity(sc);
				break;

			case 6:
				findAdrressByEmployee(sc);
				break;

			case 0:
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid choice!");
			}
		} while (choice != 0);

		sf.close();
	}

	private static void addEmployee(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Address add = new Address();
		Employee emp = new Employee();

		System.out.print("Enter name: ");
		String name = sc.nextLine();

		System.out.print("Enter department: ");
		String dept = sc.nextLine();

		System.out.print("Enter city: ");
		String city = sc.nextLine();

		System.out.print("Enter state: ");
		String state = sc.nextLine();

		emp.setName(name);
		emp.setDept(dept);
		emp.setAdd(add);
		add.setCity(city);
		add.setState(state);
		add.setEmp(emp);
		session.persist(emp);

		System.out.println("Employee added successfully!");

		tx.commit();
		session.close();
	}

	private static void viewAllEmployee(Scanner sc) {
		Session session = sf.openSession();

		List<Employee> l = session.createQuery("from Employee", Employee.class).getResultList();
		for (Employee e : l) {
			System.out.println(e);
		}

		session.close();
	}

	private static void updateEmployee(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter id: ");
		int id = sc.nextInt();
		sc.nextLine();

		Employee e = session.get(Employee.class, id);

		if (e != null) {
			System.out.println("Enter new department: ");
			String ndept = sc.nextLine();
			e.setDept(ndept);
			session.merge(e);

			System.out.println("Employee updated successfully");
		} else {
			System.out.println("Employee not found!");
		}

		tx.commit();
		session.close();
	}

	private static void deleteEmployee(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter id: ");
		int id = sc.nextInt();
		sc.nextLine();

		Employee e = session.get(Employee.class, id);

		if (e != null) {
			session.remove(e);
			tx.commit();
			System.out.println("Employee deleted successfully");
		} else {
			System.out.println("Employee not found!");
		}
		session.close();
	}

	private static void findEmployeeByCity(Scanner sc) {
		Session session = sf.openSession();

		System.out.println("Enter city to find employee: ");
		String city = sc.nextLine();

		String q = "from Address where city = :city";
		Query qu = session.createQuery(q, Address.class);
		qu.setParameter("city", city);
		List<Address> l = qu.getResultList();
		for (Address e : l) {
			System.out.println(e);
		}
		session.close();
	}

	private static void findAdrressByEmployee(Scanner sc) {
		Session session = sf.openSession();

		System.out.println("Enter employee name to find address: ");
		String name = sc.nextLine();

		String q = "select a from Address a join a.emp e where e.name = :name";
		Query qu = session.createQuery(q, Address.class);
		qu.setParameter("name", name);
		List<Address> l = qu.getResultList();
		for (Address e : l) {
			System.out.println("Address: " + e.getCity() + ", " + e.getState());
		}
		session.close();
	}
}
