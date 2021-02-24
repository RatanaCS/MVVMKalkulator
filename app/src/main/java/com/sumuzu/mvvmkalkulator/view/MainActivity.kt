package com.sumuzu.mvvmkalkulator.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sumuzu.mvvmkalkulator.R
import com.sumuzu.mvvmkalkulator.model.Hasil
import com.sumuzu.mvvmkalkulator.viewModel.ViewModelMainActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : ViewModelMainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel =ViewModelProviders.of(this).get(ViewModelMainActivity::class.java)

        btnProses.setOnClickListener {

            viewModel.onTambah(etBil1.text.toString(), etBil12.text.toString())


        }

        attachObserve()


    }

    private fun attachObserve() {

        viewModel.isHasil.observe(this, Observer {
            showHasil(it)
        })

        viewModel.isError.observe(this, Observer {
            showError(it)
        })

    }

    private fun showError(it: Boolean?) {
        if(it == true){
            Toast.makeText(applicationContext, "Bilangan harus diisi", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showHasil(it: Hasil?) {

        tvHasil.text = it?.result.toString()
    }
}