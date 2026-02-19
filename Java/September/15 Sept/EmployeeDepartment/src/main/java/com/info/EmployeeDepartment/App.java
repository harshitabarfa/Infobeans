package com.info.EmployeeDepartment;

import java.util.List;
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
			System.out.println("\n---Department Employee Management---");
			System.out.println("1. Add Department with Employees");
			System.out.println("2. Add Employee to Existing Department");
			System.out.println("3. View All Departments and Employees");
			System.out.println("4. Update Employee Salary By Employee ID");
			System.out.println("5. Update Department Name By Department ID");
			System.out.println("6. Delete Employee By ID");
			System.out.println("7. Delete Department By ID");
			System.out.println("8. Find Employees by Department Name (HQL)");
			System.out.println("9. Find Department by Employee Name (HQL)");
			System.out.println("10. List Employees with Salary > 50,000 (HQL)");
			System.out.println("11. List Departments with > 3 Employees (HQL)");
			System.out.println("0. Exit");

			System.out.print("\nEnter choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				addDepartmentWithEmployees(sc);
				break;
			case 2:
				addEmployeeToDepartment(sc);
				break;
			case 3:
				viewAllDepartmentsAndEmployees();
				break;
			case 4:
				updateEmployeeSalary(sc);
				break;
			case 5:
				updateDepartmentName(sc);
				break;
			case 6:
				deleteEmployee(sc);
				break;
			case 7:
				deleteDepartment(sc);
				break;
			case 8:
				findEmployeesByDepartmentName(sc);
				break;
			case 9:
				findDepartmentByEmployeeName(sc);
				break;
			case 10:
				listEmployeesWithSalaryGreaterThan(sc);
				break;
			case 11:
				listDepartmentsWithMoreThanNEmployees(sc);
				break;
			case 0:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice!");
			}
		} while (choice != 0);
	}

	private static void addDepartmentWithEmployees(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Department dept = new Department();
		System.out.print("Enter department name: ");
		dept.setName(sc.nextLine());

		System.out.print("Enter department location: ");
		dept.setLocation(sc.nextLine());

		System.out.print("How many employees to add? ");
		int count = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < count; i++) {
			Employee emp = new Employee();
			System.out.print("Enter employee name: ");
			emp.setName(sc.nextLine());

			System.out.print("Enter designation: ");
			emp.setDesignation(sc.nextLine());

			System.out.print("Enter salary: ");
			emp.setSalary(sc.nextDouble());
			sc.nextLine();

			emp.setDept(dept);
			dept.getEmployees().add(emp);
		}

		session.persist(dept);
		tx.commit();
		session.close();

		System.out.println("Department with employees added successfully.");
	}

	private static void addEmployeeToDepartment(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Department ID: ");
		int deptId = sc.nextInt();
		sc.nextLine();

		Department dept = session.get(Department.class, deptId);

		if (dept != null) {
			Employee emp = new Employee();
			System.out.print("Enter employee name: ");
			emp.setName(sc.nextLine());

			System.out.print("Enter designation: ");
			emp.setDesignation(sc.nextLine());

			System.out.print("Enter salary: ");
			emp.setSalary(sc.nextDouble());
			sc.nextLine();

			emp.setDept(dept);
			dept.getEmployees().add(emp);

			session.persist(emp);
			tx.commit();
			System.out.println("Employee added to department successfully.");
		} else {
			System.out.println("Department not found!");
		}
		session.close();
	}

	private static void viewAllDepartmentsAndEmployees() {
		Session session = sf.openSession();
		List<Department> l = session.createQuery("from Department", Department.class).getResultList();

		for (Department d : l) {
			System.out.println("\nDepartment: " + d.getName() + " | Location: " + d.getLocation());
			for (Employee e : d.getEmployees()) {
				System.out.println("Employee: " + e.getName() + " | Salary: " + e.getSalary());
			}
		}
		session.close();
	}

	private static void updateEmployeeSalary(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Employee ID: ");
		int empId = sc.nextInt();
		sc.nextLine();

		Employee emp = session.get(Employee.class, empId);

		if (emp != null) {
			System.out.print("Enter new salary: ");
			double newSalary = sc.nextDouble();
			sc.nextLine();

			emp.setSalary(newSalary);
			session.merge(emp);
			tx.commit();
			System.out.println("Employee salary updated.");
		} else {
			System.out.println("Employee not found.");
		}
		session.close();
	}

	private static void updateDepartmentName(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Department ID: ");
		int deptId = sc.nextInt();
		sc.nextLine();

		Department dept = session.get(Department.class, deptId);
		if (dept != null) {
			System.out.print("Enter new department name: ");
			String newName = sc.nextLine();

			dept.setName(newName);
			session.merge(dept);
			tx.commit();
			System.out.println("Department name updated.");
		} else {
			System.out.println("Department not found.");
		}
		session.close();
	}

	private static void deleteEmployee(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Employee ID to delete: ");
		int empId = sc.nextInt();
		sc.nextLine();

		Employee emp = session.get(Employee.class, empId);

		if (emp != null) {
			session.remove(emp);
			tx.commit();
			System.out.println("Employee deleted.");
		} else {
			System.out.println("Employee not found.");
		}
		session.close();
	}

	private static void deleteDepartment(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Department ID to delete: ");
		int deptId = sc.nextInt();
		sc.nextLine();

		Department dept = session.get(Department.class, deptId);
		if (dept != null) {
			session.remove(dept);
			tx.commit();
			System.out.println("Department and associated employees deleted.");
		} else {
			System.out.println("Department not found.");
		}
		session.close();
	}

	private static void findEmployeesByDepartmentName(Scanner sc) {
		Session session = sf.openSession();

		System.out.print("Enter department name: ");
		String deptName = sc.nextLine();

		List<Employee> emp = session.createQuery("select e from Employee e where e.dept.name = :name", Employee.class)
				.setParameter("name", deptName).getResultList();

		for (Employee e : emp) {
			System.out.println(e);
		}
		session.close();
	}

	private static void findDepartmentByEmployeeName(Scanner sc) {
		Session session = sf.openSession();

		System.out.print("Enter employee name: ");
		String empName = sc.nextLine();

		List<Department> depts = session
				.createQuery("select e.dept from Employee e where e.name = :name", Department.class)
				.setParameter("name", empName).getResultList();

		for (Department d : depts) {
			System.out.println(d);
		}
		session.close();
	}

	private static void listEmployeesWithSalaryGreaterThan(Scanner sc) {
		Session session = sf.openSession();

		List<Employee> employees = session.createQuery("from Employee where salary > :amount", Employee.class)
				.setParameter("amount", 50000).getResultList();

		for (Employee e : employees) {
			System.out.println(e);
		}
		session.close();
	}

	private static void listDepartmentsWithMoreThanNEmployees(Scanner sc) {
		Session session = sf.openSession();

		List<Department> dept = session.createQuery(
				"select d from Department d where (select count(e) from Employee e where e.dept.id = d.id) > :count",
				Department.class).setParameter("count", 3).getResultList();

		for (Department d : dept) {
			System.out.println("Department ID: " + d.getId() + ", Name: " + d.getName() + ", Location: "
					+ d.getLocation() + " | Employees: " + d.getEmployees().size());
		}

		session.close();
	}
}
