package com.motichat.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.motichat.R
import com.motichat.databinding.ActivityUserBinding
import com.motichat.infrastructure.MotiChatConstants
import com.motichat.infrastructure.SecurityPreferences

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding
    private var categoryId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)

        // Esconder a action bar
        supportActionBar?.hide()

        // Exibir nome do usuário
        handleUsername()

        // Iniciar com o ícone All Inclusive selecionado
        handleFilter(R.id.ic_all_inclusive)

        // Eventos de click
        binding.icAllInclusive.setOnClickListener(this)
        binding.icHappy.setOnClickListener(this)
        binding.icSunny.setOnClickListener(this)

        setContentView(binding.root)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_new_phrase) {
            TODO("TODO")
        } else if (view.id in listOf(R.id.ic_all_inclusive, R.id.ic_happy, R.id.ic_sunny)) {
            handleFilter(view.id)
        }
    }

    /**
     * Esta função vai exibir o nome de usuário informado
     */
    private fun handleUsername() {
        val username = SecurityPreferences(this).getString(MotiChatConstants.KEY.USER_NAME)

        binding.textWelcome.text = "Olá, $username!"
    }

    /**
     * Essa função tem como finalidade selecionar um dos três ícones do cabeçalho, alterando sua
     * cor e a dos outros dois.
     */
    private fun handleFilter(id: Int) {
        binding.icAllInclusive.setColorFilter(ContextCompat.getColor(this, R.color.pink))
        binding.icHappy.setColorFilter(ContextCompat.getColor(this, R.color.pink))
        binding.icSunny.setColorFilter(ContextCompat.getColor(this, R.color.pink))

        when (id) {
            R.id.ic_all_inclusive -> {
                binding.icAllInclusive.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotiChatConstants.FILTER.ALL
            }

            R.id.ic_happy -> {
                binding.icHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotiChatConstants.FILTER.HAPPY
            }

            R.id.ic_sunny -> {
                binding.icSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotiChatConstants.FILTER.SUNNY
            }
        }
    }

}