package com.biz.std.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Subject {
    private int number;
    private  String subjectName;
    private  int studyPeople;
    private Double subjectAvg;

    public Subject(String subjectName, int studyPeople, Double subjectAvg) {
        this.subjectName = subjectName;
        this.studyPeople = studyPeople;
        this.subjectAvg = subjectAvg;
    }

    public Subject() {
    }
    @GeneratedValue
    @Id
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getStudyPeople() {
        return studyPeople;
    }

    public void setStudyPeople(int studyPeople) {
        this.studyPeople = studyPeople;
    }

    public Double getSubjectAvg() {
        return subjectAvg;
    }

    public void setSubjectAvg(Double subjectAvg) {
        this.subjectAvg = subjectAvg;
    }
}
