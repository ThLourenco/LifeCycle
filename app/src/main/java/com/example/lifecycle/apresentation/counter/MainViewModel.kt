package com.example.lifecycle.apresentation.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lifecycle.data.CounterRepositoryImpl
import com.example.lifecycle.domain.CounterRepository

class MainViewModel(
        //nossa depedencia do model
        private val repository: CounterRepository
): ViewModel() {
    //🛠 Como funciona?
    //MutableLiveData pode armazenar qualquer tipo de dado (String, Int, List, etc.).
    //Ele notifica automaticamente todos os observadores sempre que o valor muda.
    //Muito usado em conjunto com ViewModel para gerenciar estados da UI de forma segura.
        //PROGAM
    //private var _counter = MutableLiveData(0)
    //val counter: LiveData<Int> = _counter

    val counter: LiveData<Int> = repository.getCounter()

     var incrementBy = 1

    //BOAS PRATICAS
    //private var counter = 0
    //   private set
    //Torna o setter privado, ou seja, só pode ser modificado dentro da própria classe.
    //O getter continua público, então outros arquivos ou classes podem ler o valor de counter, mas não podem alterá-lo diretamente.
    //Resumo:
    //private set impede que a variável seja alterada fora da classe.
    //O valor pode ser lido normalmente (getter público).
    //A única forma de modificar counter é através de métodos dentro da própria classe (incrementar() no exemplo).

    fun increment(){
      repository.incrementCountBy(incrementBy)


    }
}

/*
class NumberLiveData(initial: Int = 0): MutableLiveData<Int>(initial) {
    override fun onActive() {
        super.onActive()
        Log.d("MainViewModel", "onActive")
    }

    override fun onInactive() {
        super.onInactive()
        Log.d("MainViewModel", "onInactive")
    }
}*/
    //Cria uma classe chamada NumberLiveData que herda de MutableLiveData<Int>.
    //Aceita um valor inicial (initial), que por padrão é 0.
    //1️⃣ Otimização de Recursos: Podemos usar onActive() para iniciar alguma operação quando a UI precisa de dados (exemplo: iniciar uma requisição de API).
//2️⃣ Evitar Processamento Desnecessário: onInactive() pode ser usado para parar operações pesadas quando não há observadores (exemplo: cancelar um timer ou desconectar um WebSocket).
//3️⃣ Depuração: Ajuda a entender quando os dados estão sendo observados.