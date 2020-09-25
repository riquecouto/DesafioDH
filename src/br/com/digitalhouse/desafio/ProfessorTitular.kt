package br.com.digitalhouse.desafio

data class ProfessorTitular (
    override val codigoProfessor: Int,
    override val nome: String,
    override val sobrenome: String,
    override val tempoDeCasa: Int,
    val especialidade: String): Professor {
}