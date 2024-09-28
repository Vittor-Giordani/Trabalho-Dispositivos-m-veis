package com.example.seuapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabalho.R;

public class MainActivity extends AppCompatActivity {

    private EditText editNome, editGmail, editIdade, editDisciplina, editNota1, editNota2;
    private Button btnCalcular;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.editNome);
        editGmail = findViewById(R.id.editGmail);
        editIdade = findViewById(R.id.editIdade);
        editDisciplina = findViewById(R.id.editDisciplina);
        editNota1 = findViewById(R.id.editNota1);
        editNota2 = findViewById(R.id.editNota2);
        btnCalcular = findViewById(R.id.btnCalcular);
        textResultado = findViewById(R.id.textResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular_Media();
            }
        });
    }

    private void calcular_Media() {
        String nome = editNome.getText().toString();
        String gmail = editGmail.getText().toString();
        String idadeStr = editIdade.getText().toString();
        String disciplina = editDisciplina.getText().toString();
        String nota1Str = editNota1.getText().toString();
        String nota2Str = editNota2.getText().toString();

        if (nome.isEmpty() || gmail.isEmpty() || idadeStr.isEmpty() || disciplina.isEmpty() || nota1Str.isEmpty() || nota2Str.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        double nota1 = Double.parseDouble(nota1Str);
        double nota2 = Double.parseDouble(nota2Str);
        double media = (nota1 + nota2) / 2;

        textResultado.setText("Sua Média é: " + media);
    }
}
