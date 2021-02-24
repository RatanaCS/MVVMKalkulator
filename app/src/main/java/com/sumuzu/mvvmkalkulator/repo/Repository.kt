package com.sumuzu.mvvmkalkulator.repo

import com.sumuzu.mvvmkalkulator.model.Hasil

class Repository {

    //Bussines Logic
    val model = Hasil()

    fun tambah(bil1 : Int, bil2 : Int, result : (Hasil) -> Unit){

        model.result = bil1.plus(bil2)
        result(model)

    }

}