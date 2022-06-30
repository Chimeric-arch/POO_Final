package com.senai.trabalhofinal.poo.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "task")
public class TaskModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private LocalDate date_end;

  @Column(nullable = false)
  private LocalTime time_end;

  @Column(nullable = false)
  private boolean status;

  public TaskModel(String name, LocalDate date_end, LocalTime time_end, boolean status) {
    this.name = name;
    this.date_end = date_end;
    this.time_end = time_end;
    this.status = status;
  }

  public TaskModel() {
  }

}
