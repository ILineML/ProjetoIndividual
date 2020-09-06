package com.example.projetoindividual

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcularMedia(view : View) {
        if(!validateFields()) {
            return;
        }

        val name = txtName.text;
        val n1 = txtN1.text.toString().toDouble();
        val n2 = txtN2.text.toString().toDouble();
        val point = chckPoint.isChecked;

        println("Aluno possui ponto extra? $point");

        val somaN = n1 + n2;
        val media = (if(somaN < 20 && point) somaN + 1 else somaN) / 2;

        var result = "O aluno $name, passou de semestre com uma média igual a $media";
        var textColor = Color.GREEN;

        if(media in 0.0..4.99) {
            result = "O aluno $name, reprovou de semestre com uma média igual a $media";
            textColor = Color.RED;
        }

        lblResult.text = result;
        lblResult.setTextColor(textColor);
    }

    fun validateFields(): Boolean {
        if(TextUtils.isEmpty(txtName.text) || TextUtils.isEmpty(txtN1.text) || TextUtils.isEmpty(txtN2.text)) {
            Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
            return false;
        }

        var isValid = true;
        val n1 = txtN1.text.toString().toDouble();
        val n2 = txtN2.text.toString().toDouble();

        if(n1 < 0 || n1 > 10) {
            txtN1.error = "Permitido apenas números entre 0 a 10";
            isValid = false;
        } else if(n2 < 0 || n2 > 10) {
            txtN2.error = "Permitido apenas números entre 0 a 10";
            isValid = false;
        }
        return isValid;
    }

}