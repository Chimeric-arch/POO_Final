package com.senai.trabalhofinal.poo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.trabalhofinal.poo.model.TaskModel;
import com.senai.trabalhofinal.poo.service.TaskService;

@CrossOrigin("*")
@RestController
@RequestMapping("/tasks")
public class TaskController {
  @Autowired
  private TaskService taskService;

  @GetMapping
  public ResponseEntity<List<TaskModel>> findAll() {
    return ResponseEntity.status(HttpStatus.OK).body(taskService.findAll());
  }

  @GetMapping(path = "/open")
  public ResponseEntity<List<TaskModel>> findAllOpen() {
    return ResponseEntity.status(HttpStatus.OK).body(taskService.findAllOpen());
  }

  @GetMapping(path = "/closed")
  public ResponseEntity<List<TaskModel>> findAllClosed() {
    return ResponseEntity.status(HttpStatus.OK).body(taskService.findAllClosed());
  }
}
