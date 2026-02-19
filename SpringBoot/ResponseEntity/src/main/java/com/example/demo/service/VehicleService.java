package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Vehicle;

@Service
public class VehicleService {

	private static List<Vehicle> list = new ArrayList<>();

	static {
		list.add(new Vehicle(1, "Harshita", "MP09AB1234", "Car", "Regular", 2500, "Completed"));
		list.add(new Vehicle(2, "Mayuri", "MP10XY5678", "Bike", "Repair", 800, "Pending"));
		list.add(new Vehicle(3, "Vanshika", "MH12KL9999", "SUV", "Full", 5000, "Completed"));
	}

	public List<Vehicle> getAll() {
		return list;
	}

	public Vehicle getById(int id) {
		Iterator<Vehicle> itr = list.iterator();

		while (itr.hasNext()) {
			Vehicle v = itr.next();
			if (v.getId() == id) {
				return v;
			}
		}
		return null;
	}

	public Vehicle add(Vehicle v) {
		list.add(v);
		return v;
	}

	public Vehicle update(int id, Vehicle v) {
		Iterator<Vehicle> itr = list.iterator();

		while (itr.hasNext()) {
			Vehicle v1 = itr.next();
			if (v1.getId() == id) {
				v1.setOwnerName(v.getOwnerName());
				v1.setVehicleNumber(v.getVehicleNumber());
				v1.setVehicleType(v.getVehicleType());
				v1.setServiceType(v.getServiceType());
				v1.setCost(v.getCost());
				v1.setStatus(v.getStatus());
				return v1;
			}
		}
		return null;
	}

	public String deleteById(int id) {
		Iterator<Vehicle> itr = list.iterator();

		while (itr.hasNext()) {
			Vehicle v = itr.next();

			if (v.getId() == id) {
				itr.remove();
				return "Vehicle deleted successfully!";
			}
		}
		return null;
	}

	public List<Vehicle> getByType(String type) {
		List<Vehicle> result = new ArrayList<>();

		Iterator<Vehicle> itr = list.iterator();

		while (itr.hasNext()) {
			Vehicle v = itr.next();
			if (v.getVehicleType().equalsIgnoreCase(type)) {
				result.add(v);
			}
		}
		return result;
	}

	public List<Vehicle> getByStatus(String status) {
		List<Vehicle> result = new ArrayList<>();

		Iterator<Vehicle> itr = list.iterator();

		while (itr.hasNext()) {
			Vehicle v = itr.next();
			if (v.getStatus().equalsIgnoreCase(status)) {
				result.add(v);
			}
		}
		return result;
	}

	public String deleteByStatus(String status) {
		boolean deleted = false;

		Iterator<Vehicle> itr = list.iterator();

		while (itr.hasNext()) {
			Vehicle v = itr.next();
			if (v.getStatus().equalsIgnoreCase(status)) {
				itr.remove();
				deleted = true;
			}
		}
		if (deleted) {
			return "All vehicles with status '" + status + "' deleted successfully!";
		} else {
			return "No vehicles found with status '" + status + "'";
		}
	}

	public Vehicle getHighestCost() {
		if (list.isEmpty())
			return null;

		Iterator<Vehicle> itr = list.iterator();

		Vehicle max = itr.next();
		while (itr.hasNext()) {
			Vehicle v = itr.next();
			if (v.getCost() > max.getCost()) {
				max = v;
			}
		}
		return max;
	}

	public double getAverageCost() {
		if (list.isEmpty())
			return 0.0;

		double total = 0;
		int count = 0;

		Iterator<Vehicle> itr = list.iterator();

		while (itr.hasNext()) {
			Vehicle v = itr.next();
			total += v.getCost();
			count++;
		}
		return total / count;
	}

	public int getCount() {
		return list.size();
	}

	public List<Vehicle> getCostAbove(double amount) {
		List<Vehicle> result = new ArrayList<>();

		Iterator<Vehicle> itr = list.iterator();

		while (itr.hasNext()) {
			Vehicle v = itr.next();
			if (v.getCost() > amount) {
				result.add(v);
			}
		}
		return result;
	}

	public List<Vehicle> findByOwnerVehicleTypeServiceTypeCostAndStatus(String ownerName, String vehicleType,
			String serviceType, Double cost, String status) {

		List<Vehicle> result = new ArrayList<>();

		for (Vehicle v : getAll()) {

			boolean matchOwner = (ownerName == null || ownerName.isEmpty())
					|| (v.getOwnerName() != null && v.getOwnerName().toLowerCase().contains(ownerName.toLowerCase()));

			boolean matchVehicleType = (vehicleType == null || vehicleType.isEmpty())
					|| (v.getVehicleType() != null && v.getVehicleType().equalsIgnoreCase(vehicleType));

			boolean matchServiceType = (serviceType == null || serviceType.isEmpty())
					|| (v.getServiceType() != null && v.getServiceType().equalsIgnoreCase(serviceType));

			boolean matchCost = (cost == null || cost == 0) || Double.compare(v.getCost(), cost) == 0;

			boolean matchStatus = (status == null || status.isEmpty())
					|| (v.getStatus() != null && v.getStatus().equalsIgnoreCase(status));

			if (matchOwner && matchVehicleType && matchServiceType && matchCost && matchStatus) {
				result.add(v);
			}
		}
		return result;
	}
}
