package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Hospital;

@Service
public class HospitalService {
	public static List<Hospital> list = new ArrayList<>();

	static {
		list.add(new Hospital(1, "Harshita", 20, "Female", "Migrane", 5000));
		list.add(new Hospital(2, "Mayuri", 17, "Female", "Fever", 4000));
		list.add(new Hospital(3, "Raksha", 13, "Female", "Cold", 3000));
	}

	public List<Hospital> getAll() {
		return list;
	}

	public Hospital getById(int id) {
		Iterator<Hospital> itr = list.iterator();

		while (itr.hasNext()) {
			Hospital h = itr.next();
			if (h.getId() == id) {
				return h;
			}
		}
		return null;
	}

	public Hospital addPatient(Hospital h) {
		list.add(h);
		return h;
	}

	public Hospital updateById(int id, Hospital h) {
		Iterator<Hospital> itr = list.iterator();

		while (itr.hasNext()) {
			Hospital hospital = itr.next();
			if (hospital.getId() == id) {
				hospital.setName(h.getName());
				hospital.setAge(h.getAge());
				hospital.setGender(h.getGender());
				hospital.setDisease(h.getDisease());
				hospital.setBill(h.getBill());
				return h;
			}
		}
		return null;
	}

	public String removeById(int id) {
		Iterator<Hospital> itr = list.iterator();

		while (itr.hasNext()) {
			Hospital h = itr.next();
			if (h.getId() == id) {
				itr.remove();
				return "Patient deleted successfully!";
			}
		}
		return null;
	}

	public String removeByDisease(String disease) {
		boolean found = false;
		Iterator<Hospital> itr = list.iterator();

		while (itr.hasNext()) {
			Hospital h = itr.next();
			if (h.getDisease().equalsIgnoreCase(disease)) {
				itr.remove();
				found = true;
			}
		}
		return found ? "Delete patient successfully!" : "Patient not found";
	}

	public List<Hospital> getByDisease(String disease) {
		List<Hospital> l = new ArrayList<>();
		Iterator itr = list.iterator();

		while (itr.hasNext()) {
			Hospital h = (Hospital) itr.next();
			if (h.getDisease().equalsIgnoreCase(disease)) {
				l.add(h);
			}
		}
		return l;
	}

	public Hospital getHighestBill() {
		if (list.isEmpty()) {
			return null;
		}

		Iterator<Hospital> itr = list.iterator();
		Hospital max = itr.next();

		while (itr.hasNext()) {
			Hospital h = itr.next();
			if (h.getBill() > max.getBill()) {
				max = h;
			}
		}
		return max;
	}

	public double getAverageBill() {
		if (list.isEmpty()) {
			return 0.0;
		}

		double total = 0;
		int count = 0;
		Iterator<Hospital> itr = list.iterator();

		while (itr.hasNext()) {
			Hospital h = itr.next();
			total += h.getBill();
			count++;
		}
		return total / count;
	}

	public int getTotalCount() {
		return list.size();
	}

	public List<Hospital> getByAgeAbove(int age) {
		List<Hospital> l = new ArrayList<>();
		Iterator<Hospital> itr = list.iterator();

		while (itr.hasNext()) {
			Hospital h = itr.next();
			if (h.getAge() > age) {
				l.add(h);
			}
		}
		return l;
	}

	public List<Hospital> findByNameAgeGenderDiseaseAndBill(String name, Integer age, String gender, String disease,
			Double bill) {
		List<Hospital> allHospitals = getAll();
		List<Hospital> result = new ArrayList<>();

		for (Hospital hospital : allHospitals) {
			boolean matchName = (name == null || name.isEmpty()) || hospital.getName().equalsIgnoreCase(name);

			boolean matchAge = (age == null || age == 0) || hospital.getAge() == age;

			boolean matchGender = (gender == null || gender.isEmpty()) || hospital.getGender().equalsIgnoreCase(gender);

			boolean matchDisease = (disease == null || disease.isEmpty())
					|| hospital.getDisease().equalsIgnoreCase(disease);

			boolean matchBill = (bill == null || bill == 0) || Double.compare(hospital.getBill(), bill) == 0;

			if (matchName && matchAge && matchGender && matchDisease && matchBill) {
				result.add(hospital);
			}
		}
		return result;
	}
}
