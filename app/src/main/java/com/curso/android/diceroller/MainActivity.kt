package com.curso.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

// Esta activity permite ao usuário rolar um dado e visualizar o resultado na tela.
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Apontando para a referência de botão button e chamando a função rollDice ao clicar
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    // Função criando um objeto Dice, lançando o dado e mostrando em textView
    private fun rollDice() {
        // Crie um novo objeto Dice com 6 lados e role-o
        val dice = Dice(6)
        val diceRoll: Int = dice.roll()

        // Atualize a tela com o lançamento de dados
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

// Criação da classe Dice (Dado)
class Dice(private val numSides: Int) {

    fun roll(): Int = (1..numSides).random()
}