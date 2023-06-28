package com.motichat

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.motichat.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)

        // Esconder a action bar
        supportActionBar?.hide()

        // Exibir nome do usuário
        handleUsername()

        setContentView(binding.root)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_new_phrase) {
            TODO("TODO")
        }
    }

    /**
     * Esta função vai exibir o nome de usuário informado
     */
    private fun handleUsername() {
        val username = SecurityPreferences(this).getString("USER_NAME")

        binding.textWelcome.text = "Olá, $username!"
    }
}