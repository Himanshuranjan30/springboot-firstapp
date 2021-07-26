package com.first.firstapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class subject {
   public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComplexity() {
		return complexity;
	}
	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}
public subject(String name, String complexity) {
		super();
		this.name = name;
		this.complexity = complexity;
	}
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
  private int id;
   private String name;
   private String complexity;
   
}
