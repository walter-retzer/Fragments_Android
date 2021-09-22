package com.wdretzer.fragments01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(),
    Fragment_A.IFragmentAListener {

    // instancias as variaveis dos fragmentos:
    private lateinit var fragmentA: Fragment_A
    private lateinit var fragmentB: Fragment_B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragments()
    }

    // função de inicialização dos Fragments:
    private fun initFragments() {
        fragmentA = Fragment_A()
        fragmentB = Fragment_B()

        // Para incluir um fragment de tela dentro de uma Activity,
        // precisamos realizar a transação, fazer o replace e comitar:
        val fragmentManager = supportFragmentManager  // fragmentManager é o responsável por gerenciar os fragments
        val fragmentTransaction = fragmentManager.beginTransaction() // iniciando a transação

        // conteiner_a é o id do Frame no xml da activity_main:
        fragmentTransaction.replace(R.id.container_a, fragmentA)
        // conteiner_b é o id do Frame no xml da activity_main:
        fragmentTransaction.replace(R.id.container_b, fragmentB)
        fragmentTransaction.commit()
    }


    override fun enviarDadosA(dados: String) {
        fragmentB.atualizaB(dados)
    }


}