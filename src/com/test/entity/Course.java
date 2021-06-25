package com.test.entity;

public class Course {
    private int id;
    //课程名称
    private String courseName;
    //学年
    private String academicYear;
    //学期
    private String term;
    //授课老师
    private String teacherName;
    //课程性质
    private String courseQuality;
    //学时
    private int hours;
    //学分
    private int score;
    //选修人数
    private int count;

    private String commitStatus;

    public String getCourseQuality() {
        return courseQuality;
    }

    public void setCourseQuality(String courseQuality) {
        this.courseQuality = courseQuality;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCommitStatus() {
        return commitStatus;
    }

    public void setCommitStatus(String commitStatus) {
        this.commitStatus = commitStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }




    public Course() {
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
