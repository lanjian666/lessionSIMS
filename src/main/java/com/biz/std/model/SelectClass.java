package com.biz.std.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SelectClass {
    private  String subject;
    private  int stuNumber;
    private  String subjectAndNumber;

    public SelectClass(String subject, int stuNumber, String subjectAndNumber) {
        this.subject = subject;
        this.stuNumber = stuNumber;
        this.subjectAndNumber = subjectAndNumber;
    }
    @Id
    public String getSubjectAndNumber() {
        return subjectAndNumber;
    }

    public void setSubjectAndNumber(String subjectAndNumber) {
        this.subjectAndNumber = subjectAndNumber;
    }

    public SelectClass(int stuNumber, String subject) {
        this.subject = subject;
        this.stuNumber = stuNumber;
    }

    public int getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(int stuNumber) {
        this.stuNumber = stuNumber;
    }

    public SelectClass() {
    }
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
