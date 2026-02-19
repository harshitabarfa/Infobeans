package com.third.LibraryMember;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "libraryMember")
public class LibraryMember {
	@Id
	private int memberId;
	private String name;
	private String email;
	private String phoneNumber;
	private String membershipType;
	private Date joinDate;

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public LibraryMember() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LibraryMember(int memberId, String name, String email, String phoneNumber, String membershipType,
			Date joinDate) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.membershipType = membershipType;
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "LibraryMember [memberId=" + memberId + ", name=" + name + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", membershipType=" + membershipType + ", joinDate=" + joinDate + "]";
	}
}
