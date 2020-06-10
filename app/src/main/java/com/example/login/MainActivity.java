package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button a_button;
    Button b_button;
    EditText a_username, a_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        a_button =  findViewById(R.id.a_button);
        a_username = findViewById(R.id.a_username);
        a_password = findViewById(R.id.a_password);
        b_button = (Button)findViewById(R.id.b_button);

        a_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Registraion.class);
                startActivity(intent);
            }
        });

        a_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserModel userModel;
                try {
                    userModel = new UserModel(-1, a_username.getText().toString(), Integer.parseInt(a_password.getText().toString()));
                    Toast.makeText(MainActivity.this, "Login in", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    userModel = new UserModel(-1, "Error", 0);
                }
                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                boolean success = databaseHelper.addOne(userModel);
                Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT ).show();
            }
        });

    }
}
