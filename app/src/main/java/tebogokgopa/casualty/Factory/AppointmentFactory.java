package tebogokgopa.casualty.Factory;

import java.util.Date;

import tebogokgopa.casualty.Domain.Appointment;

/**
 * Created by Quest on 2016/08/28.
 */
public class AppointmentFactory {

    public static Appointment getAppointment(String date,String time,String doctor){
        Appointment appointment = new Appointment.Builder()
                .getAppDate(date)
                .getAppTime(time)
                .getDocName(doctor)
                .build();
       return appointment;
    }
}
