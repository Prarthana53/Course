/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.course.dao;

import com.prarthana.course.obj.Course;

/**
 *
 * @author Pavilion G4
 */
public interface CourseDAO {
    boolean insert(Course s);
  
    boolean delete(int id);
    Course getById(int id);
    Course[] getAll();
}
