package com.example.lifecycle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lifecycle.apresentation.counter.MainViewModel
import com.example.lifecycle.data.CounterRepositoryImpl

class ViewModelFactory: ViewModelProvider.Factory {
    //classe responsvel por fabricar a viewmodel
    //No Android, a ViewModelProvider.Factory é uma interface usada para criar instâncias de ViewModel de forma personalizada. O ViewModelProvider é responsável por fornecer instâncias de ViewModel de uma forma que seja compatível com o ciclo de vida da Activity ou Fragment.
    //
    //Por padrão, o ViewModelProvider usa um construtor sem argumentos para criar uma instância de ViewModel.
    // No entanto, se você precisar passar parâmetros para o seu ViewModel (por exemplo, dependências
    // como repositórios ou outros objetos), você pode criar uma fábrica personalizada implementando a interface
    // ViewModelProvider.Factory.

    //Quando usar?
    //Você usa o ViewModelProvider.Factory quando precisa criar um ViewModel que não pode ser instanciado sem
    // argumentos ou quando precisa passar dependências extras para o ViewModel que o construtor padrão não pode fornecer.
    //
    //Por exemplo, se seu ViewModel precisa de um repositório, você pode criar a fábrica para fornecer esse repositório.

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass == MainViewModel::class.java){
            return MainViewModel(repository = CounterRepositoryImpl()) as T
        }

        if(modelClass == SecondViewModel::class.java){
            return SecondViewModel() as T
        }

        //No Kotlin, o throw é usado para lançar (ou "disparar") uma exceção. Quando você usa throw, você está
        // informando que algo inesperado ou errôneo ocorreu e que o controle do programa deve ser interrompido.
        // Isso é útil para lidar com situações de erro, como quando um argumento inválido é passado ou quando o
        // código encontra um estado inconsistente.
        throw IllegalArgumentException("unknow ViewModel instavne for $modelClass")
        //O que o throw faz?
        //Quando você usa throw, você está criando uma instância de uma exceção e a lançando para ser tratada.
        // Esse processo de lançamento de exceção interrompe a execução do código normal e permite que você capture e
        // trate a exceção em outro lugar (por exemplo, em um bloco try-catch).
    }
}