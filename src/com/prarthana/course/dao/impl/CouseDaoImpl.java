/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.course.dao.impl;

import com.prarthana.course.dao.CourseDAO;
import com.prarthana.course.obj.Course;

/**
 *
 * @author Pavilion G4
 */
public class CouseDaoImpl implements CourseDAO{
     private int counter=0;
    private Course[] courseList=new Course[5];

    @Override
    public boolean insert(Course s) {
        if(counter==courseList.length){
            return false;
        }
      courseList[counter]=s;
      counter++;
        return true;
        
    }

    @Override
    public boolean delete(int id) {
          for(int i=0;i<courseList.length;i++){
        Course s=courseList[i]; 
        if(s!=null && s.getCode()==id){
            courseList[i]=null;
            return true;
        }
        
        }
        return false;
        
    }

    @Override
    public Course getById(int id) {
        for(int i=0;i<courseList.length;i++){
        Course s=courseList[i]; 
        if(s!=null && s.getCode()==id){
            
            return s;
        }
        
        }
        return null;
    }

    @Override
    public Course[] getAll() {
        return courseList;
        
    }
    
}
