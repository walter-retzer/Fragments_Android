package com.wdretzer.fragments01

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.RuntimeException

class Fragment_A : Fragment() {

    private lateinit var botao: Button
    private lateinit var editTextNome: EditText
    private lateinit var editTextIdade: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextSenha: EditText
    private lateinit var editTextConfirmaSenha: EditText

    private var listener: Fragment_A.IFragmentAListener? = null

    interface IFragmentAListener {

        fun enviarDadosA(dados: String)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment__a, container, false)

        botao = view.findViewById(R.id.bt_cadastrar)
        editTextNome = view.findViewById(R.id.editText_nome)
        editTextIdade = view.findViewById(R.id.editText_Idade)
        editTextEmail = view.findViewById(R.id.editText_Email)
        editTextSenha = view.findViewById(R.id.editText_Senha)
        editTextConfirmaSenha = view.findViewById(R.id.editText_Senha1)

        botao.setOnClickListener {

            // verifica se o e-mail e senha estão preenchidos:
            if (editTextNome.getText().length == 0 ||
                editTextIdade.getText().length == 0 ||
                editTextEmail.getText().length == 0 ||
                editTextSenha.getText().length == 0 ||
                editTextConfirmaSenha.getText().length == 0

            ) {
                // criando um push de aviso caso, haja campos não preenchidos:
                Toast.makeText(
                    getActivity(),
                    "Por Favor, verifique os dados digitados! \nHá Campos Não Preenchidos!",
                    Toast.LENGTH_LONG
                ).show()

            } else if (!editTextEmail.text.toString().contains("@") || !editTextEmail.text.toString().contains(".com")) {

                // criando um push de aviso caso, haja campos não preenchidos:
                Toast.makeText(
                    getActivity(),
                    "Por Favor, verifique o e-mail digitado!",
                    Toast.LENGTH_LONG
                ).show()

            } else if (editTextSenha.getText().length <= 5 || editTextConfirmaSenha.getText().length <= 5) {

                // criando um push de aviso caso, haja campos não preenchidos:
                Toast.makeText(
                    getActivity(),
                    "A senha deve conter 6 digitos!",
                    Toast.LENGTH_LONG
                ).show()

            } else if (editTextConfirmaSenha.text.toString() != editTextSenha.text.toString()) {

                // criando um push de aviso caso, haja campos não preenchidos:
                Toast.makeText(
                    getActivity(),
                    "Por Favor, verifique a senha digitada!",
                    Toast.LENGTH_LONG
                ).show()

            } else {
                // criando um push de aviso caso, os campos estiverem preenchidos:
                Toast.makeText(getActivity(), "Dados confirmados!", Toast.LENGTH_LONG).show()

                listener?.enviarDadosA(
                    editTextNome.text.toString() +
                            "; \nIdade: " + editTextIdade.text.toString() + "anos; " +
                            "\nE-mail: " + editTextEmail.text.toString()
                )
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is IFragmentAListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + "FragmentAListener não implementado")
        }
    }

}