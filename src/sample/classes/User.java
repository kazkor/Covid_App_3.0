package sample.classes;

import sample.classes.Report;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

    private LocalDate qStartDate;
    private LocalDate qEndDate;


    private int ID;
    private String name;
    private String surname;
    private String passportN;
    private String nation;
    private String mobileN;
    private String gender;
    private String emailAdress;
    private List<Report> reportList = new ArrayList<>();


    public User(){

    }


    public User(String name, String surname, String passportN, String nation, String mobileN,
                String gender, String emailAdress, int ID, LocalDate qStartDate) {
        this.name = name;
        this.surname = surname;
        this.passportN = passportN;
        this.nation = nation;
        this.mobileN = mobileN;
        this.gender = gender;
        this.emailAdress=emailAdress;
        this.ID=ID;
        this.qStartDate=qStartDate;
        this.qEndDate=qStartDate.plusDays(14);
    }

    public LocalDate getStartDate() {
        return qStartDate;
    }


    public void setStartDate(LocalDate qStartDate) {
        this.qStartDate = qStartDate;
    }

    public LocalDate getEndDate() {
        return qEndDate;
    }

    public void setEndDate(LocalDate qEndDate) {
        this.qEndDate = qEndDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getPassportN() {
        return passportN;
    }

    public void setPassportN(String passportN) {
        this.passportN = passportN;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getMobileN() {
        return mobileN;
    }

    public void setMobileN(String mobileN) {
        this.mobileN = mobileN;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "qStartDate=" + qStartDate +
                ", qEndDate=" + qEndDate +
                ", ID=" + ID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passportN='" + passportN + '\'' +
                ", nation='" + nation + '\'' +
                ", mobileN='" + mobileN + '\'' +
                ", gender='" + gender + '\'' +
                ", emailAdress='" + emailAdress + '\'' +
                ", reportList=" + reportList +
                '}';
    }

    public void setReportList(List<Report> reportList) {
        this.reportList = reportList;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<Report> getReportList() {
        return reportList;
    }
}
