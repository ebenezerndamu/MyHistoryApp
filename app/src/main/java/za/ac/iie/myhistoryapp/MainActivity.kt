package za.ac.iie.myhistoryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var btnEnter: Button
    private lateinit var inputAge: EditText
    private lateinit var tvFigure: TextView
    private lateinit var tvDeath1: TextView

    private var historicalFigures = listOf(
        HistoricalFigures("Micheal Jackson", 50),
        HistoricalFigures("Mbongeni Ngema", 68),
        HistoricalFigures("Zahara Alias Mkutukana", 36),
        HistoricalFigures("Derek Nail Watts", 74),
        HistoricalFigures("James Alexander", 45),
        HistoricalFigures("Betty White", 99),
        HistoricalFigures("Bob Hope", 100),
        HistoricalFigures("Chuck Berry", 90),
        HistoricalFigures("Marlon Brando", 80),
        HistoricalFigures("Fatima Sydow", 50)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEnter = findViewById(R.id.btnEnter)
        inputAge = findViewById(R.id.inputAge)
        tvFigure = findViewById(R.id.tvFigure)
        tvDeath1 = findViewById(R.id.tvDeath1)

        btnEnter.setOnClickListener {
            val enteredAge = inputAge.text.toString().toIntOrNull()

            if (enteredAge != null) {
                val matchingFigure = historicalFigures.find { it.age == enteredAge }
                if (matchingFigure != null) {
                    tvFigure.text = matchingFigure.name
                    tvDeath1.text = "(${matchingFigure.age})"
                } else {
                    tvFigure.text = "No historical figure matches this age in the list"
                    tvDeath1.text = " $enteredAge"
                }
            } else {
                tvFigure.text = ""
                tvDeath1.text = "Please enter name, surname, and age"
            }
        }
    }

    private data class HistoricalFigures(val name: String, val age: Int)
}
