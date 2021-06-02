package com.shashank.daggerwithroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shashank.daggerwithroom.Entity.Word
import com.shashank.daggerwithroom.ViewModel.WordViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var workViewmodel:WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter=WordAdapter(this)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=adapter


        workViewmodel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory(application)).get(WordViewModel::class.java)
        workViewmodel.allword.observe(this, Observer {

            adapter.update(it)
        })


        save.setOnClickListener {
            val word=Word(name.text.toString())
            workViewmodel.insertNode(word)

        }
    }
}