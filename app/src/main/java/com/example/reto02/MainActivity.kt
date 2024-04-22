package com.example.reto02

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var formButton: Button
    private lateinit var formName: EditText
    private lateinit var formSurname: EditText
    private lateinit var formPhoneNumber: EditText
    private lateinit var formEmail: EditText
    private lateinit var formResultImage: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        formButton = findViewById(R.id.form_button)
        formResultImage = findViewById(R.id.form_ResultImage)

        // Agregamos un listener al botón para escuchar cuando se presiona
        formButton.setOnClickListener {
            // Deshabilitamos el botón
            formButton.isEnabled = false
            // Hacemos el texto del botón invisible
            formButton.visibility = View.INVISIBLE

            // Verificar si los campos están vacíos
            val isEmpty = isFieldsEmpty()

            // Mostrar la imagen correspondiente
            if (isEmpty) {
                // Mostrar imagen de error
                formResultImage.setImageResource(R.drawable.error)
                formResultImage.visibility = View.VISIBLE
                formButton.isEnabled = true
                formButton.visibility = View.VISIBLE
            } else {
                // Mostrar imagen de paloma
                formResultImage.setImageResource(R.drawable.check)
                formResultImage.visibility = View.VISIBLE
                formButton.isEnabled = true
                formButton.visibility = View.VISIBLE
            }
        }
    }

    private fun isFieldsEmpty(): Boolean {
        // Verificar si los campos de texto están vacíos
        formName = findViewById(R.id.form_name)
        formSurname = findViewById(R.id.form_surname)
        formPhoneNumber = findViewById(R.id.form_phoneNumber)
        formEmail = findViewById(R.id.form_email)

        println(formName.text.isEmpty())

        return formName.text.isEmpty() || formSurname.text.isEmpty() || formPhoneNumber.text.isEmpty() || formEmail.text.isEmpty()
    }
}