package e.android.dwiratna_1202150258_modul6;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    private EditText username, password;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        firebaseAuth = FirebaseAuth.getInstance();
    }
    public void Daftar(View view) {
        (firebaseAuth.createUserWithEmailAndPassword(username.getText().toString(), password.getText().toString())).addOnCompleteListener
                (new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(login.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(login.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
    public void Login(View view) {
        (firebaseAuth.signInWithEmailAndPassword(username.getText().toString(), password.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(login.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(login.this, HomeActivity.class);
                            startActivity(intent);
                        }else{
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(login.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
