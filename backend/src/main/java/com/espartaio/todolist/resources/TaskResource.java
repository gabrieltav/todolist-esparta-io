package com.espartaio.todolist.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.espartaio.todolist.dto.TaskDTO;
import com.espartaio.todolist.services.TaskService;

@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {
	
	private TaskService service;
	
	@GetMapping
	public ResponseEntity<Page<TaskDTO>> findAll(Pageable pageable) {
		Page<TaskDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}

}
