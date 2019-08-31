package com.cognizant.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tasks")
public class Tasks {
	@Id
	@GeneratedValue
	@Column(name="taskid")
	private int taskId;

	
	@Column(name="parentid")
	private int parentId;
	
	@Column(name="projid")
	private int projId;

	
	@Column(name="taskname")
	private String taskName;
	
	@Column(name="taskstartdate")
	private Date taskStartDate;
	
	@Column(name="taskenddate")
	private Date taskEndDate;
	
	@Column(name="taskpriority")
	private int taskPriority;
	
	@Column(name="taskstatus")
	private String taskStatus;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getProjId() {
		return projId;
	}

	public void setProjId(int projId) {
		this.projId = projId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Date getTaskStartDate() {
		return taskStartDate;
	}

	public void setTaskStartDate(Date taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	public Date getTaskEndDate() {
		return taskEndDate;
	}

	public void setTaskEndDate(Date taskEndDate) {
		this.taskEndDate = taskEndDate;
	}

	public int getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(int taskPriority) {
		this.taskPriority = taskPriority;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	@Override
	public String toString() {
		return "Tasks [taskId=" + taskId + ", parentId=" + parentId + ", projId=" + projId + ", taskName=" + taskName
				+ ", taskStartDate=" + taskStartDate + ", taskEndDate=" + taskEndDate + ", taskPriority=" + taskPriority
				+ ", taskStatus=" + taskStatus + "]";
	}
	
	
}
