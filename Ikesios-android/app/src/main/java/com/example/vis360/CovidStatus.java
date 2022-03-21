package com.example.vis360;

public class CovidStatus {


    public int ID ;
    public int CovidMember;
    public int HeartDisease;
    public int BreathingDisease;
    public boolean BloodPressure;
    public boolean Diabetes;
    public boolean Smoker;
    public boolean Overweight;
    public User User;

    public int getID() {
        return ID;
    }

    public int getCovidMember() {
        return CovidMember;
    }

    public int getHeartDisease() {
        return HeartDisease;
    }

    public int getBreathingDisease() {
        return BreathingDisease;
    }

    public boolean getBloodPressure() {
        return BloodPressure;
    }

    public boolean getDiabetes() {
        return Diabetes;
    }

    public boolean getSmoker() {
        return Smoker;
    }

    public boolean getOverweight() {
        return Overweight;
    }

    public User getUser() {
        return User;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCovidMember(int covidMember) {
        CovidMember = covidMember;
    }

    public void setHeartDisease(int heartDisease) {
        HeartDisease = heartDisease;
    }

    public void setBreathingDisease(int breathingDisease) {
        BreathingDisease = breathingDisease;
    }

    public void setBloodPressure(boolean bloodPressure) {
        BloodPressure = bloodPressure;
    }

    public void setDiabetes(boolean diabetes) {
        Diabetes = diabetes;
    }

    public void setSmoker(boolean smoker) {
        Smoker = smoker;
    }

    public void setOverweight(boolean overweight) {
        Overweight = overweight;
    }

    public void setUser(User user) {
        User = user;
    }
}
