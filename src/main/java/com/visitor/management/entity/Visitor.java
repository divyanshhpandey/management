package com.visitor.management.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Visitor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String contactNumber;
	private String purpose;
	private String hostEmployee;
	private LocalDateTime checkIn;
	private LocalDateTime checkOut;
	private String status;
	
	public Visitor() {
		
	}
	
	public Visitor(Long id, String name, String contactNumber, String purpose, String hostEmployee, LocalDateTime checkIn,
			LocalDateTime checkOut, String status) {
		super();
		this.id = id;
		this.name = name;
		this.contactNumber = contactNumber;
		this.purpose = purpose;
		this.hostEmployee = hostEmployee;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcontactNumber() {
		return contactNumber;
	}

	public void setcontactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getHostEmployee() {
		return hostEmployee;
	}

	public void setHostEmployee(String hostEmployee) {
		this.hostEmployee = hostEmployee;
	}

	public LocalDateTime getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDateTime checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDateTime getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDateTime checkOut) {
		this.checkOut = checkOut;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
		
}
