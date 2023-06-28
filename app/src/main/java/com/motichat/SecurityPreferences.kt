package com.motichat

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {
    private val security: SharedPreferences =
        context.getSharedPreferences("MotiChat", Context.MODE_PRIVATE)

    /**
     * Esta função foi feita de forma genérica para salvar qualquer chave com qualquer valor.
     * Mas nesta aplicação servirá apenas para salvar o nome do usuário.
     */
    fun saveString(key: String, str: String) {
        security.edit().putString(key, str).apply()
    }

    /**
     * Esta função retorna o nome do usuário a partir de sua respectiva chave.
     * Caso não haja correspondência, retorna uma string vazia.
     */
    fun getString(key: String): String {
        return security.getString(key, "").orEmpty()
    }
}