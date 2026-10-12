package com.visitor.management.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.visitor.management.entity.Visitor;
import com.visitor.management.services.VisitorService;

@RestController
@RequestMapping("/visitors")
public class VisitorController {
    @Autowired
    private VisitorService visitorService;

    @PostMapping
    public ResponseEntity<Visitor> registerVisitor(@RequestBody Visitor visitor) {
        return ResponseEntity.ok(visitorService.registerVisitor(visitor));
    }

    @PutMapping("/{id}/checkout")
    public ResponseEntity<Visitor> checkoutVisitor(@PathVariable Long id) {
        return ResponseEntity.ok(visitorService.checkOutVisitor(id));
    }

    @GetMapping
    public ResponseEntity<List<Visitor>> getVisitors(
        @RequestParam(required = false) String date,
        @RequestParam(required = false) String employee,
        @RequestParam(required = false) String name) {

        if (date != null) {
            return ResponseEntity.ok(visitorService.getVisitorsByDate(LocalDate.parse(date)));
        } else if (employee != null) {
            return ResponseEntity.ok(visitorService.getVisitorsByHost(employee));
        } else if (name != null) {
            return ResponseEntity.ok(visitorService.getVisitorsByName(name));
        } else {
            return ResponseEntity.ok(visitorService.getAllVisitors());
        }
    }
}