package com.example.calculadorademdias

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main)

        val botaoCacular = btnCalcular
        val resumo = txtResumo
        val resultado = txtResultado
        val dados = txtDados
        
        botaoCacular.setOnClickListener {

            try {

                val nota1 = Integer.parseInt(n1.text.toString())
                val nota2 = Integer.parseInt(n2.text.toString())
                val falta = Integer.parseInt(faltas.text.toString())

                val media = (nota1 + nota2)/2

                if ((nota1 >= 0 && nota1 <= 10) && (nota2 >= 0 && nota2 <= 10 ) && falta >=0 ){
                    if (media >= 7 && falta <= 10){

                        resumo.setText("Parabéns você foi :")
                        resultado.setText("Aprovado!!")
                        dados.setText("Nota final: " + media + "\nFaltas: "+ falta)

                        resultado.setTextColor(Color.GREEN)




                    }else{

                        resumo.setText("Infelizmente você foi :")
                        resultado.setText("Reprovado!!")
                        dados.setText("Nota final: " + media + "\nFaltas: "+ falta)

                        resultado.setTextColor(Color.RED)

                    }

                }

            }catch (e: Exception){
                resumo.setText("Insira corretamente os dados.")
                resultado.setText("Notas em uma escala de 0 a 10!!")
                dados.setText("Faltas maiores ou igual a 0 !")
                resultado.setTextColor(Color.RED)
                dados.setTextColor(Color.RED)
            }
        }
        
    }
}