package br.com.digitalhouse.desafio

data class ProfessorAdjunto (
    override val nome: String,
    override val sobrenome: String,
    override val tempoDeCasa: Int,
    override val codigoProfessor: Int,
    val quantidadeDeHoras: String): Professor {
}