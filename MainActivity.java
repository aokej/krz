package com.example.nazwa;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        Button zarejstruj = findViewById(R.id.zarejsestruj);
        zarejstruj.setOnClickListener(v -> {
            EditText imie1 = findViewById(R.id.imie);
            EditText nazwisko1 = findViewById(R.id.nazwisko);
            EditText email1 = findViewById(R.id.email);
            EditText haslo1 = findViewById(R.id.haslo);

            String imie = imie1.getText().toString();
            String nazwisko = nazwisko1.getText().toString();
            String email = email1.getText().toString();
            String haslo = haslo1.getText().toString();
            imie = imie.trim();
            nazwisko = nazwisko.trim();
            email = email.trim();
            haslo = haslo.trim();

            if(walidacja(imie,nazwisko,email,haslo)){
                Toast.makeText(this, "dane sa poprawne", Toast.LENGTH_SHORT).show();
            }
        });


    }
    public boolean walidacja(String imie, String nazwisko, String email, String haslo){
        if(imie.isEmpty() || nazwisko.isEmpty() || email.isEmpty() || haslo.isEmpty()){
            Toast.makeText(this, "wypelnij wszystkie pola!!!", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            if(!email.contains("@") || !email.contains(".")){
                Toast.makeText(this, "zly email", Toast.LENGTH_SHORT).show();
                return false;
            }else{
                if(haslo.length() < 8 || !haslo.matches(".*[a-z].*") || !haslo.matches(".*[A-Z].*") || !haslo.matches(".*[^a-zA-Z0-9]*.")){
                    Toast.makeText(this, "tragiczne haslo", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        }
        return true;


    }

}
