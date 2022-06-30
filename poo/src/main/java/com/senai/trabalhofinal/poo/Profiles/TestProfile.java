package com.senai.trabalhofinal.poo.Profiles;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.senai.trabalhofinal.poo.model.TaskModel;
import com.senai.trabalhofinal.poo.service.TaskService;

@Configuration
@Profile("test")
public class TestProfile {

  @Autowired
  private TaskService taskService;

  @Bean
  public boolean taskTests() {

    TaskModel task = new TaskModel("Ir para o Viscardi", LocalDate.of(2022, 6, 30), LocalTime.of(17, 59, 32), true);
    // taskService.create(task);
    // taskService.deleteById(1);
    taskService.deleteAll();
    // taskService.updateById(4, task);

    return true;
  }

}
