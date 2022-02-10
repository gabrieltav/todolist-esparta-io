package com.espartaio.todolist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.espartaio.todolist.dto.TaskDTO;
import com.espartaio.todolist.entities.Task;

import com.espartaio.todolist.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;
	
	@Transactional(readOnly = true)
	public Page<TaskDTO> findAllPaged(Pageable pageable) {
		Page<Task> list = repository.findAll(pageable);
		return list.map(x -> new TaskDTO(x));
	}
	
	@Transactional
	public TaskDTO insert(TaskDTO dto) {
		Task entity = new Task();
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setDeadLine(dto.getDeadLine());
		entity = repository.save(entity);
		return new TaskDTO(entity);
	}

}
