package br.com.digitalhouse.desafio

data class ProfessorAdjunto (
    override val codigoProfessor: Int,
    override val nome: String,
    override val sobrenome: String,
    override val tempoDeCasa: Int,
    val quantidadeDeHoras: Int): Professor {
}