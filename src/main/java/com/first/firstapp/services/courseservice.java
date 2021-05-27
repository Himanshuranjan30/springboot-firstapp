package com.first.firstapp.services;

import java.util.List;
import java.util.Map;

import com.first.firstapp.entities.course;

public interface courseservice {

	public List<course> getcourses();
	public course getcourse(int courseid);
	public course postcourse(course cr);
	public course updatecourse(course c);
	public course deletecourse(int courseid);
	public Map<String, Object> getfilt(Map<String, String> params);
	public String getprocedure();
}
