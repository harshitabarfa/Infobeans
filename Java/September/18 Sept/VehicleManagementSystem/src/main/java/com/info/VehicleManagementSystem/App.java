package com.info.VehicleManagementSystem;

import jakarta.persistence.*;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyUnit");
		EntityManager em = factory.createEntityManager();

		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n---Vehicle Management Sysem---");
			System.out.println("1. Add New Vehicle");
			System.out.println("2. View Vehicle by ID");
			System.out.println("3. Update Vehicle");
			System.out.println("4. Delete Vehicle");
			System.out.println("0. Exit");

			System.out.print("\nEnter choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				addVehicle(em, sc);
				break;
			case 2:
				viewVehicle(em, sc);
				break;
			case 3:
				updateVehicle(em, sc);
				break;
			case 4:
				deleteVehicle(em, sc);
				break;
			case 0:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice!");
			}
		} while (choice != 0);

		factory.close();
	}

	private static void addVehicle(EntityManager em, Scanner sc) {
		System.out.print("Enter Brand: ");
		String brand = sc.nextLine();

		System.out.print("Enter Model: ");
		String model = sc.nextLine();

		System.out.print("Enter Type (Car/Bike/Truck): ");
		String type = sc.nextLine();

		System.out.print("Enter Price: ");
		double price = sc.nextDouble();

		Vehicle vehicle = new Vehicle();

		vehicle.setBrand(brand);
		vehicle.setModel(model);
		vehicle.setType(type);
		vehicle.setPrice(price);

		em.getTransaction().begin();
		em.persist(vehicle);
		em.getTransaction().commit();
		System.out.println("Book added successfully!");
	}

	private static void viewVehicle(EntityManager em, Scanner sc) {
		System.out.print("Enter Vehicle ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		Vehicle vehicle = em.find(Vehicle.class, id);
		if (vehicle != null) {
			System.out.println(vehicle);
		} else {
			System.out.println("Vehicle not found!");
		}
	}

	private static void updateVehicle(EntityManager em, Scanner sc) {
		System.out.print("Enter Vehicle ID to Update: ");
		int id = sc.nextInt();
		sc.nextLine();

		Vehicle vehicle = em.find(Vehicle.class, id);
		if (vehicle != null) {
			System.out.print("Enter new Brand: ");
			vehicle.setBrand(sc.nextLine());

			System.out.print("Enter new Model: ");
			vehicle.setModel(sc.nextLine());

			System.out.print("Enter new Type: ");
			vehicle.setType(sc.nextLine());

			System.out.print("Enter new Price: ");
			vehicle.setPrice(sc.nextDouble());

			em.getTransaction().begin();
			em.merge(vehicle);
			em.getTransaction().commit();
			System.out.println("Vehicle updated successfully!");
		} else {
			System.out.println("Vehicle not found!");
		}

	}

	private static void deleteVehicle(EntityManager em, Scanner sc) {
		System.out.print("Enter Vehicle ID to Delete: ");
		int id = sc.nextInt();

		Vehicle vehicle = em.find(Vehicle.class, id);
		if (vehicle != null) {
			em.getTransaction().begin();
			em.remove(vehicle);
			em.getTransaction().commit();
			System.out.println("Vehicle deleted!");
		} else {
			System.out.println("Vehicle not found!");
		}
	}
}
