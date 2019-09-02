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

	@Column(name="ptid")
	private int parentId;
	
	@Column(name="pid")
	private int projId;

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

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int ptId) {
		this.parentId = ptId;
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
