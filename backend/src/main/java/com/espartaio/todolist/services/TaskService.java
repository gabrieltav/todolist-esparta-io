package com.espartaio.todolist.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.espartaio.todolist.dto.TaskDTO;
import com.espartaio.todolist.entities.Task;

import com.espartaio.todolist.repositories.TaskRepository;
import com.espartaio.todolist.services.exceptions.DatabaseException;
import com.espartaio.todolist.services.exceptions.ResourceNotFoundException;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;
	
	@Transactional(readOnly = true)
	public Page<TaskDTO> findAllPaged(Pageable pageable) {
		Page<Task> list = repository.findAll(pageable);
		return list.map(x -> new TaskDTO(x));
	}
	
	@Transactional(readOnly = true)
	public Page<TaskDTO> findAllActive(Pageable pageable) {
		Page<Task> active = repository.findAllActive(pageable);
		return active.map(x -> new TaskDTO(x));
	}
	
	@Transactional(readOnly = true)
	public Page<TaskDTO> findAllClosed(Pageable pageable) {
		Page<Task> closed = repository.findAllClosed(pageable);
		return closed.map(x -> new TaskDTO(x));
	}
	
	@Transactional(readOnly = true)
	public TaskDTO findById(Long id) {
		Optional<Task> obj = repository.findById(id);
		Task entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new TaskDTO(entity);
	}
	
	@Transactional
	public TaskDTO insert(TaskDTO dto) {
		Task entity = new Task();
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setDeadLine(dto.getDeadLine());
		entity.setTask_finish(dto.getTask_finish());
		entity = repository.save(entity);
		return new TaskDTO(entity);
	}
	
	@Transactional
	public TaskDTO update(Long id, TaskDTO dto) {
		try {
			Task entity = repository.getOne(id);
			entity.setTitle(dto.getTitle());
			entity.setDescription(dto.getDescription());
			entity.setDeadLine(dto.getDeadLine());
			entity.setTask_finish(dto.getTask_finish());
			entity = repository.save(entity);
			return new TaskDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " +id);
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

}
