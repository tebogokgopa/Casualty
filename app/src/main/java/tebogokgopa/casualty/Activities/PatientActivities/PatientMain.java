package tebogokgopa.casualty.Activities.PatientActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import tebogokgopa.casualty.R;

public class PatientMain extends AppCompatActivity {

    Button appointment,emergency;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_main);

        //User to make appointment
        appointment = (Button)findViewById(R.id.appointmentButton);
        appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent appIntent = new Intent(v.getContext(),AppointmentActivity.class);
                startActivityForResult(appIntent,0);
            }
        });

        //send location and call emergency services
        emergency= (Button)findViewById(R.id.emergencyButton);
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Available in version 1.0.2 will send emergency IM ", Toast.LENGTH_LONG).show();
            }
        });
    }
}
