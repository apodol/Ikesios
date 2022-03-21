package com.example.vis360;

import java.time.LocalDateTime;

public class DiseaseStatement {


    public int ID ;
    public String Name;
    public boolean Coronavirus;
    public int Diagnose;
    public LocalDateTime DiagnoseDate;
    public LocalDateTime HospitalAdmission;
    public String HospitalName;
    public  User User;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean isCoronavirus() {
        return Coronavirus;
    }

    public void setCoronavirus(boolean coronavirus) {
        Coronavirus = coronavirus;
    }

    public int getDiagnose() {
        return Diagnose;
    }

    public void setDiagnose(int diagnose) {
        Diagnose = diagnose;
    }

    public LocalDateTime getDiagnoseDate() {
        return DiagnoseDate;
    }

    public void setDiagnoseDate(LocalDateTime diagnoseDate) {
        DiagnoseDate = diagnoseDate;
    }

    public LocalDateTime getHospitalAdmission() {
        return HospitalAdmission;
    }

    public void setHospitalAdmission(LocalDateTime hospitalAdmission) {
        HospitalAdmission = hospitalAdmission;
    }

    public String getHospitalName() {
        return HospitalName;
    }

    public void setHospitalName(String hospitalName) {
        HospitalName = hospitalName;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        User = user;
    }
}
