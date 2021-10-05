package com.example.avtar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    EditText txtName;
    TextView displayid;
    TextView displayname;
    TextView dateandtime;
    Button btnDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.name);
        UUID uuid = UUID.randomUUID();

        displayid = findViewById(R.id.randomid);
        displayname = findViewById(R.id.dispname);
        btnDisplay = findViewById(R.id.btnDisplay);
        dateandtime = findViewById(R.id.datetime);
        final TextView randomid = (TextView)findViewById(R.id.randomid);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtName.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Empty field", Toast.LENGTH_SHORT).show();
                }else{
                    randomid.setText(String.valueOf(uuid));
                    String name = txtName.getText().toString();
                    displayname.setText(name);
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE , dd-MM-yyyy hh:mm:ss a");
                    String dateTime = simpleDateFormat.format(calendar.getTime());
                    dateandtime.setText(dateTime);
                }
            }
        });
    }
}