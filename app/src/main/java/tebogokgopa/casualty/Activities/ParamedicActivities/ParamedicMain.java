package tebogokgopa.casualty.Activities.ParamedicActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import tebogokgopa.casualty.R;

public class ParamedicMain extends AppCompatActivity {

    ImageView paraImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paramedic_main);

        paraImage = (ImageView)findViewById(R.id.imageView3);
        paraImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Available in version 1.0.2 ", Toast.LENGTH_LONG).show();
            }
        });
    }
}
