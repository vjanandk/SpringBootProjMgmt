package com.cognizant.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="projects")
public class Projects {
	@Id
	@GeneratedValue
	@Column(name="pid")
	private int projId;
	
	@Column(name="pname")
	private String projName;
	
	@Column(name="pstartdate")
	@Temporal(TemporalType.DATE)
//	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date projStartDate;
	
	@Column(name="penddate")
	@Temporal(TemporalType.DATE)
//	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date projEndDate;
	
	@Column(name="ppriority")
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
