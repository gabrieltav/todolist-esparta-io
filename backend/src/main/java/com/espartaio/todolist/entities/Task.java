package com.espartaio.todolist.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tasks")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Date dead_line;
	
	private Boolean task_finish;
	
	public Task() {
		
	}

	public Task(Long id, String title, String description, Date dead_line, Boolean task_finish) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.dead_line = dead_line;
		this.task_finish = task_finish;
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

	public void setDeadLine(Date dead_line) {
		this.dead_line = dead_line;
	}

	public Boolean getTask_finish() {
		return task_finish;
	}

	public void setTask_finish(Boolean task_finish) {
		this.task_finish = task_finish;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", dead_line=" + dead_line
				+ ", task_finish=" + task_finish + "]";
	}
}
