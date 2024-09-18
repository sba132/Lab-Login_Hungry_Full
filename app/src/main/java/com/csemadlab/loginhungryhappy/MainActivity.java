package com.csemadlab.loginhungryhappy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextPass;
    TextView textViewName, textViewPass;
    Button buttonSubmit, buttonReset, buttonNext;

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

        editTextName = findViewById(R.id.editTextName);
        editTextPass = findViewById(R.id.editTextPass);
        textViewName = findViewById(R.id.textViewName);
        textViewPass = findViewById(R.id.textViewPass);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonReset = findViewById(R.id.buttonReset);
        buttonNext = findViewById(R.id.buttonNext);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString();
                String pass = editTextPass.getText().toString();
                textViewName.setText("Name: " + name);
                textViewPass.setText("Password: " + pass);
                buttonNext.setVisibility(View.VISIBLE);
                editTextPass.onEditorAction(EditorInfo.IME_ACTION_DONE); //to hide keyboard
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextName.setText("");
                editTextPass.setText("");
                textViewName.setText("");
                textViewPass.setText("");
                editTextName.requestFocus(); //to set cursor, otherwise cursor remains in password
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivityHungry.class);
                startActivity(intent);
            }
        });
    }
}