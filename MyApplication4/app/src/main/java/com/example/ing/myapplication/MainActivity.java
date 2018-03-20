package com.example.ing.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button b;
    private TextView t;
    private TextView t2;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t= findViewById(R.id.textView);
        t2= findViewById(R.id.textView2);
        b = findViewById(R.id.Button);
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String restoredText = prefs.getString("email", null);
        if (restoredText != null) {
            String email = prefs.getString("email", "");
            String pass = prefs.getString("pass", "");
            t.setText("name:"+email);
            t2.setText("password:"+pass);
        }
        else
        {
            Intent intent = new Intent(this, Login.class);
            startActivityForResult(intent,1);
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logout();
            }
        });
    }

    public void Logout(){
        t.setText("");
        t2.setText("");
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.clear();
        editor.apply();
        Intent intent = new Intent(this, Login.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int request, int result, Intent data)
    {
        super.onActivityResult(request, result, data);
        if(request==1)
        {
            String email=data.getStringExtra("M");
            String pass=data.getStringExtra("P");
            SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
            editor.putString("email", email);
            editor.putString("pass", pass);
            editor.apply();
            t.setText("name:"+email);
            t2.setText("password:"+pass);
        }

    }

}
