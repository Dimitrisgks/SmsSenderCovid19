package com.sin.covidsms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.covidsms.R;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    private EditText nameInput;
    private EditText homeInput;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }});

//save user data
        prefs = getSharedPreferences("my_data", MODE_PRIVATE);
        nameInput = (EditText) findViewById(R.id.texto);
        homeInput = (EditText) findViewById(R.id.textd);

        //permanent hint
        TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.hintguy);
        String savedName = prefs.getString("MY_NAME", "");
        String name = prefs.getString("MY_NAME", "");
        if (savedName.length() > 0) {
            textInputLayout.setHint(name);
        } else {
            textInputLayout.setHint("Ονοματεπώνυμο");
        }
        //2nd permanent hint
        TextInputLayout textInputLayout2 = (TextInputLayout) findViewById(R.id.hintguy2);
        String home = prefs.getString("MY_HOME", "");
        if (savedName.length() > 0) {
            textInputLayout2.setHint(home);
        } else {
            textInputLayout2.setHint("Διεύθυνση Κατοικίας");
        }
//1st button
        Button mbutton0 = (Button) findViewById(R.id.Btn0);
        mbutton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs = getSharedPreferences("my_data", MODE_PRIVATE);
                String name = prefs.getString("MY_NAME", "name");
                String home = prefs.getString("MY_HOME", "home");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "13033", null));
                intent.putExtra("sms_body", 1 + " " + name + " " + home);
                startActivity(intent);
            }
        });
//2nd button
        Button mbutton1 = (Button) findViewById(R.id.Btn1);
        mbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs = getSharedPreferences("my_data", MODE_PRIVATE);
                String name = prefs.getString("MY_NAME", "name");
                String home = prefs.getString("MY_HOME", "home");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "13033", null));
                intent.putExtra("sms_body", 2 + " " + name + " " + home);
                startActivity(intent);
            }
        });
//3rd button
        Button mbutton2 = (Button) findViewById(R.id.Btn2);
        mbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs = getSharedPreferences("my_data", MODE_PRIVATE);
                String name = prefs.getString("MY_NAME", "name");
                String home = prefs.getString("MY_HOME", "home");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "13033", null));
                intent.putExtra("sms_body", 3 + " " + name + " " + home);
                startActivity(intent);
            }
        });
//4th button
        Button mbutton3 = (Button) findViewById(R.id.Btn3);
        mbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs = getSharedPreferences("my_data", MODE_PRIVATE);
                String name = prefs.getString("MY_NAME", "name");
                String home = prefs.getString("MY_HOME", "home");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "13033", null));
                intent.putExtra("sms_body", 4 + " " + name + " " + home);
                startActivity(intent);
            }

        });
        //5th button
        Button mbutton4 = (Button) findViewById(R.id.Btn4);
        mbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs = getSharedPreferences("my_data", MODE_PRIVATE);
                String name = prefs.getString("MY_NAME", "name");
                String home = prefs.getString("MY_HOME", "home");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "13033", null));
                intent.putExtra("sms_body", 5 + " " + name + " " + home);
                startActivity(intent);
            }

        });

        //6th button
        Button mbutton5 = (Button) findViewById(R.id.Btn5);
        mbutton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs = getSharedPreferences("my_data", MODE_PRIVATE);
                String name = prefs.getString("MY_NAME", "name");
                String home = prefs.getString("MY_HOME", "home");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "13033", null));
                intent.putExtra("sms_body", 6 + " " + name + " " + home);
                startActivity(intent);
            }
        });
    }

    public void confirmInput(View view) {
        String name = nameInput.getText().toString();
        SharedPreferences.Editor editor = getSharedPreferences("my_data", MODE_PRIVATE).edit();
        editor.putString("MY_NAME", name);
        editor.apply();
//hint when button pressed change
        TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.hintguy);
        String names = prefs.getString("MY_NAME", "");
        textInputLayout.setHint(names);
        Toast toast = Toast.makeText(this, "Το Ονοματεπώνυμο αποθηκεύτηκε επιτυχώς", Toast.LENGTH_SHORT);
        toast.show();
    }


    public void confirmInput2(View view) {
        String home = homeInput.getText().toString();
        SharedPreferences.Editor editor = getSharedPreferences("my_data", MODE_PRIVATE).edit();
        editor.putString("MY_HOME", home);
        editor.apply();
        //hint na allazi otan patiete to koubi
        TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.hintguy2);
        String homes = prefs.getString("MY_HOME", "");
        textInputLayout.setHint(homes);
        Toast toast = Toast.makeText(this, "H Διεύθυνση Κατοικίας αποθηκεύτηκε επιτυχώς", Toast.LENGTH_SHORT);
        toast.show();
    }
}