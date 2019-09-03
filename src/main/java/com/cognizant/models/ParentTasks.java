package com.cognizant.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parenttasks")
public class ParentTasks {
	@Id
	@GeneratedValue
	@Column(name="ptid")
	private int parentId;
	
	@Column(name="ptname")
	private String taskNameParent;

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getTaskNameParent() {
		return taskNameParent;
	}

	public void setTaskNameParent(String taskNameParent) {
		this.taskNameParent = taskNameParent;
	}

	@Override
	public String toString() {
		return "ParentTasks [parentId=" + parentId + ", taskNameParent=" + taskNameParent + "]";
	}

	public ParentTasks(int parentId, String taskNameParent) {
		super();
		this.parentId = parentId;
		this.taskNameParent = taskNameParent;
	}
	
	
	
}
