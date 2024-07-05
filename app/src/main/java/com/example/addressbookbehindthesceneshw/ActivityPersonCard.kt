package com.example.addressbookbehindthesceneshw

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class ActivityPersonCard : AppCompatActivity() {

    private var person: Person? = null

    private lateinit var titleOutputTB: Toolbar

    private lateinit var nameTV: TextView
    private lateinit var surNameTV: TextView
    private lateinit var addressTV: TextView
    private lateinit var phoneTV: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()

        nameTV.text = "Имя:\n${person?.name.toString()}"
        surNameTV.text = "Фамилия:\n${person?.surName.toString()}"
        addressTV.text = "Адрес:\n${person?.address.toString()}"
        phoneTV.text = "Телефон:\n${person?.phone.toString()}"

    }
    private fun init(){
        setContentView(R.layout.activity_person_card)
        titleOutputTB = findViewById(R.id.titleOutputTB)
        setSupportActionBar(titleOutputTB)
        title="Карточка контакта"
        titleOutputTB.setLogo(R.drawable.logo_contact)

        person = intent.extras?.getParcelable(Person::class.java.simpleName) as Person?

        nameTV = findViewById(R.id.nameTV)
        surNameTV = findViewById(R.id.surNameTV)
        addressTV = findViewById(R.id.addressTV)
        phoneTV = findViewById(R.id.phoneTV)
    }
}