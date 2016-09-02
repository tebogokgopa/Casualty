package tebogokgopa.casualty.Activities.DoctorActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import tebogokgopa.casualty.R;

public class DoctorMain extends AppCompatActivity {

    ImageView docImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_main);

        docImage=(ImageView)findViewById(R.id.imageView4);
        docImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Available in version 1.0.2 ", Toast.LENGTH_LONG).show();
            }
        });
    }
}
