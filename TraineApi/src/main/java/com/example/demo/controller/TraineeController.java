package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Traine;
import com.example.demo.service.ITraineService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/trainees")
public class TraineeController {

    @Autowired
    private ITraineService service;

    @GetMapping
    public ResponseEntity<List<Traine>> getAll() {
        List<Traine> list = service.getAllTrainees();
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Traine> getById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(service.getTraineeById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Traine> add(@Valid @RequestBody Traine t) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.addTrainee(t));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Traine> update(@PathVariable int id, @RequestBody Traine t) {
        try {
            return ResponseEntity.ok(service.updateTrainee(id, t));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        try {
            service.deleteTrainee(id);
            return ResponseEntity.ok("Deleted Successfully");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Traine>> search(@RequestParam String name) {
        List<Traine> list = service.getTraineeByName(name);
        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }
}