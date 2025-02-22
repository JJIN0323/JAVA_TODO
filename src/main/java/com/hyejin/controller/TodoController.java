package com.hyejin.controller;

import com.hyejin.model.TodoResponse;
import com.hyejin.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/")
public class TodoController {

    private final TodoService service;

    @PostMapping
    public ResponseEntity<TodoResponse> create() {
        System.out.println("CREATE");
        return null;
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> readAll() {
        System.out.println("READ ALL");
        return null;
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoResponse> readOne() {
        System.out.println("READ ONE");
        return null;
    }

    @PatchMapping("{id}")
    public ResponseEntity<TodoResponse> update() {
        System.out.println("UPDATE");
        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne() {
        System.out.println("DELETE");
        return null;
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        System.out.println("DELETE ALL");
        return null;
    }
}