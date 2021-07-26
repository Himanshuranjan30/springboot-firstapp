package com.first.firstapp.entities;

import java.util.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.sun.source.util.TreePathScanner;



@Entity
@EntityListeners(AuditingEntityListener.class)
public class course {

	@Override
	public String toString() {
		return "course [id=" + id + ", title=" + title + ", description=" + description + "]";
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}







	public List<subject> getSubjects() {
		return subjects;
	}



	public void setSubjects(List<subject> subjects) {
		this.subjects = subjects;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getProperty(String key) {
		switch (key) {
		case "title":

			return this.title;
		case "description":
			return this.description;
		case "date":
			return this.date.toString();
		case "id":
			return Integer.toString(this.id);

		default:
			return "helo";
		}
	}

	public course() {
		super();
		// TODO Auto-generated constructor stub
	}














	public course(int id, String title, List<subject> subjects, String description, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.subjects = subjects;
		this.description = description;
		this.date = date;
	}














	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	@OneToMany(targetEntity = subject.class,cascade = CascadeType.ALL)
	private List<subject> subjects;
	private String description;
	@CreatedDate
	@Temporal(TemporalType.DATE)
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
