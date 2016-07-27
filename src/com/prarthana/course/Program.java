/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.course;

import com.prarthana.course.dao.CourseDAO;
import com.prarthana.course.dao.impl.CouseDaoImpl;
import com.prarthana.course.obj.Course;
import java.util.Scanner;

/**
 *
 * @author Pavilion G4
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
 CourseDAO CDAO = new CouseDaoImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("COURSE RECORD");
            System.out.println("........................................");
            System.out.println("1. Add Course");
            System.out.println("2. Delete Course By Code");
            System.out.println("3. Show all Course");
            System.out.println("4. Search Course By Code");
            System.out.println("5. Exit");
            System.out.println("Enter your choice[1-5]:");

            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Add Course");
                    Course s = new Course();
                    System.out.println("Enter Course Code: ");
                    s.setCode(sc.nextInt());
                    System.out.println("Enter Course Name: ");
                    s.setName(sc.next());
                    
                    System.out.println("Enter Institution: ");
                    s.setInstitution(sc.next());
                    
                    System.out.println("Enter Teacher's name: ");
                    s.setTeach(sc.next());
                    System.out.println("Enter Price: ");
                    s.setPrice(sc.nextInt());
                    System.out.println("Enter Course Timing: ");
                    s.setTime(sc.next());
                    
                    System.out.println("Enter Status: ");
                    s.setStatus(sc.nextBoolean());

                    if (CDAO.insert(s)) {
                        System.out.println("Inserted Successfully!!");
                    } else {
                        System.out.println("Can't add more Course. Data Full!!");
                    }

                    break;
                case 2:
                    System.out.println("Enter the Course Code you want to delete: ");
                    int idd = sc.nextInt();
                    if (CDAO.delete(idd)) {
                        System.out.println("The Course with Code : " + idd + " is deleted successfully.");
                    } else {
                        System.out.println("Code not found.");
                    }

                    break;
                case 3:
                    System.out.println("Courses Available");
                    System.out.println(".................................");
                    Course[] courses = CDAO.getAll();
                    for (int i = 0; i < courses.length; i++) {
                        Course course = courses[i];
                        if (course != null) {
                            System.out.println("Course Code = " + course.getCode());
                            System.out.println("Course Name = " + course.getName());
                            
                            System.out.println("Course available at = @ " + course.getInstitution());
                            System.out.println("Course-Taught By = Prof. " + course.getTeach());
                            System.out.println("Course Price = Rs. " + course.getPrice());
                            System.out.println("Course Timing = " + course.getTime());
                            System.out.println("Status = " + course.isStatus());
                            System.out.println(".....................................................");

                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter the Course Code you want to search: ");
                    int id = sc.nextInt();
                    Course st = CDAO.getById(id);

                    System.out.println("COURSE CODE = " + st.getCode());
                    System.out.println("COURSE NAME = " + st.getName());
                    System.out.println("COURSE AVAIALBLE AT = @ " + st.getInstitution());
                    System.out.println("COURSE TAUGHT BY = Prof. " + st.getTeach());
                     System.out.println("COURSE PRICE = " + st.getPrice());
                    System.out.println("COURSE TIMING = " + st.getTime());
                    System.out.println("COURSE STATUS = " + st.isStatus());

                    break;
                case 5:
                    System.out.println("Do you really want to exit [Y/N]");
                    if (sc.next().equalsIgnoreCase("y")) {
                        System.out.println("Thankyou, Visit Again.");
                        System.exit(0);
                    }
                    System.exit(0);
                    break;

            }

        }
    }

}

