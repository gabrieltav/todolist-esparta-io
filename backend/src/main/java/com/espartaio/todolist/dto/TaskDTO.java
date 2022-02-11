package com.espartaio.todolist.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.espartaio.todolist.entities.Task;

public class TaskDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@Size(min = 5, max = 60,message = "Deve ter entre 5 e 60 caracteres")
	@NotBlank(message = "Campo requerido")
	private String title;
	
	@NotBlank(message = "Campo requerido")
	private String description;
	
	@NotBlank(message = "Campo requerido")
	private Date dead_line;
	
	private Boolean task_finish = false;
	
	public TaskDTO() {
		
	}

	public TaskDTO(Long id,
			@Size(min = 5, max = 60, message = "Deve ter entre 5 e 60 caracteres") @NotBlank(message = "Campo requerido") String title,
			@NotBlank(message = "Campo requerido") String description,
			@NotBlank(message = "Campo requerido") Date dead_line, Boolean task_finish) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.dead_line = dead_line;
		this.task_finish = task_finish;
	}
	
	public TaskDTO(Task entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.description = entity.getDescription();
		this.dead_line = entity.getDeadLine();
		this.task_finish = entity.getTask_finish();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDeadLine() {
		return dead_line;
	}

	public void setDeadLine(Date deadLine) {
		this.dead_line = deadLine;
	}

	public Boolean getTask_finish() {
		return task_finish;
	}

	public void setTask_finish(Boolean task_finish) {
		this.task_finish = task_finish;
	}
}
