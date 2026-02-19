package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Hospital;

import com.example.demo.service.HospitalService;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {
	@Autowired
	private HospitalService hs;

	@GetMapping("/getAll")
	public List<Hospital> getAllPatients() {
		return hs.getAll();
	}

	@GetMapping("/getById/{id}")
	public Hospital getPatientById(@PathVariable int id) {
		return hs.getById(id);
	}

	@PostMapping("/addPatient")
	public Hospital addPatient(@RequestBody Hospital h) {
		return hs.addPatient(h);
	}

	@PutMapping("/updateById/{id}")
	public Hospital updatePatient(@PathVariable int id, @RequestBody Hospital h) {
		return hs.updateById(id, h);
	}

	@DeleteMapping("/deleteById/{id}")
	public String removeById(@PathVariable int id) {
		return hs.removeById(id);
	}

	@DeleteMapping("/deleteByDisease/{disease}")
	public String deleteByDisease(@PathVariable String disease) {
		return hs.removeByDisease(disease);
	}

	@GetMapping("/GetByDisease/{disease}")
	public List<Hospital> getPatientsByDisease(@PathVariable String disease) {
		return hs.getByDisease(disease);
	}

	@GetMapping("/highestBill")
	public Hospital getHighestBillPatient() {
		return hs.getHighestBill();
	}

	@GetMapping("/averageBill")
	public double getAverageBill() {
		return hs.getAverageBill();
	}

	@GetMapping("/count")
	public int getTotalCount() {
		return hs.getTotalCount();
	}

	@GetMapping("/ageAbove/{age}")
	public List<Hospital> getPatientsAboveAge(@PathVariable int age) {
		return hs.getByAgeAbove(age);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Hospital>> searchHospitals(@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer age, @RequestParam(required = false) String gender,
			@RequestParam(required = false) String disease, @RequestParam(required = false) Double bill) {

		List<Hospital> result = hs.findByNameAgeGenderDiseaseAndBill(name, age, gender, disease, bill);
		return ResponseEntity.ok(result);
	}
}
