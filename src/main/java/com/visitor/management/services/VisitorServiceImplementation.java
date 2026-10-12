package com.visitor.management.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visitor.management.entity.Visitor;
import com.visitor.management.repository.VisitorRepo;

@Service
public class VisitorServiceImplementation implements VisitorService  {
	
	@Autowired
	private VisitorRepo visitorRepo;

	@Override
	public Visitor registerVisitor(Visitor visitor) {
		visitor.setCheckIn(LocalDateTime.now());
		visitor.setStatus("Checked-In");
		return visitorRepo.save(visitor);
	}

	@Override
	public Visitor checkOutVisitor(Long id) {
		Visitor visitor = visitorRepo.findById(id).orElseThrow();
		visitor.setCheckOut(LocalDateTime.now());
		visitor.setStatus("Checked-Out");
		return visitorRepo.save(visitor);
	}

	@Override
	public List<Visitor> getAllVisitors() {
		return visitorRepo.findAll();
	}

	@Override
	public List<Visitor> getVisitorsByDate(LocalDate date) {
		return visitorRepo.findByCheckInBetween(
            date.atStartOfDay(), date.atTime(LocalTime.MAX));

	}

	@Override
	public List<Visitor> getVisitorsByHost(String host) {
		 return visitorRepo.findByHostEmployeeContainingIgnoreCase(host);
	}

	@Override
	public List<Visitor> getVisitorsByName(String name) {
		return visitorRepo.findByNameContainingIgnoreCase(name);
	}

}
