package com.wdretzer.fragments01

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import java.lang.RuntimeException

class Fragment_B : Fragment() {

    private lateinit var editText: EditText

    //private var listener: Fragment_B.IFragmentBListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment__b, container, false)

        editText = view.findViewById(R.id.et_fragment_b)

        return view
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    fun atualizaB(dados: String) {
        editText.setText("Seja Bem-Vindo: " + dados)
    }

    override fun onDetach() {
        super.onDetach()
    }
}