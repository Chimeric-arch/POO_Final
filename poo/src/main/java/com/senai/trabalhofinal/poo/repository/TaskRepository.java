package com.senai.trabalhofinal.poo.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.senai.trabalhofinal.poo.model.TaskModel;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Integer> {

  @Query("SELECT id FROM task tsk WHERE tsk.status = false")
  List<Integer> findAllOpen();

  @Query("SELECT id FROM task tsk WHERE tsk.status = true")
  List<Integer> findAllClosed();

  @Transactional
  @Modifying
  @Query("UPDATE task tsk SET tsk.name = :nm, tsk.date_end = :dte, tsk.time_end = :tme, tsk.status = :stts WHERE tsk.id = :id")
  void updateById(@Param("id") Integer id, @Param("nm") String nm, @Param("tme") LocalTime tme,
      @Param("dte") LocalDate dte, @Param("stts") boolean stts);
}
