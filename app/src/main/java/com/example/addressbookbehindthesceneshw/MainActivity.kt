package com.example.addressbookbehindthesceneshw

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var personsList: MutableList<Person> = mutableListOf()

    private lateinit var nameET: EditText
    private lateinit var surNameET: EditText
    private lateinit var addressET: EditText
    private lateinit var phoneET: EditText

    private lateinit var saveBTN: Button
    private lateinit var personListLV: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, personsList)
        personListLV.adapter = adapter

        saveBTN.setOnClickListener{
            if(
                nameET.text.isEmpty() || surNameET.text.isEmpty()
                || addressET.text.isEmpty() || phoneET.text.isEmpty()
            ) return@setOnClickListener

            personsList.add(Person(
                nameET.text?.toString(),
                surNameET.text?.toString(),
                addressET.text?.toString(),
                phoneET.text?.toString()))
            adapter.notifyDataSetChanged()
            nameET.text.clear()
            surNameET.text.clear()
            addressET.text.clear()
            phoneET.text.clear()
        }

        personListLV.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val note = adapter.getItem(position)
                val intent = Intent(this,ActivityPersonCard::class.java)
                intent.putExtra(Person::class.java.simpleName, note)
                startActivity(intent)
            }
    }

    private fun init() {
        setContentView(R.layout.activity_main)
        nameET = findViewById(R.id.nameET)
        surNameET = findViewById(R.id.surNameET)
        addressET = findViewById(R.id.addressET)
        phoneET = findViewById(R.id.phoneET)
        saveBTN = findViewById(R.id.saveBTN)
        personListLV = findViewById(R.id.personListLV)
    }
}