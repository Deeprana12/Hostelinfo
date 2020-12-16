package com.example.hostelinfo.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hostelinfo.Dashboard.MainActivity;
import com.example.hostelinfo.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    Button CallSignUp,login_btn,forget_password;
    ImageView image;
    TextView logotext;
    TextInputLayout regEmail,regPassword;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        CallSignUp=findViewById(R.id.signup_screen);
        image=findViewById(R.id.logoImage);
        logotext=findViewById(R.id.logo_name);
        regEmail = findViewById(R.id.reg_Email);
        regPassword=findViewById(R.id.reg_password);
        login_btn=findViewById(R.id.login_btn);
        forget_password=findViewById(R.id.Forget_password);

        firebaseAuth = FirebaseAuth.getInstance();
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String memail=regEmail.getEditText().getText().toString();
                String mpassword=regPassword.getEditText().getText().toString();

                if (TextUtils.isEmpty(memail)){
                    Toast.makeText(Login.this,"Please enter your email",Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(mpassword)){
                    Toast.makeText(Login.this,"Please enter your password",Toast.LENGTH_SHORT).show();
                }

                firebaseAuth.signInWithEmailAndPassword(memail,mpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                     if(task.isSuccessful()){
                         Toast.makeText(Login.this,"Success",Toast.LENGTH_SHORT).show();
                         startActivity(new Intent(Login.this, MainActivity.class));
                     }else{
                         Toast.makeText(Login.this,"Failed",Toast.LENGTH_SHORT).show();
                     }

                    }
                });

            }
        });


        CallSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Signup.class));
            }
        });


        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Forgot_pass.class));
            }
        });
    }
}