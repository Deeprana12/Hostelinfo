package com.example.hostelinfo.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import com.example.hostelinfo.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Signup extends AppCompatActivity {

    TextInputLayout regName,regUsername,regEmail,regPassword;
    Button reg_btn,reg_login_btn;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);
        firebaseAuth = FirebaseAuth.getInstance();


        regName=(TextInputLayout)findViewById(R.id.name);
        regUsername=(TextInputLayout)findViewById(R.id.username);
        regEmail=(TextInputLayout)findViewById(R.id.email);
        regPassword=(TextInputLayout)findViewById(R.id.password);
        reg_btn=(Button)findViewById(R.id.reg_btn);
        reg_login_btn=(Button)findViewById(R.id.reg_login_btn);

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fullName=regName.getEditText().getText().toString();
                String userName=regUsername.getEditText().getText().toString();
                String Email=regEmail.getEditText().getText().toString();
                String password=regPassword.getEditText().getText().toString();

//                if(firebaseAuth.getCurrentUser() != null){
//                    startActivity(new Intent(Signup.this,Login.class));
//                    finish();
//                }

                if (TextUtils.isEmpty(fullName)){
                    Toast.makeText(Signup.this,"Please enter your fullName",Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(userName)){
                    Toast.makeText(Signup.this,"Please enter your userName",Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(Email)){
                    Toast.makeText(Signup.this,"Please enter your email",Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Signup.this,"Please enter your password",Toast.LENGTH_SHORT).show();
                }

                Student helperClass=new Student(fullName,Email);

                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference reference = db.getReference("students");
                reference.child(userName).setValue(helperClass);

                firebaseAuth.createUserWithEmailAndPassword(Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Toast.makeText(Signup.this,"Success",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Signup.this,Login.class));
                        }else{
                            Toast.makeText(Signup.this,"Failed",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });

        reg_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Signup.this,Login.class));
                finish();
            }
        });



    }

//    public void registerUser(View view) {
//
//            String name =regName.getEditText().getText().toString();
//            String username = regUsername.getEditText().getText().toString();
//            String email = regEmail.getEditText().getText().toString();
//
//            Student helperClass=new Student(name,username,email);
//
//            FirebaseDatabase db = FirebaseDatabase.getInstance();
//
//            DatabaseReference reference = db.getReference();
//
//            reference.child(username).setValue(helperClass);
//
//    }
}