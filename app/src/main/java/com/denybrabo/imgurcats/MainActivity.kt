package com.denybrabo.imgurcats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.GridLayoutManager
import com.denybrabo.imgurcats.adapter.DataAdapter
import com.denybrabo.imgurcats.databinding.ActivityMainBinding
import com.denybrabo.imgurcats.model.ImagesModel
import com.denybrabo.imgurcats.viewmodel.AnimalsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: AnimalsViewModel
    private var search = "cats"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        viewModel = ViewModelProvider(this).get()

        getAnimals()
        setListerners()

        setContentView(view)
    }

    fun getAnimals(){
        viewModel.getAnimals(search)?.observe(this, Observer {
            Toast.makeText(applicationContext, "Aguarde...", Toast.LENGTH_LONG).show()
            binding.recyclerView.adapter = DataAdapter(it.data)
            binding.recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
        })

    }

    fun setListerners(){
        binding.button.setOnClickListener {
            search = binding.searchAnimals.text.toString()
            getAnimals()
        }
    }

}