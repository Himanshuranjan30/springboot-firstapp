package com.first.firstapp.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.first.firstapp.entities.course;
import com.first.firstapp.services.courseservice;

@RestController
public class mycontroller {
    @Autowired
	private courseservice cs;
	
	@GetMapping("/home")
	public String gethome()
	{
		return "this is homepage";
	}
	
   @GetMapping("/courses")
     public List<course> getcourses()
     {
    	 return this.cs.getcourses();
     }
     
	@GetMapping("/courses/{courseid}")
     public Map<String,Object> getcourse(@PathVariable String courseid)
     {
    	 course c= this.cs.getcourse(Integer.parseInt(courseid));
    	 ObjectMapper mapper=new ObjectMapper();
    	 Map<String, Object> respMap=mapper.convertValue(c,Map.class);
//    	
    	 return respMap;
    	 
     }
     @PostMapping(path="/courses",consumes="application/json")//optional
     public course addcourse(@RequestBody course c)
     {
    	 return this.cs.postcourse(c);
     }
     @PutMapping(path="/courses", consumes="application/json")
     public course updatecourse(@RequestBody course c)
     {
    	 return this.cs.updatecourse(c);
     }
     @DeleteMapping("/courses/{courseid}")
     public course deletecourse(@PathVariable String courseid)
     {
    	 return this.cs.deletecourse(Integer.parseInt(courseid));
     }
     @GetMapping("/query")
 	public Map<String,Object> getfilter(@RequestParam Map<String,String> params)
 	{
 		
 		Map<String, Object> map=new HashMap<>();
 		map=this.cs.getfilt(params);
 		return map;
 	}
     @GetMapping("/procedure")
     public String getvaluefromProcedure() {
    	 return this.cs.getprocedure();
     }
}
