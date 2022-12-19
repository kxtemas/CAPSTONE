package com.gcu.data;


import com.gcu.models.CourseModel;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 12/12/22
 * DAO for the course Database.
 * Will be used to communicate between the course Business service
 * 
 * @author Katie Munoz
 * @version 1
 */
@Service
public class CourseDataService {


    

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**
	 * Returns a list of all the courses in a database.
	 * .
	 * 
	 * @return List<CoursetModel> List of courses
	 */
    public List<CourseModel> findAllCourses(){
        String sql = "SELECT * FROM CAPSTONE.COURSE";
        List<CourseModel> courses = new ArrayList<>();
        try {
            SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
            while (srs.next()){
                courses.add(new CourseModel(srs.getInt("ID"),  srs.getString("COURSE_NAME"), srs.getString("COURSE_DES"), srs.getString("PROJECTS"), srs.getString("COURSE_SKILLS"),  srs.getString("COURSE_IMG")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return courses;
    }

    /**
   	 * Returns a list of all the courses in a database based of course id.
   	 * .
   	 * 
   	 * @return <CoursetModel> where the course id=
   	 */
    public CourseModel findCourseById(int id){
        String sql = "SELECT * FROM CAPSTONE.COURSE WHERE ID = ?";
        CourseModel course = new CourseModel();
        try {
            SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, id);
            while (srs.next())
            {
                course.setCourseId(id);
            course.setUCourseName(srs.getString("COURSE_NAME"));
                course.setCourseDes(srs.getString("COURSE_DES"));            
           course.setProjects(srs.getString("PROJECTS"));        
               course.setCourseSkills(srs.getString("COOURSE_SKILLS"));
                course.setCourseImg(srs.getString("COURSE_IMG"));
           
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return course;
    }
	/**
	 * Create a course for the database. Returns an boolean so a
	 * proper error message can be displayed.
	 * 
	 * @param courseModel Used to add course to database 
	 * 
	 * @return boolean Used to determine what to do
	 */
    public boolean createCourse(CourseModel course) {
		 String sql = "INSERT INTO CAPSTONE.COURSE(COURSE_NAME, COURSE_DES, PROJECTS, COURSE_SKILLS, COURSE_IMG) VALUES (?,?,?,?,?,?)";
	        try {
	            jdbcTemplate.update(sql, course.getCourseName(), course.getCourseDes(), course.getProjects(), course.getCourseSkills(),
	                    course.getCourseImg());
	        }catch (Exception e){
	            e.printStackTrace();
	            return false;
	        }
	        return true;
	    }

  
    /**
	 * Change a course from the database. Returns an boolean so a
	 * proper error message can be displayed.
	 * 
	 * @param courseModel Used to change courset from database 
	 * 
	 * @return boolean Used to determine what to do
	 */
    public boolean updateCourse(CourseModel course, int courseId) {
        String sql = "UPDATE CAPSTONE.COURSE SET COURSE_NAME = ?, COURSE_DES = ?, PROJECTS = ?, COURSE_SKILLS = ?, COURSE_IMG = ?   WHERE ID = ?";
        try {
            jdbcTemplate.update(sql, course.getCourseName(), course.getCourseDes(), course.getProjects(), course.getCourseSkills(),
                    course.getCourseImg(), courseId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
	 * Delete the course from the database.
	 * 
	 * @param courseModel Used to find out which course to delete from database
	 * 
	 * @return boolean Used to determine what happened
	 */
    public boolean deleteCourse(int courseId){
        String sql = "DELETE FROM CAPSTONE.COURSE WHERE ID = ?";
        try {
            jdbcTemplate.update(sql, courseId);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

	

	

}
