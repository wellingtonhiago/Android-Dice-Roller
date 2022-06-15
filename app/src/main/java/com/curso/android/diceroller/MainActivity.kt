package com.curso.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

// Esta activity permite ao usuário rolar um dado e visualizar o resultado na tela.
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Apontando para a referência de botão button e chamando a função rollDice ao clicar
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // O dado é rolado quando abre o app
        rollDice()
    }

    // Função criando um objeto Dice, lançando o dado e mostrando em imageView
    private fun rollDice() {
        // Cria um novo objeto Dice com 6 lados e role-o
        val dice = Dice(6)
        val diceRoll: Int = dice.roll()


        val diceImage: ImageView = findViewById(R.id.imageView)

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
}

// Criação da classe Dice (Dado)
class Dice(private val numSides: Int) {

    fun roll(): Int = (1..numSides).random()

}