package com.gcu.models;

import io.swagger.annotations.ApiModelProperty;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Date: 12/12/22
 * Model to handle data for each course Every variable is private and getters and setters are used for each one.
 * Validation is on all variables 
 * 
 * @author Katie Munoz
 * @version 1.
 *
 */
public class CourseModel {

	private int courseId;

    
    @NotNull(message="Coursename is a required field")
    @Size(min=1, max=32, message="course name must be between 1 and 32 characters")
    @ApiModelProperty(value = "course name", example = "cst323")
    private String courseName;
    
    @NotNull(message="coursede is a required field")
    @Size(min=1, max=32, message="coursedes must be between 1 and 150 characters")
    @ApiModelProperty(value = "course description")
    private String courseDes;
    
    @NotNull(message="Projects is a required field")
    @Size(min=1, max=32, message="Projects must be between 1 and 32 characters")
    @ApiModelProperty(value = "projects from course", example = "music app")
    private String projects;
        
    @NotNull(message="course skills is a required field")
    @Size(min=1, max=32, message="course skils must be between 1 and 32 characters")
    @ApiModelProperty(value = "skills lesrned in course", example = "AJAX")
    private String courseSkills;

    @NotNull(message="course img is a required field")
    @Size(min=1, max=32, message="image must be between 1 and 150 characters")
    @ApiModelProperty(value = "picture of course", example = "course.jpg")
    private String courseImg;

    
    /**
	 * Parameterized Constructor
	 * 
	 * @param courseId Id of product in database
	 * @param courseName Name of course
	 * @param courseDes description of course
	 * @param projects course projects
	 * @param courseSkills skills lesrned in course
	 * @param courseImg image of course
	 */
    /**
	 * Default constructor
	 */
    public CourseModel(int courseId, String courseName, String courseDes, String projects, String courseSkills, String courseImg) {
    	this.courseId = courseId;
    	this.courseName = courseName;
        this.courseDes = courseDes;
        this.projects = projects;
          this.courseSkills = courseSkills;
        this.courseImg = courseImg;
    }


    
  //Getters and Setters

    public CourseModel() {
    }

        public String getCourseName() {
            return courseName;
        }

        public void setUCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getCourseDes() {
            return courseDes;
        }

        public void setCourseDes(String courseDes) {
            this.courseDes = courseDes;
        }
        
        public String getProjects() {
            return projects;
        }

        public void setProjects(String projects) {
            this.projects = projects;
        }
        
        public String getCourseSkills() {
            return courseSkills;
        }

        public void setCourseSkills(String courseSkills) {
            this.courseSkills = courseSkills;
        }

        public String getCourseImg() {
            return courseImg;
        }

        public void setCourseImg(String courseImg) {
            this.courseImg = courseImg;
        }
        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }



		
    }



