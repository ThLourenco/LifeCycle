package com.example.lifecycle.domain

import androidx.lifecycle.LiveData

interface CounterRepository {
    //interface CounterRepository: Está definindo uma interface chamada CounterRepository.
    fun getCounter(): LiveData<Int>
    //Este metodo define que qualquer classe que implemente essa interface deve
    //ter um metodo chamado getCounter, que retorna um LiveData contendo um Int. O LiveData é uma classe do Android
    //usada para observar dados de forma reativa.
    fun incrementCountBy(increment: Int)
    //fun incrementCountBy(incremet: Int): Este metodo define que a classe que implementa a interface deve fornecer uma
    // implementação para o metodo incrementCountBy, que recebe um parâmetro increment

    //Abstração: Interfaces ajudam a abstrair o comportamento, ou seja, as classes podem se concentrar no que precisam fazer sem se preocupar com a implementação interna de outros componentes.
    //Desacoplamento: Ao usar interfaces, você pode desacoplar a lógica de negócios da implementação real. Isso facilita a troca de implementações, como substituir uma implementação por outra (exemplo: usar uma versão de teste da interface durante os testes).
    //Testabilidade: Interfaces tornam mais fácil testar seu código, pois você pode criar "mocks" ou implementações alternativas para testar as interações com a interface.

    }