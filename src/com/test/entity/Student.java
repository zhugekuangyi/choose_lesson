package com.test.entity;

/**
 * @author chuqi
 * @description: 学生
 * @create 2021-06-25 上午11:24
 */
public class Student {

    private int    id;
    private String username;
    private String password;
    // 学号，，，，出生年月，地址，电话，E-mail
    private String studentCode;
    //姓名
    private String name;
    //年龄
    private int    age;
    //性别
    private String sex;
    //联系方式
    private String phone;
    //系别
    private String department;
    // 所属班级
    private String studentClass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public Student(String username, String password) {
        this.password = password;
        this.username = username;
    }
}
