package tebogokgopa.casualty.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tebogokgopa.casualty.Activities.PatientActivities.PatientMain;
import tebogokgopa.casualty.Activities.RegisterActivities.Register;
import tebogokgopa.casualty.R;

public class Login extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button register;
    Button login ;
    EditText pass,user;
    String text;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "My Preferences" ;
    public static final String UserName = "userNameKey";
    public static final String Password = "passwordKey";
    public static final String UserId = "userIdKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Patient");
        categories.add("Paramedic");
        categories.add("Doctor");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        register = (Button)findViewById(R.id.RegisterButton);
        login =(Button)findViewById(R.id.LoginButton);
        pass=(EditText)findViewById(R.id.editText);
        user=(EditText)findViewById(R.id.editText2);
        text = ((Spinner)findViewById(R.id.spinner)).getSelectedItem().toString();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(v.getContext(),Register.class);
                startActivity(registerIntent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n  = pass.getText().toString();
                String ph  = user.getText().toString();
                String use = text;
                sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(UserName, n);
                editor.putString(Password, ph);
                editor.putString(UserId,use);
                editor.apply();
                editor.commit();
                Intent mainIntent = new Intent(v.getContext(), PatientMain.class);
                startActivity(mainIntent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
