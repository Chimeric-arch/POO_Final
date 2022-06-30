package com.senai.trabalhofinal.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.trabalhofinal.poo.model.TaskModel;
import com.senai.trabalhofinal.poo.repository.TaskRepository;

@Service
public class TaskService {
  @Autowired
  private TaskRepository taskRepository;

  public List<TaskModel> findAll() {
    return taskRepository.findAll();
  }

  public TaskModel findById(Integer id) {
    return taskRepository.findById(id).orElse(null);
  }

  public List<TaskModel> findAllOpen() {
    return taskRepository.findAllById(taskRepository.findAllOpen());
  }

  public List<TaskModel> findAllClosed() {
    return taskRepository.findAllById(taskRepository.findAllClosed());
  }

  public TaskModel create(TaskModel task) {
    return taskRepository.save(task);
  }

  public void deleteById(Integer id) {
    taskRepository.deleteById(id);
  }

  public void deleteAll() {
    taskRepository.deleteAll();
  }

  public void updateById(Integer id, TaskModel newM) {
    taskRepository.updateById(id,
        newM.getName(),
        newM.getTime_end(),
        newM.getDate_end(),
        newM.isStatus());
  }
}
