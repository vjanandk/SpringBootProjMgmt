package com.cognizant.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tasks")
public class Tasks {
	@Id
	@GeneratedValue
	@Column(name="tid")
	private int taskId;

	@ManyToOne
	@JoinColumn(name="ptid")
	private ParentTasks parentTasks;
	
	@ManyToOne
	@JoinColumn(name="pid")
	private Projects projects;

	
	@Column(name="tname")
	private String taskName;
	
	@Column(name="tstartdate")
	@Temporal(TemporalType.DATE)
	private Date taskStartDate;
	
	@Column(name="tenddate")
	@Temporal(TemporalType.DATE)
	private Date taskEndDate;
	
	@Column(name="tpriority")
	private int taskPriority;
	
	@Column(name="tstatus")
	private String taskStatus;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public ParentTasks getParentTasks() {
		return parentTasks;
	}

	public void setParentTasks(ParentTasks parentTasks) {
		this.parentTasks = parentTasks;
	}

	public Projects getProjects() {
		return projects;
	}

	public void setProjects(Projects projects) {
		this.projects = projects;
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
		return "Tasks [taskId=" + taskId + ", parentTasks=" + parentTasks + ", projects=" + projects + ", taskName="
				+ taskName + ", taskStartDate=" + taskStartDate + ", taskEndDate=" + taskEndDate + ", taskPriority="
				+ taskPriority + ", taskStatus=" + taskStatus + "]";
	}

		
}
