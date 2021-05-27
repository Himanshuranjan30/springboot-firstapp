package com.first.firstapp.entities;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class course {


	@Override
	public String toString() {
		return "course [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
	public long getId() {
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProperty(String key)
	{
		switch (key) {
		case "title":
			
			return this.title;
		case "description":
		     return this.description;

		default:
			return "helo";
		}
	}
	public course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public course(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	
	}
	@Id
	private int id;
	private String title;
	private String description;
}
