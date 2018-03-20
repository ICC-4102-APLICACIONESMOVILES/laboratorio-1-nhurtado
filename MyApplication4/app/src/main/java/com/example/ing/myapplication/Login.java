package com.example.ing.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText e;
    EditText e2;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e= findViewById(R.id.editText);
        e2= findViewById(R.id.editText2);
        b= findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String m=e.getText().toString();
                String p=e2.getText().toString();

                if (m.matches("") || p.matches("")) {
                    Toast.makeText(getApplicationContext(), "You did not enter a email or password",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent=new Intent();
                intent.putExtra("M",m);
                intent.putExtra("P",p);
                setResult(1,intent);
                finish();
            }
        });
    }
}
