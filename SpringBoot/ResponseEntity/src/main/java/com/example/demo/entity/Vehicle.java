package com.example.demo.entity;

public class Vehicle {
	private int id;
	private String ownerName;
	private String vehicleNumber;
	private String vehicleType;
	private String serviceType;
	private double cost;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Vehicle() {
		super();
	}

	public Vehicle(int id, String ownerName, String vehicleNumber, String vehicleType, String serviceType, double cost,
			String status) {
		super();
		this.id = id;
		this.ownerName = ownerName;
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
		this.serviceType = serviceType;
		this.cost = cost;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", ownerName=" + ownerName + ", vehicleNumber=" + vehicleNumber + ", vehicleType="
				+ vehicleType + ", serviceType=" + serviceType + ", cost=" + cost + ", status=" + status + "]";
	}
}
