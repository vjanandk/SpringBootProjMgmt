package com.cognizant.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="projects")
public class Projects {
	@Id
	@GeneratedValue
	@Column(name="projid")
	private int projId;
	
	@Column(name="projname")
	private String projName;
	
	@Column(name="projstartdate")
	private Date projStartDate;
	
	@Column(name="projenddate")
	private Date projEndDate;
	
	@Column(name="projpriority")
	private int projPriority;

	public int getProjId() {
		return projId;
	}

	public void setProjId(int projId) {
		this.projId = projId;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public Date getProjStartDate() {
		return projStartDate;
	}

	public void setProjStartDate(Date projStartDate) {
		this.projStartDate = projStartDate;
	}

	public Date getProjEndDate() {
		return projEndDate;
	}

	public void setProjEndDate(Date projEndDate) {
		this.projEndDate = projEndDate;
	}

	public int getProjPriority() {
		return projPriority;
	}

	public void setProjPriority(int projPriority) {
		this.projPriority = projPriority;
	}

	@Override
	public String toString() {
		return "Projects [projId=" + projId + ", projName=" + projName + ", projStartDate=" + projStartDate
				+ ", projEndDate=" + projEndDate + ", projPriority=" + projPriority + "]";
	}
	
	
}
