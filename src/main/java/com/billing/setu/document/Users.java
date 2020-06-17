package com.billing.setu.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Users {
    @Id
    private int id;
    private String name;
    private String teamName;
    private long Salary;

    public Users(int id, String name, String teamName, long Salary) {
        this.id = id;
        this.name = name;
        this.teamName = teamName;
        this.Salary = Salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public long getSalary() {
        return Salary;
    }

    public void setSalary(long Salary) {
        this.Salary = Salary;
    }
}
