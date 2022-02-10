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
	private Date deadLine;
	
	private Date createdAt;
	private Date updatedAt;
	
	public TaskDTO() {
		
	}
	
	public TaskDTO(Long id, String title, String description, Date deadLine, Date createdAt, Date updatedAt) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.deadLine = deadLine;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public TaskDTO(Task entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.description = entity.getDescription();
		this.deadLine = entity.getDeadLine();
		this.createdAt = entity.getCreatedAt();
		this.updatedAt = entity.getUpdatedAt();
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
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}