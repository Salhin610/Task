package com.madar.task.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users_table")
 public class UserModel {

    @PrimaryKey(autoGenerate = true)
    private int Id;

    private String UserName;
    private String Age;
    private String JobTitle;
    private String Gender;

    public void setId(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

    public UserModel(String UserName, String Age, String JobTitle, String Gender) {

       this.UserName = UserName;
        this.Age = Age;
        this.JobTitle = JobTitle;
        this.Gender = Gender;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
