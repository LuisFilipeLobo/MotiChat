package com.motichat.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.motichat.R
import com.motichat.databinding.ActivityMainBinding
import com.motichat.infrastructure.MotiChatConstants
import com.motichat.infrastructure.SecurityPreferences

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Esconder a action bar
        supportActionBar?.hide()

        binding.btnSave.setOnClickListener(this)

        // Verificar se o nome do usuário já foi informado
        verifyUsername()
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_save) {
            handleBtnSave()
        }
    }

    private fun handleBtnSave() {
        // Expressão regular para garantir que o nome do usuário possua apenas letras
        val regex = Regex("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+\$")
        val username = binding.editWhatsYourName.text.toString()

        if (username.matches(regex)) {
            // Salvar o nome do usuário
            SecurityPreferences(this).saveString(MotiChatConstants.KEY.USER_NAME, username)

            // Navegar para a próxima activity
            startActivity(Intent(this, UserActivity::class.java))
        } else {
            // Exibir mensagem de erro
            Toast.makeText(
                this, R.string.msg_error_invalid_username, Toast.LENGTH_SHORT
            ).show()
        }
    }

    /**
     * Essa função tem a finalidade de verificar se o usuário já forneceu seu nome anteriormente.
     * Se o nome do usuário tiver sido informado previamente, o usuário será redirecionado
     * diretamente para a UserActivity.
     */
    private fun verifyUsername() {
        val name = SecurityPreferences(this).getString(MotiChatConstants.KEY.USER_NAME)

        if (name != "") {
            startActivity(Intent(this, UserActivity::class.java))
            finish()
        }
    }

}