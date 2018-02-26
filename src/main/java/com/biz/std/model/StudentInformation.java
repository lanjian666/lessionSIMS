package com.biz.std.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StudentInformation {
    private  int number;
    private int studentID;
    private  String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private  String gender;
    private Date birthday;
    private Double avg;
    private  String  headPortrait;
    private String grade;
    private  int subjectNumber;

    public StudentInformation(int studentID, String name, String gender, Date birthday, Double avg, String headPortrait, String grade, int subjectNumber) {
        this.studentID = studentID;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.avg = avg;
        this.headPortrait = headPortrait;
        this.grade = grade;
        this.subjectNumber = subjectNumber;
    }

    public StudentInformation(int studentID, String name, String gender, Date birthday, Double avg, String headPortrait) {
        this.studentID = studentID;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.avg = avg;
        this.headPortrait = headPortrait;
    }

    public int getSubjectNumber() {
        return subjectNumber;
    }

    public void setSubjectNumber(int subjectNumber) {
        this.subjectNumber = subjectNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public StudentInformation() {

    }

    public StudentInformation(int studentID, String name, String gender, Date birthday, Double avg, String headPortrait, String grade) {
        this.studentID = studentID;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.avg = avg;
        this.headPortrait = headPortrait;
        this.grade = grade;
    }

    @GeneratedValue
    @Id
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public String getHeadPortrait() {
        return headPortrait;
    }
    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }
}
