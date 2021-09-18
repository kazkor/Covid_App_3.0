package sample.classes;

import java.io.Serializable;

public class Report implements Serializable {

    private String date;
    private float temperature;
    private boolean fever;
    private boolean cough;
    private boolean dyspnea;
    private boolean soreThroat;
    private String commentary;

    public Report() {

    }


    public Report(String date, float temperature, boolean fever, boolean cough, boolean dyspnea, boolean soreThroat, String commentary) {
        this.date = date;
        this.temperature = temperature;
        this.fever = fever;
        this.cough = cough;
        this.dyspnea = dyspnea;
        this.soreThroat = soreThroat;
        this.commentary = commentary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isCough() {
        return cough;
    }

    public void setCough(boolean cough) {
        this.cough = cough;
    }

    public boolean isFever() {
        return fever;
    }

    public void setFever(boolean fever) {
        this.fever = fever;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public boolean isDyspnea() {
        return dyspnea;
    }

    public void setDyspnea(boolean dyspnea) {
        this.dyspnea = dyspnea;
    }

    public boolean isSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }



    @Override
    public String toString() {
        return "Report{" +
                "date='" + date + '\'' +
                ", temperature=" + temperature +
                ", fever=" + fever +
                ", cough=" + cough +
                ", dyspnea=" + dyspnea +
                ", soreThroat=" + soreThroat +
                ", commentary='" + commentary + '\'' +
                '}';
    }



}
