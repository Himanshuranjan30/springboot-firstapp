package com.first.firstapp.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.first.firstapp.dao.coursesdao;
import com.first.firstapp.entities.course;
@Service
public class courseserviceimpl implements courseservice {

//	List<course> list;
	@Autowired
	private coursesdao cdao;
	public courseserviceimpl() {
		
//		list=new ArrayList<>();
//		list.add(new course(1,"Course 1","just a course"));
//		list.add(new course(2,"Course 2","just a course"));
		// TODO Auto-generated constructor stub
	}

	public List<course> getcourses() {
		// TODO Auto-generated method stub
//		return list;
		return cdao.findAll();
	}

	@Override
	public course getcourse(int courseid) {
//		course c=null;
//		for(course cr:list)
//		{
//			if(cr.getId()==courseid)
//			{	c=cr;
//			    break;
//			}
//			
//		}
//		return c;
		course course=cdao.findById(courseid).get();
		return course;
	}

	@Override
	public course postcourse(course cr) {
		// TODO Auto-generated method stub
//		list.add(cr);
//		return cr;
		cdao.save(cr);
		return cr;
	}

	@Override
	public course updatecourse(course c) {
//		course cr=null;
//		for(course cc:list)
//		{
//			if(cc.getId()==c.getId())
//			{
//				cc.setTitle(c.getTitle());
//				cc.setDescription(c.getDescription());
//				cr=cc;
//			}
//		}
//		return cr;
		cdao.save(c);
		return c;
	}

	@Override
	public course deletecourse(int courseid) {
		// TODO Auto-generated method stub
//		course d=null;
//		for(course c:list)
//		{
//			if(c.getId()==courseid)
//			{
//				d=c;
//				list.remove(c);
//				break;
//				
//			}
//		}
//		return d;
		course entCourse=cdao.getOne(courseid);
		cdao.delete(entCourse);
		return entCourse;
	}
	public Map<String,Object> getfilt(Map<String, String>params)
	{
		List<course> foundCourses=new ArrayList<course>();
		List<course> courses=cdao.findAll();
		for(course c:courses)
		{
			boolean ismatched=true;
			for (Map.Entry<String,String> entry : params.entrySet()) {
              
				
				if(!entry.getValue().equals(c.getProperty(entry.getKey())))
					{
					System.err.println(entry.getValue()+c.getProperty(entry.getKey()));
					ismatched=false;
					break;
					}
	    }
			
			if(ismatched)
				foundCourses.add(c);
			
		}
		Map<String, Object> map=new HashMap<>();
		map.put("found courses", foundCourses);
		return map;
	}
	public String getprocedure() {
		return cdao.getitout();
	}

}
