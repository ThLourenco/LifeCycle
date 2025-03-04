package com.example.lifecycle.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lifecycle.domain.CounterRepository

//Quando você declara uma classe como open, isso permite que ela seja herdada por outras classes. Se você não usar o open, a classe não pode ser estendida.
open class CounterRepositoryImpl:CounterRepository {
    //Sim, é obrigatório implementar os métodos definidos na interface. Se você não implementar os métodos da interface, o compilador gerará um erro.
    // No Kotlin, quando uma classe declara que implementa uma interface, ela deve fornecer a implementação de todos os métodos dessa interface, a menos que
    // a classe seja abstrata (usando abstract), e nesse caso, uma classe concreta que herdar dela deverá implementar os métodos.
    private var _counter = MutableLiveData(0)
    //metodo da interface
    override fun getCounter(): LiveData<Int> = _counter
    //metodo da interface
    override fun incrementCountBy(incremet: Int){
        //value pode ser nulo entao usamos o elvis operator sendo que se o number for nulo retonara zero
        val number = _counter.value ?: 0
        _counter.value = number + incremet
    }

}
