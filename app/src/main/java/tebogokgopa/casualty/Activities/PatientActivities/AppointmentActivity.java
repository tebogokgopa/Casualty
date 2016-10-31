package tebogokgopa.casualty.Activities.PatientActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import tebogokgopa.casualty.Domain.Appointment;
import tebogokgopa.casualty.Factory.AppointmentFactory;
import tebogokgopa.casualty.R;
import tebogokgopa.casualty.Services.AppointmentService;
import tebogokgopa.casualty.Services.ServicesImpl.AppointmentServicesImpl;

public class AppointmentActivity extends AppCompatActivity {

    AppointmentService repo = new AppointmentServicesImpl();
    Button submit,cancel,view;
    EditText appdate,apptime,docname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);


        submit= (Button)findViewById(R.id.submitAppButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appdate = (EditText)findViewById(R.id.appDate);
                apptime = (EditText)findViewById(R.id.appTime);
                docname = (EditText)findViewById(R.id.nameDoctor);
                //patientName= (EditText)findViewById(R.id.NameApointment);

                try {
                    Appointment users = AppointmentFactory.getAppointment(appdate.getText().toString(),apptime.getText().toString(),docname.getText().toString());
                    repo.save(users);
                    Toast.makeText(getApplicationContext(), "Appointment saved ", Toast.LENGTH_LONG).show();
                    Intent cancelIntent = new Intent(v.getContext(), PatientMain.class);
                    startActivity(cancelIntent);
                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),
                            "Could not save, Make sure that data is entered correctly",
                            Toast.LENGTH_LONG).show();
                }

            }
        });
        //Go back to main landing page for patient
        cancel=(Button)findViewById(R.id.ExitAppButton);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancelIntent = new Intent(v.getContext(),DeleteAppointment.class);
                startActivity(cancelIntent);
            }
        });

        //View appointment for patient
        view = (Button)findViewById(R.id.viewAppointmentButton);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent = new Intent(v.getContext(),ViewAppointment.class);
                startActivity(viewIntent);
            }
        });
    }


}
