package com.espartaio.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.espartaio.todolist.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
