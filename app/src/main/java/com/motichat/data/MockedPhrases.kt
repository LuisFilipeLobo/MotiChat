package com.motichat.data

import com.motichat.infrastructure.MotiChatConstants
import kotlin.random.Random

data class Phrase(val categoryId: Int, val phrase: String)

class MockedPhrases {
    private val all = MotiChatConstants.FILTER.ALL
    private val happy = MotiChatConstants.FILTER.HAPPY
    private val sunny = MotiChatConstants.FILTER.SUNNY

    private val phrasesList = listOf<Phrase>(
        Phrase(happy, "Nada do que você faz importa, então por que se esforçar?"),
        Phrase(happy, "Você nunca será bom o suficiente, então é melhor nem tentar."),
        Phrase(happy, "O mundo é injusto e não importa o que você faça, nunca terá sucesso."),
        Phrase(happy, "Todos os seus sonhos são apenas ilusões inalcançáveis."),
        Phrase(happy, "Não importa o quanto você se dedique, sempre haverá alguém melhor do que você."),
        Phrase(happy, "As oportunidades são apenas para os sortudos, e você não é um deles."),
        Phrase(happy, "Você está destinado ao fracasso, então por que se preocupar em tentar?"),
        Phrase(happy, "Todas as suas falhas são prova de que você não tem talento ou habilidades suficientes."),
        Phrase(happy, "O mundo está contra você, então é melhor desistir agora e poupar-se da decepção."),
        Phrase(happy, "Você não tem controle sobre o seu próprio destino, então por que se preocupar em lutar?"),
        Phrase(happy, "Não há esperança, porque o mundo é um lugar cruel e desprovido de sentido."),
        Phrase(happy, "Cada passo que você dá é apenas uma confirmação de sua própria incompetência."),
        Phrase(happy, "Todos ao seu redor são melhores, mais inteligentes e mais talentosos do que você."),
        Phrase(happy, "Não há sentido em tentar, porque você nunca vai chegar a lugar nenhum."),
        Phrase(happy, "O sucesso é reservado apenas para os privilegiados, não para você."),
        Phrase(happy, "Você está fadado a uma existência medíocre e insignificante."),
        Phrase(happy, "Ninguém se importa com o que você faz, então por que se preocupar?"),
        Phrase(happy, "A vida é uma sequência interminável de fracassos e desilusões."),
        Phrase(happy, "Seus sonhos são apenas ilusões vazias destinadas a se desvanecer."),
        Phrase(happy, "Não importa o quanto você se esforce, o resultado sempre será decepcionante."),
        Phrase(sunny, "É na dor e no sofrimento que os teus te abandonam."),
        Phrase(sunny, "Voçê chegou até onde está graças à sua competência. Agora te vira!"),
        Phrase(sunny, "Na dúvida, duvide de si."),
        Phrase(sunny, "Deus deu dois rins. Pelo menos um é pra vender."),
        Phrase(sunny, "Aos que lhe desejam o mal, sucesso."),
        Phrase(sunny, "Se não puder fazer tudo, sinta-se culpado."),
        Phrase(sunny, "Seu pior pesadelo vai te visitar esta noite."),
        Phrase(sunny, "Não tente esconder a sua fraqueza. Você é insuficiente e todos ao seu redor podem ver."),
        Phrase(sunny, "Ninguém é feliz o tempo todo."),
        Phrase(sunny, "Deus olha por ti, já que ninguém mais olha."),
        Phrase(sunny, "Seu sofrimento pode ir embora hoje, mas a incerteza da sua volta sempre vai te atormentar."),
        Phrase(sunny, "Sua vida sempre foi um tédio desesperador. Aproveite o momento! É seu tempo de brilhar."),
        Phrase(sunny, "Bom dia! Lembrou do tempo que a vida era mais fácil? Nem eu!"),
    )

    /**
     * Essa função tem como finalidade retornar uma frase baseada na categoria escolhida pelo usuário.
     */
    fun getPhrase(value: Int): String {
        val filteredList = phrasesList.filter { it.categoryId == value || value == all }

        return filteredList[Random.nextInt(filteredList.size)].phrase
    }

}