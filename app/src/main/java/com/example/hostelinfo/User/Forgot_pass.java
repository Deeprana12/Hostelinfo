package com.example.hostelinfo.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hostelinfo.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgot_pass extends AppCompatActivity {

    private EditText passwordEmail;
    private Button resetPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forgot_pass);

        passwordEmail=(EditText)findViewById(R.id.etPasswordemail);
        resetPassword=(Button)findViewById(R.id.btnPasswordReset);
        firebaseAuth=FirebaseAuth.getInstance();

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userEmail=passwordEmail.getText().toString().trim();

                if (userEmail.equals("")){

                    Toast.makeText(Forgot_pass.this,"Please enter your registered email Id",Toast.LENGTH_SHORT).show();
                }else {
                    firebaseAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Forgot_pass.this,"Password reset email sent!",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(Forgot_pass.this,Login.class));
                            }else {
                                Toast.makeText(Forgot_pass.this,"Error in sending password reset email",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}