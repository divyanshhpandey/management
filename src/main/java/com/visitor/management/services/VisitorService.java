package com.visitor.management.services;

import java.time.LocalDate;
import java.util.List;

import com.visitor.management.entity.Visitor;

public interface VisitorService {
	
	public Visitor registerVisitor(Visitor visitor);
	public Visitor checkOutVisitor(Long id);
	public List<Visitor> getAllVisitors();
	public List<Visitor> getVisitorsByDate(LocalDate date);
	public List<Visitor> getVisitorsByHost(String host);
	public List<Visitor> getVisitorsByName(String name);
}
