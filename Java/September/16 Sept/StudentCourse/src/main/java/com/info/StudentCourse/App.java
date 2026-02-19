package com.info.StudentCourse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class App {
	private static SessionFactory sf;

	public static void main(String[] args) {
		System.out.println("Hello World!");

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n---Student-Course Management Menu---");
			System.out.println("1. Add Student with Courses");
			System.out.println("2. Add Course with Students");
			System.out.println("3. Enroll Existing Student into Existing Course");
			System.out.println("4. View All Students with Their Courses");
			System.out.println("5. View All Courses with Their Students");
			System.out.println("6. Update Course Name by Course ID");
			System.out.println("7. Update Student Details by Student ID");
			System.out.println("8. Exit");

			System.out.print("\nEnter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				addStudentWithCourses(sc);
				break;
			case 2:
				addCourseWithStudents(sc);
				break;
			case 3:
				enrollStudentInCourse(sc);
				break;
			case 4:
				viewAllStudentsWithCourses();
				break;
			case 5:
				viewAllCoursesWithStudents();
				break;
			case 6:
				updateCourseName(sc);
				break;
			case 7:
				updateStudentDetails(sc);
				break;
			case 8:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice!");
			}
		} while (choice != 8);

		sf.close();
		sc.close();
	}

	private static void addStudentWithCourses(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Student Name: ");
		String studentName = sc.nextLine();

		System.out.print("Enter Student Age: ");
		int age = sc.nextInt();
		sc.nextLine();

		Student s = new Student();
		s.setName(studentName);
		s.setAge(age);

		System.out.print("How many courses to assign? ");
		int count = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < count; i++) {
			System.out.print("Enter Course Name: ");
			String courseName = sc.nextLine();

			Course course = new Course();
			course.setName(courseName);

			s.getCourse().add(course);
			course.getStudent().add(s);
		}

		session.persist(s);
		tx.commit();
		session.close();
		System.out.println("Student and courses saved successfully.");
	}

	private static void addCourseWithStudents(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Course Name: ");
		String courseName = sc.nextLine();

		Course course = new Course();
		course.setName(courseName);

		System.out.print("How many students to assign? ");
		int count = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < count; i++) {
			System.out.print("Enter Student Name: ");
			String studentName = sc.nextLine();

			System.out.print("Enter Student Age: ");
			int age = sc.nextInt();
			sc.nextLine();

			Student s = new Student();
			s.setName(studentName);
			s.setAge(age);

			course.getStudent().add(s);
			s.getCourse().add(course);
		}

		session.persist(course);
		tx.commit();
		session.close();
		System.out.println("Course and students saved successfully.");

	}

	private static void enrollStudentInCourse(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Student ID: ");
		int studentId = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Course ID: ");
		int courseId = sc.nextInt();
		sc.nextLine();

		Student s = session.get(Student.class, studentId);
		Course c = session.get(Course.class, courseId);

		if (s != null && c != null) {
			s.getCourse().add(c);
			c.getStudent().add(s);

			session.persist(s);
			session.persist(c);

			tx.commit();
			System.out.println("Student enrolled in course successfully.");
		} else {
			System.out.println("Invalid Student ID or Course ID.");
		}

		session.close();
	}

	private static void viewAllStudentsWithCourses() {
		Session session = sf.openSession();
		List<Student> s = session.createQuery("from Student", Student.class).getResultList();

		for (Student st : s) {
			System.out.printf("\nStudent: %s | Age: %d\n", st.getName(), st.getAge());
			for (Course c : st.getCourse()) {
				System.out.printf(" -> Course: %s\n", c.getName());
			}
		}

		session.close();
	}

	private static void viewAllCoursesWithStudents() {
		Session session = sf.openSession();
		List<Course> l = session.createQuery("from Course", Course.class).getResultList();

		for (Course c : l) {
			System.out.printf("\nCourse: %s\n", c.getName());
			for (Student s : c.getStudent()) {
				System.out.printf(" -> Student: %s | Age: %d\n", s.getName(), s.getAge());
			}
		}

		session.close();
	}

	private static void updateCourseName(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Course ID: ");
		int courseId = sc.nextInt();
		sc.nextLine();

		Course c = session.get(Course.class, courseId);

		if (c != null) {
			System.out.print("Enter new Course Name: ");
			String newName = sc.nextLine();

			c.setName(newName);
			session.update(c);

			tx.commit();
			System.out.println("Course name updated successfully.");
		} else {
			System.out.println("Course not found.");
		}

		session.close();
	}

	private static void updateStudentDetails(Scanner sc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.print("Enter Student ID: ");
		int studentId = sc.nextInt();
		sc.nextLine();

		Student s = session.get(Student.class, studentId);

		if (s != null) {
			System.out.print("Enter new Student Name: ");
			String newName = sc.nextLine();

			System.out.print("Enter new Age: ");
			int newAge = sc.nextInt();
			sc.nextLine();

			s.setName(newName);
			s.setAge(newAge);
			session.update(s);

			tx.commit();
			System.out.println("Student details updated successfully.");
		} else {
			System.out.println("Student not found.");
		}

		session.close();
	}
}
