package com.example.vis360;

import java.util.List;

public class Demographic {


    public int ID;
    public String City;
    public int Education;
    public int Gender;
    public int Age;
    public int FamilyStatus;
    public int Work;
    public int Roommates;
    public List<Integer> RoommateRelations;
    public int FinancialStatus;
    public List<Integer> Industries;
    public User User ;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getEducation() {
        return Education;
    }

    public void setEducation(int education) {
        Education = education;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int gender) {
        Gender = gender;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getFamilyStatus() {
        return FamilyStatus;
    }

    public void setFamilyStatus(int familyStatus) {
        FamilyStatus = familyStatus;
    }

    public int getWork() {
        return Work;
    }

    public void setWork(int work) {
        Work = work;
    }

    public int getRoommates() {
        return Roommates;
    }

    public void setRoommates(int roommates) {
        Roommates = roommates;
    }

    public List<Integer> getRoommateRelations() {
        return RoommateRelations;
    }

    public void setRoommateRelations(List<Integer> roommateRelations) {
        RoommateRelations = roommateRelations;
    }

    public int getFinancialStatus() {
        return FinancialStatus;
    }

    public void setFinancialStatus(int financialStatus) {
        FinancialStatus = financialStatus;
    }

    public List<Integer> getIndustries() {
        return Industries;
    }

    public void setIndustries(List<Integer> industries) {
        Industries = industries;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        User = user;
    }
}
