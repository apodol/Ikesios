package com.example.vis360;

public class Help {


    public int ID;
    public int HelpType;
    public boolean VolunteerPush;
    public boolean TownPush;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getHelpType() {
        return HelpType;
    }

    public void setHelpType(int helpType) {
        HelpType = helpType;
    }

    public boolean isVolunteerPush() {
        return VolunteerPush;
    }

    public void setVolunteerPush(boolean volunteerPush) {
        VolunteerPush = volunteerPush;
    }

    public boolean isTownPush() {
        return TownPush;
    }

    public void setTownPush(boolean townPush) {
        TownPush = townPush;
    }
}
