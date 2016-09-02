package tebogokgopa.casualty.Domain;

import android.os.Build;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Quest on 2016/08/28.
 */
public class Appointment implements Serializable {
    Long id;
    String appDate;
    String appTime;
    String docName;
    String patientName;

    public Long getId() {
        return id;
    }

    public String getAppDate() {
        return appDate;
    }

    public String getAppTime() {
        return appTime;
    }

    public String getDocName() {
        return docName;
    }

    public String getPatientName() {
        return patientName;
    }
    private Appointment(){

    }
    public Appointment(Builder builder){
        this.id = builder.id;
        this.appDate = builder.appDate;
        this.appTime = builder.appTime;
        this.docName = builder.docName;
        this.patientName = builder.patientName;
    }

    public static class Builder{
        Long id;
        String appDate;
        String appTime;
        String docName;
        String patientName;

        public Builder getId(Long value){
            this.id = value;
            return this;
        }

        public Builder getAppDate(String value){
            this.appDate = value;
            return this;
        }

        public Builder getAppTime(String value){
            this.appTime = value;
            return this;
        }

        public Builder getDocName(String value){
            this.docName = value;
            return this;
        }

        public Builder getPatientName(String value){
            this.patientName = value;
            return this;
        }

        public Builder copy(Appointment appointment){
            this.id = appointment.id;
            this.appDate = appointment.appDate;
            this.appTime = appointment.appTime;
            this.docName = appointment.docName;
            this.patientName = appointment.patientName;
            return this;
        }

        public Appointment build(){return new Appointment(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appointment that = (Appointment) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
