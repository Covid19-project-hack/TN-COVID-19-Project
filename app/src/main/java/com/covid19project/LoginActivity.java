package com.covid19project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class LoginActivity extends AppCompatActivity{

    private EditText Login_Phone_Number;
    private DatabaseReference mUsersDatabase;
    private FirebaseAuth mAuth;
    private FirebaseUser mFirebaseUser;
    private String mCurrentUserId, Code="+91";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Login_Phone_Number = findViewById(R.id.login_phone_number);


        findViewById(R.id.login_verify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String number = Login_Phone_Number.getText().toString().trim();

                if (number.isEmpty() || number.length() < 10) {
                    Login_Phone_Number.setError("Valid number is required");
                    Login_Phone_Number.requestFocus();
                    return;
                }
                Intent intent = new Intent(LoginActivity.this, VerifyActivity.class);
                intent.putExtra("phonenumber", Code+number);
                startActivity(intent);

            }
        });
    }

}

