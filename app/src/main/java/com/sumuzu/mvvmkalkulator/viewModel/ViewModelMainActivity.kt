package com.sumuzu.mvvmkalkulator.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sumuzu.mvvmkalkulator.model.Hasil
import com.sumuzu.mvvmkalkulator.repo.Repository

class ViewModelMainActivity : ViewModel(){

    val repository = Repository()

    var isHasil = MutableLiveData<Hasil>()
    var isError = MutableLiveData<Boolean>()

    fun onTambah(bil1 : String, bil2 : String){

        if(bil1.isEmpty() || bil2.isEmpty()){
            isError.value = true
        }else{
            repository.tambah(bil1.toInt(), bil2.toInt()){
                isHasil.value = it
            }
        }



    }

}