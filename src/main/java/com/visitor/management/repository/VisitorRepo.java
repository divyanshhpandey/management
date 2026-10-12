package com.visitor.management.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visitor.management.entity.Visitor;

public interface VisitorRepo extends JpaRepository<Visitor, Long> {
	List<Visitor> findByCheckInBetween(LocalDateTime start, LocalDateTime end);
	List<Visitor> findByHostEmployeeContainingIgnoreCase(String hostEmployee);
	List<Visitor> findByNameContainingIgnoreCase(String name);
}
