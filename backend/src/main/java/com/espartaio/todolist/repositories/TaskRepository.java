package com.espartaio.todolist.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.espartaio.todolist.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	@Query("SELECT obj FROM Task obj WHERE obj.task_finish = false ORDER BY obj.dead_line")
	Page<Task>findAllActive(Pageable pageable);
	
	@Query("SELECT obj FROM Task obj WHERE obj.task_finish = true ORDER BY obj.dead_line")
	Page<Task>findAllClosed(Pageable pageable);
}
