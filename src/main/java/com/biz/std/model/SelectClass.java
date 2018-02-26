package com.biz.std.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SelectClass {
    private  String subject;
    private  int stuNumber;

    public SelectClass(int stuNumber,String subject) {
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
    @Id
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
