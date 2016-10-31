package tebogokgopa.casualty.Activities.PatientActivities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tebogokgopa.casualty.Domain.Appointment;
import tebogokgopa.casualty.Factory.AppointmentFactory;
import tebogokgopa.casualty.R;
import tebogokgopa.casualty.Services.AppointmentService;
import tebogokgopa.casualty.Services.ServicesImpl.AppointmentServicesImpl;


public class DeleteAppointment extends AppCompatActivity {

    AppointmentService service = new AppointmentServicesImpl();
    Appointment appointment;

    EditText delId;
    Long id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_appointment);

        // force connection to open
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        delId = (EditText)findViewById(R.id.editText5);
        delId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                appointment = null;
                try {
                    EditText id = ((EditText) findViewById(R.id.editText5));

                    if (!(id.getText().toString().isEmpty())) {
                        appointment = service.findById(Long.parseLong(id.getText().toString()));
                        if (appointment != null) {
                            EditText code = (EditText) findViewById(R.id.editText5);
                            code.setText(appointment.getId().toString());
                        }
                    }

                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "Appointment does not exist\n"
                            , Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Button deleteButton = (Button)findViewById(R.id.deleteAppButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(DeleteAppointment.this);

                // Setting Dialog Title
                alertDialog.setTitle("Confirm Delete...");

                // Setting Dialog Message
                alertDialog.setMessage("Are you sure you want delete Appointment?");
                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        EditText id = ((EditText) findViewById(R.id.editText5));
                        if (!(id.getText().toString().isEmpty()))
                        {

                            try {

                                Appointment appointmentDel = new Appointment.Builder()
                                        .getId(appointment.getId())
                                        .getAppDate(appointment.getAppDate())
                                        .getAppTime(appointment.getAppTime())
                                        .getDocName(appointment.getDocName())
                                        .build();

                                String response = service.delete(appointmentDel);

                                Toast.makeText(getApplicationContext(),
                                        "Appointment Deleted" + "\n" + appointment.getId(),
                                        Toast.LENGTH_LONG).show();
                                Intent cancelIntent = new Intent(getApplicationContext(), PatientMain.class);
                                startActivity(cancelIntent);
                                appointment = null;

                            } catch (Exception e) {
                                Toast.makeText(getApplicationContext(), "Could Not Delete", Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        }
                    }
                });

                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        Toast.makeText(getApplicationContext(), "Canceled Transaction", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                // Showing Alert Message
                alertDialog.show();
            }

        });
    }
}
