package com.biz.std.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Grade {
   private  int number;
   private  String gradeName;
   private  int peopleNum;
   private  Double gradeAvg;

    public Grade(String gradeName, int peopleNum, Double gradeAvg) {
        this.gradeName = gradeName;
        this.peopleNum = peopleNum;
        this.gradeAvg = gradeAvg;
    }

    public Grade() {
    }
    @GeneratedValue
    @Id
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    @Column(unique = true)
    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    public Double getGradeAvg() {
        return gradeAvg;
    }

    public void setGradeAvg(Double gradeAvg) {
        this.gradeAvg = gradeAvg;
    }
}
