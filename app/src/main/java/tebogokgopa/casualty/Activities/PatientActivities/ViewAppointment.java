package tebogokgopa.casualty.Activities.PatientActivities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Set;

import tebogokgopa.casualty.Domain.Appointment;
import tebogokgopa.casualty.R;
import tebogokgopa.casualty.Services.AppointmentService;
import tebogokgopa.casualty.Services.ServicesImpl.AppointmentServicesImpl;

public class ViewAppointment extends AppCompatActivity {

    TableLayout tl;
    TableRow tr;
    TextView valueTV;
    AppointmentService service = new AppointmentServicesImpl();
    List<Appointment> appointments;

    Button viewButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_appointment);

        tl = (TableLayout)findViewById(R.id.maintable);
        appointments  = service.findAll();
        addHeaders();
        addData();

        viewButton = (Button)findViewById(R.id.viewApps);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(getApplicationContext(),PatientMain.class);
                startActivity(backIntent);
            }
        });
    }

    /** This function add the headers to the table **/
    public void addHeaders(){

        /** Create a TableRow dynamically **/
        tr = new TableRow(this);
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));


        /** Creating another textview **/
        TextView valueTV = new TextView(this);
        valueTV.setText("ID");
        valueTV.setTextColor(Color.GRAY);
        valueTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        valueTV.setPadding(3, 3, 3, 0);
        valueTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(valueTV); // Adding textView to tablerow.

        /** Creating another textview **/
        TextView descr = new TextView(this);
        descr.setText("Date");
        descr.setTextColor(Color.GRAY);
        descr.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        descr.setPadding(3, 3, 3, 0);
        descr.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(descr); // Adding textView to tablerow.

        /** Creating another textview **/
        TextView itemType = new TextView(this);
        itemType.setText("Time");
        itemType.setTextColor(Color.GRAY);
        itemType.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        itemType.setPadding(5, 5, 5, 0);
        itemType.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(itemType); // Adding textView to tablerow.

        /** Creating another textview **/
        TextView date = new TextView(this);
        date.setText("Doctor");
        date.setTextColor(Color.GRAY);
        date.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        date.setPadding(5, 5, 5, 0);
        date.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(date); // Adding textView to tablerow.

        // Add the TableRow to the TableLayout
        tl.addView(tr, new LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));

        // we are adding two textviews for the divider because we have two columns
        tr = new TableRow(this);
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));


        TextView divider2 = new TextView(this);
        divider2.setText("---------");
        divider2.setTextColor(Color.BLUE);
        divider2.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        divider2.setPadding(5, 0, 0, 0);
        divider2.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider2); // Adding textView to tablerow.

        TextView divider3 = new TextView(this);
        divider3.setText("---------");
        divider3.setTextColor(Color.BLUE);
        divider3.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        divider3.setPadding(5, 0, 0, 0);
        divider3.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider3); // Adding textView to tablerow.


        TextView divider4 = new TextView(this);
        divider4.setText("---------");
        divider4.setTextColor(Color.BLUE);
        divider4.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        divider4.setPadding(5, 0, 0, 0);
        divider4.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider4); // Adding textView to tablerow.

        TextView divider5 = new TextView(this);
        divider5.setText("----------------------------");
        divider5.setTextColor(Color.BLUE);
        divider5.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        divider5.setPadding(5, 0, 0, 0);
        divider5.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider5); // Adding textView to tablerow.

        TextView divider6 = new TextView(this);
        divider6.setText("---------");
        divider6.setTextColor(Color.BLUE);
        divider6.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        divider6.setPadding(5, 0, 0, 0);
        divider6.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider6); // Adding textView to tablerow.

        // Add the TableRow to the TableLayout
        tl.addView(tr, new LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));

    }

    public void addData() {

        /**-------------------------------**/
        /** Get a list of package products **/

        for (int i = 0; i < appointments.size(); i++) {
            /** Create a TableRow dynamically **/
            tr = new TableRow(this);
            tr.setLayoutParams(new LayoutParams(
                    LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));

            /** Creating another textview **/
            valueTV = new TextView(this);
            valueTV.setText(appointments.get(i).getId().toString());
            valueTV.setTextColor(Color.GRAY);
            valueTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            valueTV.setPadding(5, 5, 5, 5);
            valueTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(valueTV); // Adding textView to tablerow.

            /** Creating another textview **/
            valueTV = new TextView(this);
            valueTV.setText(appointments.get(i).getAppDate().toString());
            valueTV.setTextColor(Color.GRAY);
            valueTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            valueTV.setPadding(5, 5, 5, 5);
            valueTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(valueTV); // Adding textView to tablerow.

            /** Creating another textview **/
            valueTV = new TextView(this);
            valueTV.setText(appointments.get(i).getAppTime().toString());
            valueTV.setTextColor(Color.GRAY);
            valueTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            valueTV.setPadding(5, 5, 5, 5);
            valueTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(valueTV); // Adding textView to tablerow.

            /** Creating another textview **/
            valueTV = new TextView(this);
            valueTV.setText(appointments.get(i).getDocName().toString());
            valueTV.setTextColor(Color.GRAY);
            valueTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            valueTV.setPadding(5, 5, 5, 5);
            valueTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(valueTV); // Adding textView to tablerow.

            // Add the TableRow to the TableLayout
            tl.addView(tr, new LayoutParams(
                    LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        // put your code here...
        tl.removeAllViews();
        appointments.clear();
        appointments = service.findAll();
        addHeaders();
        addData();

    }
}
