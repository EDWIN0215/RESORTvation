package com.example.resortvation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Proceedtoconfirm extends AppCompatActivity {

    Button mbtndetails;

//    EditText    editEmail, editPhonenumber, editFullname, editPassword;
//    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceedtoconfirm);

        mbtndetails = findViewById(R.id.btndetails);

        mbtndetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Profile.class));
            }
        });

//        editFullname = findViewById(R.id.editfullname);
//        editEmail = findViewById(R.id.editemail);
//        editPhonenumber = findViewById(R.id.editphonenumber);
//        editPassword = findViewById(R.id.password);
//
//        mAuth = FirebaseAuth.getInstance();





//
//    }

//    public void details(View view) {
//
//        String email, password;
//
//        email=editEmail.getText().toString().trim();
//        password=editPassword.getText().toString().trim();
//
//        mAuth.signInWithEmailAndPassword(email,password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful()){
//                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                            startActivity(intent);
//
//
//                        }else {
//                            Toast.makeText(Proceedtoconfirm.this, "invalid credentials", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
    }
}