package com.acelerazg.todoapp.repository

import com.acelerazg.todoapp.model.entity.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findAll()

}
