package tebogokgopa.casualty.Activities.RegisterActivities;

import android.app.Activity;
import android.content.Intent;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tebogokgopa.casualty.Activities.Login;
import tebogokgopa.casualty.Domain.Users;
import tebogokgopa.casualty.Factory.UsersFactory;
import tebogokgopa.casualty.R;
import tebogokgopa.casualty.Services.ServicesImpl.UserServicesImpl;
import tebogokgopa.casualty.Services.UsersService;


public class Register extends Activity implements AdapterView.OnItemSelectedListener  {

    UsersService repo = new UserServicesImpl();
    EditText username;
    EditText password;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // force connection to open
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        // Spinner element
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(this);
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
        spinner2.setAdapter(dataAdapter);
        Button submit = (Button)findViewById(R.id.RegisterSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = (EditText)findViewById(R.id.editText3);
                password = (EditText)findViewById(R.id.editText4);
                text = ((Spinner)findViewById(R.id.spinner2)).getSelectedItem().toString();
                try {
                    Users users = UsersFactory.getUsers(username.getText().toString(), password.getText().toString(), text);
                    String response = repo.save(users);
                    Toast.makeText(getApplicationContext(), "User credentials saved ", Toast.LENGTH_LONG).show();
                    Intent cancelIntent = new Intent(v.getContext(), Login.class);
                    startActivity(cancelIntent);
                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),
                            "Could not save, Make sure that data is entered correctly",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

                Button cancel = (Button)findViewById(R.id.cancelRegisterButton);
                cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancelIntent = new Intent(v.getContext(), Login.class);
                startActivity(cancelIntent);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(0,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.RegisterSubmit) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
